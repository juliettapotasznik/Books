package org.example.services;

import org.example.model.AuthorDetails;
import org.example.repositories.AuthorDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorDetailsService {

    private final AuthorDetailsRepository authorDetailsRepository;

    @Autowired
    public AuthorDetailsService(AuthorDetailsRepository authorDetailsRepository) {
        this.authorDetailsRepository = authorDetailsRepository;
    }

    public AuthorDetails saveAuthorDetails(AuthorDetails authorDetails) {
        return authorDetailsRepository.save(authorDetails);
    }

    public Optional<AuthorDetails> getAuthorDetailsById(Long id) {
        return authorDetailsRepository.findById(id);
    }

    public List<AuthorDetails> getAllAuthorDetails() {
        return authorDetailsRepository.findAll();
    }

    public AuthorDetails updateAuthorDetails(AuthorDetails authorDetails) {
        return authorDetailsRepository.save(authorDetails);
    }

    public void deleteAuthorDetails(Long id) {
        authorDetailsRepository.deleteById(id);
    }
}
