package com.example.testbackend.controller;

import com.example.testbackend.model.Product;
import com.example.testbackend.service.IProductService;
import com.example.testbackend.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@CrossOrigin("*")
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private IProductTypeService productTypeService;

    @GetMapping("")
    public ResponseEntity<Page<Product>> showList(@RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "") String searchName,
                                                  @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, 5, Sort.by("id").ascending());
        Page<Product> productPage = productService.findAll(pageable, searchName);
        if (productPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productPage, HttpStatus.OK);
    }
}
