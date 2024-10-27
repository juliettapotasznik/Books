package org.example.repositories;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BooksDataCatalog implements ICatalogData{
    private final BookRepository book;
    private final AuthorRepository author;
    private final SubjectRepository subject;
    private final AuthorDetailsRepository authorDetails;
    private final WorkRepository work;

    @Override
    public BookRepository getBookRepository() {
        return book;
    }

    @Override
    public AuthorRepository getAuthorRepository() {
        return author;
    }

    @Override
    public SubjectRepository getSubjectRepository() {
        return subject;
    }

    @Override
    public AuthorDetailsRepository getAuthorDetailsRepository() {
        return authorDetails;
    }

    @Override
    public WorkRepository getWorkRepository() {
        return work;
    }
}
