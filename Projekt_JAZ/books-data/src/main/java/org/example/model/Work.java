package org.example.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String workKey;

    private String title;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Author> authors=new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return workKey;
    }

    public void setKey(String key) {
        this.workKey = key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Work work)) return false;
        return Objects.equals(id, work.id) && Objects.equals(workKey, work.workKey) && Objects.equals(title, work.title) && Objects.equals(authors, work.authors) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, workKey, title, authors);
    }
}
