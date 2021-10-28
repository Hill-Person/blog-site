package com.survivingcodingbootcamp.blog.storage;

import com.survivingcodingbootcamp.blog.model.Hashtag;

import java.util.Optional;

public interface HashtagStorage {

    Iterable<Hashtag> retrieveAllHashtags();

    Optional<Hashtag> retrieveHashtagByName(String name);

    void save(Hashtag HashTagToAdd);

    Hashtag retrieveHashtagById(Long id);

}
