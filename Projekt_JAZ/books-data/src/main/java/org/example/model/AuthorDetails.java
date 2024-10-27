package org.example.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class AuthorDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String authorDetailsKey;
    private String name;



    private String topWork;

    private Integer workCount;

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

    public String getAuthorDetailsKey() {
        return authorDetailsKey;
    }

    public void setAuthorDetailsKey(String authorDetailsKey) {
        this.authorDetailsKey = authorDetailsKey;
    }



    public String getTopWork() {
        return topWork;
    }

    public void setTopWork(String topWork) {
        this.topWork = topWork;
    }

    public Integer getWorkCount() {
        return workCount;
    }

    public void setWorkCount(Integer workCount) {
        this.workCount = workCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuthorDetails that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(authorDetailsKey, that.authorDetailsKey) && Objects.equals(name, that.name) && Objects.equals(topWork, that.topWork) && Objects.equals(workCount, that.workCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, authorDetailsKey, name, topWork, workCount);
    }
}
