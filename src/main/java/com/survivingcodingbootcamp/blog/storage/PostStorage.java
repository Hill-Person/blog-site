package com.survivingcodingbootcamp.blog.storage;

import com.survivingcodingbootcamp.blog.model.Post;
import com.survivingcodingbootcamp.blog.model.Topic;

import java.util.Optional;

public interface PostStorage {
    Iterable<Post> retrieveAllPosts();

    Post retrievePostById(long l);

    void save(Post postToAdd);

    Optional<Post> retrievePostByTitle(String title);

}
