package org.example.mappers;

import org.example.booksclient.contract.AuthorDetailsDto;
import org.example.booksclient.contract.AuthorDto;
import org.example.booksclient.contract.BookDto;
import org.example.model.Author;
import org.example.model.AuthorDetails;
import org.example.model.Book;
import org.springframework.stereotype.Component;

@Component
public class AuthorDetailsMapper implements IMap<AuthorDetailsDto, AuthorDetails> {


    @Override
    public AuthorDetails map(AuthorDetailsDto authorDetailsDto) {
        return map(authorDetailsDto,new AuthorDetails());
    }

    @Override
    public AuthorDetails map(AuthorDetailsDto authorDetailsDto, AuthorDetails authorDetails) {
        authorDetails.setAuthorDetailsKey(authorDetailsDto.getKey());
        authorDetails.setName(authorDetailsDto.getName());
        authorDetails.setWorkCount(authorDetailsDto.getWorkCount());
        authorDetails.setTopWork(authorDetailsDto.getTopWork());
        return authorDetails;
    }
    public AuthorDetailsDto toDto(AuthorDetails authorDetails) {
        AuthorDetailsDto authorDetailsDto = new AuthorDetailsDto();
        authorDetailsDto.setKey(authorDetails.getAuthorDetailsKey());
        authorDetailsDto.setName(authorDetails.getName());
        authorDetailsDto.setTopWork(authorDetails.getTopWork());
        authorDetailsDto.setWorkCount(authorDetails.getWorkCount());
        return authorDetailsDto;
    }

}
