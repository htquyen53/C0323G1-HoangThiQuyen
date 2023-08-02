package com.blog_app.controller;

import com.blog_app.model.Category;
import com.blog_app.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<Page<Category>> showList(@RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 2, Sort.by("categoryName").ascending());
        Page<Category> categoryPage = categoryService.showAllCategory(pageable);
        if (categoryPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryPage, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> add(@RequestBody Category category) {
        if (categoryService.findByName(category.getCategoryName()) != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        categoryService.save(category);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findCategoryById(@PathVariable int id) {
        if (categoryService.findById(id) != null) {
            return new ResponseEntity<>(categoryService.findById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("")
    public ResponseEntity<?> delete(@RequestParam int id) {
        Category category = categoryService.findById(id);
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        categoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<?> update(@RequestParam int id, @RequestBody Category category) {
        if (categoryService.update(id, category)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
