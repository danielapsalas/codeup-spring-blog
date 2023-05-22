package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }


    @RequestMapping("/posts")
    public String posts(Model model) {


        model.addAttribute("posts", postDao.findAll());

        return "posts/index";
    }

    @RequestMapping("/posts/{id}")
    public String postsid(@PathVariable Long id, Model model) {
        model.addAttribute("posts", postDao.findById(id));

        return "posts/show";
    }

    @RequestMapping("/posts/create")
    public String createPostForm() {
        return "posts/create";
    }//jsps

    @PostMapping(path = "/posts/create")
    public String creatPost(@RequestParam ("title") String title, @RequestParam ("body") String body, Model model){
        //create a post object set the information for title and body
        Post post = new Post( 1L, title, body);
        postDao.save(post);
         return "redirect:/posts";//url
    }

}
