package com.blog_app.controller;

import com.blog_app.model.Author;
import com.blog_app.model.Blog;
import com.blog_app.model.Category;
import com.blog_app.model.Summary;
import com.blog_app.service.IAuthorService;
import com.blog_app.service.IBlogService;
import com.blog_app.service.ICategoryService;
import com.blog_app.service.ISummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.time.LocalDate;

@Controller
@RequestMapping("/my-blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private ISummaryService summaryService;
    @Autowired
    private IAuthorService iAuthorService;

//    @GetMapping("")
//    public String showList(Model model) {
//        model.addAttribute("blogs", blogService.displayAll());
//        return "list";
//    }

    @GetMapping("/showCreateForm")
    public String addNew(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("authors", iAuthorService.authors());
        model.addAttribute("categories", categoryService.showListCategory());
        return "blog/create";
    }

    @PostMapping("/save")
    public String save(Blog blog, RedirectAttributes redirectAttributes) {
        Summary summary = summaryService.save(blog.getSummary());
        Category category = categoryService.save(blog.getCategory());
        Author author = iAuthorService.save(blog.getAuthor());
        blog.setSummary(summary);
        blog.setAuthor(author);
        blog.setCategory(category);
        blog.setDatePost(Date.valueOf(LocalDate.now()));
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công!");
        return "redirect:/my-blog/list";
    }



    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        Summary summary = summaryService.save(blog.getSummary());
        blog.setSummary(summary);
        blog.setDatePost(Date.valueOf(LocalDate.now()));
        boolean result = blogService.update(blog.getId(), blog);
        if (result == true) {
            redirectAttributes.addFlashAttribute("message", "Chỉnh sửa thành công!");
        } else {
            redirectAttributes.addFlashAttribute("message", "Chỉnh sửa thất bại!");
        }
        return "redirect:/my-blog/list";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        boolean status = blogService.deleteById(id);
        if (status) {
            redirectAttributes.addFlashAttribute("message", "Xóa thành công!");
        } else {
            redirectAttributes.addFlashAttribute("message", "Xóa bị lỗi!");
        }
        return "redirect:/my-blog/list";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        Blog blog =blogService.findById(id);
        model.addAttribute("blog",blog);
        return "/blog/view";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView showList(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "") String searchName) {
        Pageable pageable = PageRequest.of(page, 2, Sort.by("title").ascending());
        Page<Blog> blogPage = blogService.findAll(pageable,searchName);
        ModelAndView modelAndView = new ModelAndView("/blog/list");
        modelAndView.addObject("blogs",blogPage);
        modelAndView.addObject("searchName",searchName);
        return modelAndView;
    }
}
