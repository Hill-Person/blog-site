package com.survivingcodingbootcamp.blog.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Hashtag {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String description;

    @ManyToMany(mappedBy = "hashtags")
    private Collection<Post> posts;

    public Hashtag(String name, String description, Post... posts) {
        this.name = name;
        this.description = description;
        this.posts = Arrays.asList(posts);
    }

    protected Hashtag() {

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Collection<Post> getPosts() {
        return posts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hashtag hashtag = (Hashtag) o;
        return id == hashtag.id && Objects.equals(name, hashtag.name) && Objects.equals(description, hashtag.description) && Objects.equals(posts, hashtag.posts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, posts);
    }
}



