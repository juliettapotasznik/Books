package org.example.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String authorKey;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return authorKey;
    }

    public void setKey(String key) {
        this.authorKey = key;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author author)) return false;
        return Objects.equals(id, author.id) && Objects.equals(name, author.name) && Objects.equals(authorKey, author.authorKey) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, authorKey);
    }
}
