package com.kornevstas.WebBlog.controllers;

import com.kornevstas.WebBlog.models.Post;
import com.kornevstas.WebBlog.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/")
    public String home(Model model) {
//        model.addAttribute("title", "Main page");
//        return "home";

        List<Post> popularPosts = postRepository.findTop3ByOrderByViewsDesc();
        model.addAttribute("popularPosts", popularPosts);
        model.addAttribute("title", "Home");
        return "home"; // назва HTML шаблону головної сторінки
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "About Us Page");
        return "about";
    }

}
