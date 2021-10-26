package com.survivingcodingbootcamp.blog.model;

import javax.persistence.*;
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

    @ManyToMany(mappedBy = "posts")
    private Collection<Hashtag> hashtags;

    public Hashtag(String name, String description) {
        this.name = name;
        this.description = description;
    }

    protected Hashtag() {

    }

    public long getId() { return id; }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Collection<Hashtag> getHashtags() {
        return hashtags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hashtag hashtag = (Hashtag) o;
        return id == hashtag.id && Objects.equals(name, hashtag.name) && Objects.equals(description, hashtag.description) && Objects.equals(hashtags, hashtag.hashtags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, hashtags);
    }
}



