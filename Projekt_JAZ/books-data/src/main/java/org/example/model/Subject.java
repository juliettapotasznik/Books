package org.example.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String subjectKey;
    private String name;

    private Integer workCount;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Work> works=new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return subjectKey;
    }

    public void setKey(String key) {
        this.subjectKey = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWorkCount() {
        return workCount;
    }

    public void setWorkCount(Integer workCount) {
        this.workCount = workCount;
    }

    public List<Work> getWorks() {
        return works;
    }

    public void setWorks(List<Work> works) {
        this.works = works;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subject subject)) return false;
        return Objects.equals(id, subject.id) && Objects.equals(subjectKey, subject.subjectKey) && Objects.equals(name, subject.name) && Objects.equals(workCount, subject.workCount) && Objects.equals(works, subject.works);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subjectKey, name, workCount, works);
    }
}
