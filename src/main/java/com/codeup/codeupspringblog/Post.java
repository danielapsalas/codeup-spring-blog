package com.codeup.codeupspringblog;

public class Post {
    private Long id;
    private String title;
    private String body;

    // Default constructor
    public Post() {
    }

    // Constructor with title and body parameters
    public Post(Long id, String title, String body) {
        this.title = title;
        this.body = body;
    }

    // Getter for id
    public Long getId() {
        return id;
    }

    // Setter for id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Setter for title
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter for body
    public String getBody() {
        return body;
    }

    // Setter for body
    public void setBody(String body) {
        this.body = body;
    }
}

