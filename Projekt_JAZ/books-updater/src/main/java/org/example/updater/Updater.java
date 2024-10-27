package org.example.updater;

import org.example.booksclient.IBooksClient;
import org.example.booksclient.contract.*;
import org.example.booksclient.contract.BookResultsDto;
import org.example.mappers.*;
import org.example.model.*;
import org.example.repositories.BooksDataCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class Updater implements IUpdate {
    private final IBooksClient booksClient;
   private final BooksDataCatalog dataCatalog;
    private final BookMapper bookMapper;
    private final AuthorMapper authorMapper;
    private final SubjectMapper subjectMapper;
    private final AuthorDetailsMapper authorDetailsMapper;
    private final WorkMapper workMapper;



    @Autowired
    public Updater(BooksDataCatalog bookRepository, IBooksClient booksClient, BooksDataCatalog dataCatalog, BookMapper bookMapper, AuthorMapper authorMapper, SubjectMapper subjectMapper, AuthorDetailsMapper authorDetailsMapper, WorkMapper workMapper) {
        this.booksClient = booksClient;
        this.dataCatalog = dataCatalog;
        this.bookMapper = bookMapper;
        this.authorMapper = authorMapper;
        this.subjectMapper = subjectMapper;
        this.authorDetailsMapper = authorDetailsMapper;
        this.workMapper = workMapper;


    }




    @Override
    public void update(String title) {
        var result=booksClient.getBooksFromApi(title);

        var books = result.getResults().stream()
                .map(bookMapper::map)
                .collect(Collectors.toList());
        dataCatalog.getBookRepository().saveAll(books);
    }


    @Override
    public void updateDetailsAuthor(String name) {
        var result=booksClient.getAuthorsFromApi(name);

        var authors = result.getResults().stream()
                .map(authorDetailsMapper::map)
                .collect(Collectors.toList());
        dataCatalog.getAuthorDetailsRepository().saveAll(authors);



    }



    @Override
    public void updateSubject(String name) {

        SubjectDto subjectDto = booksClient.getSubject(name);
        Subject existingSubject = dataCatalog.getSubjectRepository().getSubjectsByName(name);

        if (existingSubject != null) {
            subjectMapper.map(subjectDto, existingSubject);
        } else {
            existingSubject = new Subject();
            subjectMapper.map(subjectDto, existingSubject);
        }

        dataCatalog.getSubjectRepository().save(existingSubject);
    }
    @Override
    public void updateAuthor(String name) {

        var result=booksClient.getWorks(name);

        if (result != null && result.getAuthors() != null)
        {
            var authors = result.getAuthors().stream()
                    .map(authorMapper::map)
                    .collect(Collectors.toList());
            dataCatalog.getAuthorRepository().saveAll(authors);
        }

    }

    @Override
    public void updateWork(String name) {
        var result=booksClient.getSubject(name);


        var works = result.getWorks().stream()
                .map(workMapper::map)
                .collect(Collectors.toList());
        dataCatalog.getWorkRepository().saveAll(works);
    }
}
