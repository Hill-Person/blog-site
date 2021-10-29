package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.model.Hashtag;
import com.survivingcodingbootcamp.blog.model.Post;
import com.survivingcodingbootcamp.blog.model.Topic;
import com.survivingcodingbootcamp.blog.storage.HashtagStorage;
import com.survivingcodingbootcamp.blog.storage.PostStorage;
import com.survivingcodingbootcamp.blog.storage.TopicStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.Id;
import java.util.Optional;

@Controller
@RequestMapping("/posts")
public class PostController {
    private PostStorage postStorage;
    private HashtagStorage hashtagStorage;
    private TopicStorage topicStorage;

    public PostController(PostStorage postStorage, HashtagStorage hashtagStorage, TopicStorage topicStorage) {
        this.postStorage = postStorage;
        this.hashtagStorage = hashtagStorage;
        this.topicStorage = topicStorage;
    }

    @GetMapping("/{id}")
    public String displaySinglePost(@PathVariable long id, Model model) {
        model.addAttribute("post", postStorage.retrievePostById(id));
        return "single-post-template";
    }

    @PostMapping("/addpost")
    public String addPost(@RequestParam long topicId, @RequestParam String title, @RequestParam String content, @RequestParam String author){
        Topic topic1 = topicStorage.retrieveSingleTopic(topicId);
        Post post = new Post(title,topic1,content,author);
        postStorage.save(post);
        return "redirect:/topics/"+topicId;
    }

}

