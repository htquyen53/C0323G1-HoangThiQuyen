package com.example.cartmanagement.controller;

import com.example.cartmanagement.dto.CartDto;
import com.example.cartmanagement.dto.ProductDto;
import com.example.cartmanagement.model.Product;
import com.example.cartmanagement.service.IProductService;
import com.example.cartmanagement.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
@RequestMapping("/product")
//Tạo session tên cart
@SessionAttributes("cart")
public class ProductController {
    //Mapping biến cart và biến session cart
    @ModelAttribute("cart")
    public CartDto initCart() {
        return new CartDto();
    }

    @Autowired
    private IProductService productService;

    @GetMapping("/list")
    public ModelAndView showListPage(Model model, @SessionAttribute(value = "cart", required = false) CartDto cartDto,
                                     @CookieValue(value = "productId", required = false, defaultValue = "-1") Long id,
                                     @RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "") String searchName) {
        // Hiển thị danh sách sản phẩm (phân trang)
        Pageable pageable = PageRequest.of(page, 5, Sort.by("name").ascending());
        Page<Product> productPage = productService.showList(pageable, searchName);
        ModelAndView modelAndView = new ModelAndView("product/list");
        modelAndView.addObject("productPage", productPage);
        modelAndView.addObject("searchName", searchName);
        // Hiển thị sp gần nhất
        Product product = productService.findByiD(id).orElse(null);
        model.addAttribute("historyProduct", product);
        if (cartDto != null) {
            model.addAttribute("cart", cartDto);
        }
        return modelAndView;
    }

    @GetMapping("detail/{id}")
    public ModelAndView showDetail(@PathVariable long id, HttpServletResponse response) {
        Cookie cookie = new Cookie("productId", id + "");
        cookie.setMaxAge(1 * 24 * 60 * 60);
        cookie.setPath("/");
        return new ModelAndView("product/detail", "product", productService.findByiD(id).orElse(null));
    }

    //    Thêm vào giỏ hàng
    @GetMapping("add/{id}")
    public String addToCart(@PathVariable Long id, @SessionAttribute(value = "cart") CartDto cart) {
        Optional<Product> productOptional = productService.findByiD(id);
        Product product = null;
        if (productOptional.isPresent()) {
            product = productOptional.get();
        }
        if (product != null) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product, productDto);
            cart.addProduct(productDto);
        }
        return "redirect:/cart";
    }
}
