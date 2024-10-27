package org.example.repositories;

import org.example.model.AuthorDetails;
import org.example.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Locale;

public interface AuthorDetailsRepository extends JpaRepository<AuthorDetails, Long> {
    AuthorDetails getAuthorDetailsByName(String name);
}
