package org.example.repositories;

import org.example.model.Book;
import org.example.model.Work;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkRepository extends JpaRepository<Work, Long> {
    Work getWorksByWorkKey(String workKey);
}
