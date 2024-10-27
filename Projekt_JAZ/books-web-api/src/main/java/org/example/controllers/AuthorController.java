package org.example.controllers;

import org.example.booksclient.contract.AuthorDto;
import org.example.mappers.AuthorMapper;
import org.example.model.Author;
import org.example.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;
    private final AuthorMapper authorMapper;

    @Autowired
    public AuthorController(AuthorService authorService, AuthorMapper authorMapper) {
        this.authorService = authorService;
        this.authorMapper = authorMapper;
    }

    @PostMapping("/create")
    public AuthorDto createAuthor(@RequestBody AuthorDto authorDto) {
        Author author = authorMapper.map(authorDto);
        Author savedAuthor = authorService.saveAuthor(author);
        return authorMapper.toDto(savedAuthor);
    }

    @GetMapping("/getAll")
    public List<AuthorDto> getAllAuthors() {
        return authorService.getAllAuthors().stream()
                .map(authorMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/get/{id}")
    public AuthorDto getAuthorById(@PathVariable Long id) {
        Author author = authorService.getAuthorById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found"));
        return authorMapper.toDto(author);
    }

    @PutMapping("/update/{id}")
    public AuthorDto updateAuthor(@PathVariable Long id, @RequestBody AuthorDto authorDto) {
        Author existingAuthor = authorService.getAuthorById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found"));
        Author updatedAuthor = authorMapper.map(authorDto);
        updatedAuthor.setId(existingAuthor.getId());
        authorService.saveAuthor(updatedAuthor);
        return authorMapper.toDto(updatedAuthor);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.ok().build();
    }
}
