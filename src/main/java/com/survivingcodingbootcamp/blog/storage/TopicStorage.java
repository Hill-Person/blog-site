package com.survivingcodingbootcamp.blog.storage;

import com.survivingcodingbootcamp.blog.model.Topic;

import java.util.Optional;

public interface TopicStorage {
    Iterable<Topic> retrieveAllTopics();

    void save(Topic topicToSave);

    Topic retrieveSingleTopic(long id);


}
