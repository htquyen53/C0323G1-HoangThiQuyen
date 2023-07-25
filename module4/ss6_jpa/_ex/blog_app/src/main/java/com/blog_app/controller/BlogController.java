package com.blog_app.controller;

import com.blog_app.model.Blog;
import com.blog_app.service.IBlogService;
import com.blog_app.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/my-blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;
    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("blogs",blogService.displayAll());
        return "list";
    }
    @GetMapping("/showCreateForm")
    public String addNew(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categories",categoryService.showAllCategory());
        return "create";
    }

    @PostMapping("/save")
    public String save(Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công!");
        return "redirect:/list";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("blog",blogService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        boolean result = blogService.update(blog.getId(), blog);
        if (result == true) {
            redirectAttributes.addFlashAttribute("message", "Chỉnh sửa thành công!");
        } else {
            redirectAttributes.addFlashAttribute("message", "Chỉnh sửa thất bại!");
        }
        return "redirect:/my-blog";
    }
}
