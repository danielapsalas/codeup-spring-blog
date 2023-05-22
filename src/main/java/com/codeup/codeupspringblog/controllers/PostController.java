package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
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


    @GetMapping("/posts")
    public String posts(Model model) {


        model.addAttribute("posts", postDao.findAll());

        return "posts/index";
    }

    @RequestMapping("/posts/{id}")
    public String postsid(@PathVariable Long id, Model model) {
        Post post1 = postDao.findById(id).get();
        post1.getUser();
        model.addAttribute("posts", post1);

        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String createPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }//jsps

    @PostMapping(path = "/posts/create")
    public String creatPost(@ModelAttribute Post post){
        //create a post object set the information for title and body
        postDao.save(post);
         return "redirect:/posts";//url
    }

    @GetMapping("/posts/{id}/edit")
    public String editForm(@PathVariable("id") Long id, Model model) {
        Post post = postDao.findPostById(id);
        model.addAttribute("postEdit", post);
        return "/posts/edit";
    }

    @PostMapping("posts/{id}/edit")
    public String editPost(@ModelAttribute("postEdit") Post updatedPost) {
        postDao.save(updatedPost);
        return "redirect:/posts";
    }
}
