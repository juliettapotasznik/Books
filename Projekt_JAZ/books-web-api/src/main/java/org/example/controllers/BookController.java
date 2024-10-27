package org.example.controllers;

import org.example.booksclient.contract.BookDto;
import org.example.mappers.BookMapper;
import org.example.model.Book;
import org.example.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final BookMapper bookMapper;

    @Autowired
    public BookController(BookService bookService, BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @PostMapping("/create")
    public BookDto createBook(@RequestBody BookDto bookDto) {
        Book book = bookMapper.map(bookDto);
        Book savedBook = bookService.saveBook(book);
        return bookMapper.toDto(savedBook);
    }
    @GetMapping("/getAll")
    public List<BookDto> getAllBooks() {
        return bookService.getAllBooks().stream()
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/update/{id}")
    public BookDto updateBook(@PathVariable Long id, @RequestBody BookDto bookDto) {
        Book existingBook = bookService.getBookById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
        Book updatedBook = bookMapper.map(bookDto);
        updatedBook.setId(existingBook.getId());
        bookService.saveBook(updatedBook);
        return bookMapper.toDto(updatedBook);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }


}