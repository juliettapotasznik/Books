package org.example;

import org.example.booksclient.IBooksClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BooksClientApplication implements CommandLineRunner {

    IBooksClient client;

    public BooksClientApplication(IBooksClient client) {
        this.client = client;
    }
    public static void main(String[] args) {
        SpringApplication.run(BooksClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
