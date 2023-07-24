package com.product_management.controller;

import com.product_management.model.Product;
import com.product_management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("products", productService.displayAll());
        return "list";
    }

    @GetMapping("/showCreateForm")
    public String addNew(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/save")
    public String save(Product product, RedirectAttributes redirectAttributes) {
        productService.save(product);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công!");
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        boolean result = productService.update(product.getId(), product);
        if (result == true) {
            redirectAttributes.addFlashAttribute("message", "Chỉnh sửa thành công!");
        } else {
            redirectAttributes.addFlashAttribute("message", "Chỉnh sửa thất bại!");
        }
        return "redirect:/product";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        boolean result = productService.remove(id);
        if (result == true) {
            redirectAttributes.addFlashAttribute("message", "Xóa thành công!");
        } else {
            redirectAttributes.addFlashAttribute("message", "Xóa thất bại!");
        }
        return "redirect:/product";
    }
    @PostMapping("/search")
    public String search(@RequestParam String searchName, Model model){
        List<Product> products = productService.findByName(searchName);
        model.addAttribute("products", products);
        model.addAttribute("searchName",searchName);
        return "list";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "view";
    }
}


