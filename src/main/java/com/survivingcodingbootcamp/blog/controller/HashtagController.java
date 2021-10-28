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


import javax.swing.text.html.Option;
import java.util.Optional;


@Controller
public class HashtagController {

    private HashtagStorage hashtagStorage;
    private PostStorage postStorage;
    private TopicStorage topicStorage;

    public HashtagController(HashtagStorage hashtagStorage, PostStorage postStorage, TopicStorage topicStorage) {
        this.hashtagStorage = hashtagStorage;
        this.postStorage = postStorage;
        this.topicStorage = topicStorage;
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

    @PostMapping("posts/addhashtag")
    public String addHashtags(@RequestParam long postid, @RequestParam String name, @RequestParam String description) {
        Post post1 = postStorage.retrievePostById(postid);
        Hashtag hashtag1;
        Optional<Hashtag> hashtagOpt = hashtagStorage.retrieveHashtagByName(name);
        if (hashtagOpt.isEmpty()) {
            hashtag1 = new Hashtag(name, description);
            hashtagStorage.save(hashtag1);
        } else {
            hashtag1 = hashtagOpt.get();
        }
        post1.addHashtag(hashtag1);
        postStorage.save(post1);
        return "redirect:/posts/" + postid;
    }

}


