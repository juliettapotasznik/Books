package org.example.controllers;

import org.example.booksclient.contract.AuthorDetailsDto;
import org.example.mappers.AuthorDetailsMapper;
import org.example.model.AuthorDetails;
import org.example.services.AuthorDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/authorDetails")
public class AuthorDetailsController {

    private final AuthorDetailsService authorDetailsService;
    private final AuthorDetailsMapper authorDetailsMapper;

    @Autowired
    public AuthorDetailsController(AuthorDetailsService authorDetailsService, AuthorDetailsMapper authorDetailsMapper) {
        this.authorDetailsService = authorDetailsService;
        this.authorDetailsMapper = authorDetailsMapper;
    }

    @PostMapping("/create")
    public AuthorDetailsDto createAuthorDetails(@RequestBody AuthorDetailsDto authorDetailsDto) {
        AuthorDetails authorDetails = authorDetailsMapper.map(authorDetailsDto);
        AuthorDetails savedAuthorDetails = authorDetailsService.saveAuthorDetails(authorDetails);
        return authorDetailsMapper.toDto(savedAuthorDetails);
    }

    @GetMapping("/getAll")
    public List<AuthorDetailsDto> getAllAuthorDetails() {
        return authorDetailsService.getAllAuthorDetails().stream()
                .map(authorDetailsMapper::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/update/{id}")
    public AuthorDetailsDto updateAuthorDetails(@PathVariable Long id, @RequestBody AuthorDetailsDto authorDetailsDto) {
        AuthorDetails existingAuthorDetails = authorDetailsService.getAuthorDetailsById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Author details not found"));
        AuthorDetails updatedAuthorDetails = authorDetailsMapper.map(authorDetailsDto);
        updatedAuthorDetails.setId(existingAuthorDetails.getId());
        authorDetailsService.saveAuthorDetails(updatedAuthorDetails);
        return authorDetailsMapper.toDto(updatedAuthorDetails);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAuthorDetails(@PathVariable Long id) {
        authorDetailsService.deleteAuthorDetails(id);
        return ResponseEntity.ok().build();
    }
}