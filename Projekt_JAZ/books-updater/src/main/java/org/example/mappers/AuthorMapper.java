package org.example.mappers;

import org.example.booksclient.contract.AuthorDto;
import org.example.booksclient.contract.BookDto;
import org.example.model.Author;
import org.example.model.Book;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper implements IMap<AuthorDto, Author> {
    @Override
    public Author map(AuthorDto authorDto) {
        return map(authorDto,new Author());
    }

    @Override
    public Author map(AuthorDto authorDto, Author author) {
        if (author == null) {
            author = new Author();
        }
        author.setName(authorDto.getName());
        author.setKey(authorDto.getKey());

        return author;
    }
    public AuthorDto toDto(Author author) {
        BookDto bookDto = new BookDto();
        AuthorDto authorDto = new AuthorDto();
        authorDto.setName(author.getName());
        authorDto.setKey(author.getKey());
        return authorDto;
    }
}
