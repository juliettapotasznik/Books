package org.example.repositories;

public interface ICatalogData {
    BookRepository getBookRepository();
    AuthorRepository getAuthorRepository();
    SubjectRepository getSubjectRepository();
    AuthorDetailsRepository getAuthorDetailsRepository();
    WorkRepository getWorkRepository();

}
