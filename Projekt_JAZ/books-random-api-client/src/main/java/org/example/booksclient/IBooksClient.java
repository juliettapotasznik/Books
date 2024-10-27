package org.example.booksclient;

import org.example.booksclient.contract.*;

import java.util.List;

public interface IBooksClient {




    AuthorDetailsResultsDto getAuthorsFromApi(String name);


    SubjectDto getSubject(String name);
    BookResultsDto getBooksFromApi(String title);
    WorkDto getWorks(String name);

}
