package org.example.repositories;

import org.example.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findByName(String name);
    Author findByAuthorKey(String key);
}
