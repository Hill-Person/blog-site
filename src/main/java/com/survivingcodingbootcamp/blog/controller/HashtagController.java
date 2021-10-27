package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.storage.HashtagStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HashtagController {

    private HashtagStorage hashtagStorage;

    public HashtagController(HashtagStorage hashtagStorage) {
        this.hashtagStorage = hashtagStorage;
    }

    @RequestMapping("/hashtags")
    public String showHashtags(Model model) {
        model.addAttribute("hashtags", hashtagStorage.retrieveAllHashtags());
        return "all-hashtags-template";
    }

    @GetMapping("hashtags/{id}")
    public String displaySingleHashtag(@PathVariable long id, Model model) {
        model.addAttribute("hashtag", hashtagStorage.retrieveHashtagById(id));
        return "single-hashtag-template";
    }

}


