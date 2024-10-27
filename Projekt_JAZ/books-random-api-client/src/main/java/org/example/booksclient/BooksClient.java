package org.example.booksclient;

import org.example.booksclient.contract.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;


@Component
public class BooksClient implements IBooksClient{

    private final RestTemplate restClient;
    public BooksClient (){
        restClient=new RestTemplate();
    }



    @Override
    public AuthorDetailsResultsDto getAuthorsFromApi(String name) {
        String url = UriComponentsBuilder.fromHttpUrl("https://openlibrary.org/search/authors.json")
                .queryParam("q", name)
                .build()
                .toUriString();
        return restClient.getForObject(url,AuthorDetailsResultsDto.class);

    }

    @Override
    public SubjectDto getSubject(String name) {
        String url = UriComponentsBuilder.fromHttpUrl("https://openlibrary.org/subjects/" + name + ".json?")
                .toUriString();

        return restClient.getForObject(url, SubjectDto.class);

    }

    @Override
    public BookResultsDto getBooksFromApi(String title) {
        String url = UriComponentsBuilder.fromHttpUrl("https://openlibrary.org/search.json")
                .queryParam("q", title)
                .build()
                .toUriString();

     return restClient.getForObject(url,BookResultsDto.class);
    }
    @Override
    public WorkDto getWorks(String name) {
        String url = UriComponentsBuilder.fromHttpUrl("https://openlibrary.org/subjects/" + name + ".json?")
                .toUriString();

        return restClient.getForObject(url, WorkDto.class);

    }


}
