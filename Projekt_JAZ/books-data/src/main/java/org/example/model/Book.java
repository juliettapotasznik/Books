package org.example.model;

import jakarta.persistence.*;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String bookKey;
    @ElementCollection
    @Column(name = "author_name")
    private List<String> authorName=new ArrayList<>();

    private String title;

    private Year first_publish_year;
    @ElementCollection
    @Column(name = "author_key")
    private List<String> authorKey=new ArrayList<>();

    public String getBookKey() {
        return bookKey;
    }

    public void setBookKey(String bookKey) {
        this.bookKey = bookKey;
    }

    public List<String> getAuthorName() {
        return authorName;
    }

    public void setAuthorName(List<String> authorName) {
        this.authorName = authorName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Year getFirst_publish_year() {
        return first_publish_year;
    }

    public void setFirst_publish_year(Year first_publish_year) {
        this.first_publish_year = first_publish_year;
    }

    public List<String> getAuthorKey() {
        return authorKey;
    }

    public void setAuthorKey(List<String> authorKey) {
        this.authorKey = authorKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return Objects.equals(id, book.id) && Objects.equals(bookKey, book.bookKey) && Objects.equals(authorName, book.authorName) && Objects.equals(title, book.title) && Objects.equals(first_publish_year, book.first_publish_year) && Objects.equals(authorKey, book.authorKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookKey, authorName, title, first_publish_year, authorKey);
    }
}
