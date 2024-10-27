package org.example.mappers;

import org.example.booksclient.contract.BookDto;
import org.example.model.Author;
import org.example.model.Book;
import org.example.model.Subject;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
@Component
public class BookMapper implements IMap<BookDto, Book> {
    @Override
    public Book map(BookDto bookDto) {
        return map(bookDto,new Book());
    }

    @Override
    public Book map(BookDto bookDto, Book book) {
        book.setTitle(bookDto.getTitle());
        book.setBookKey(bookDto.getKey());
        book.setAuthorKey(bookDto.getAuthorKey());
        book.setFirst_publish_year(bookDto.getYear());
        book.setAuthorName(bookDto.getAuthor());
        return book;
    }
    public BookDto toDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setKey(book.getBookKey());
        bookDto.setTitle(book.getTitle());
        bookDto.setYear(book.getFirst_publish_year());
        bookDto.setAuthor(book.getAuthorName());
        bookDto.setAuthorKey(book.getAuthorKey());
        return bookDto;
    }


}
