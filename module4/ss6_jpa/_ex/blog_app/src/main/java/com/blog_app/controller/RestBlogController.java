package com.blog_app.controller;

import com.blog_app.model.Blog;
import com.blog_app.model.Category;
import com.blog_app.service.IBlogService;
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
@RequestMapping("/api/blog")
@CrossOrigin("*")
public class RestBlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;
    @GetMapping("")
    public ResponseEntity<Page<Blog>> showList(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "") String searchName,@RequestParam(defaultValue = "2") int size) {
        Pageable pageable = PageRequest.of(page,size,Sort.by("datePost").ascending());
        Page<Blog> blogPage = blogService.findAll(pageable,searchName);
        if(blogPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Page<Blog>> showBlogWithCategory(@RequestParam(defaultValue = "0") int page, @PathVariable int id) {
        Pageable pageable = PageRequest.of(page,2, Sort.by("title").ascending());
        Category category = categoryService.findById(id);
        Page<Blog> blogPage = blogService.getBlogsByCategory(pageable,category);
        if (blogPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage,HttpStatus.OK);
    }

}
