package com.codeup.codeupspringblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    @RequestMapping("/posts")
    public String posts(Model model) {
        List<Post> posts = new ArrayList<>();

        Post post1 = new Post(2L,"Corgi", "Corgi for adoption");
        Post post2 = new Post(3L,"Pug", "Pug for adoption");

        posts.add(post1);
        posts.add(post2);

        model.addAttribute("posts", posts);

        return "posts/index";
    }

    @RequestMapping("/posts/{id}")
    public String postsid(@PathVariable Long id, Model model) {
        // Create an example post
        Post post = new Post(1L, "Puppy Post", "This is a post about a dog");

        // Pass the post to the view
        model.addAttribute("post", post);

        return "posts/show";
    }

    @RequestMapping("/posts/create")
    @ResponseBody
    public String createPostForm() {
        return "view an individual post";
    }

    @RequestMapping(path = "/posts/create",  method = RequestMethod.POST)
    @ResponseBody
    public String creatPost() {
        return "create a new post";
    }



}
