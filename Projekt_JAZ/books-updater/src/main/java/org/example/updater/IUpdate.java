package org.example.updater;

import org.example.booksclient.contract.BookDto;

public interface IUpdate {
    void update(String title);
    void updateDetailsAuthor(String name);
    void updateSubject(String name);
    void updateAuthor(String name);
    void updateWork(String name);
}
