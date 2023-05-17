package com.codeup.codeupspringblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {
    @RequestMapping("/posts")
    @ResponseBody
    public String posts() {
        return "posts index page";
    }

    @RequestMapping("/posts/{id}")
    @ResponseBody
    public String postsid(@PathVariable Long id) {
        return "view an individual post " + id;
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
