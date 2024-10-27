package org.example;

import org.example.repositories.ICatalogData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BooksDataApplication implements CommandLineRunner {

    private final ICatalogData db;

    public BooksDataApplication(ICatalogData db) {
        this.db = db;
    }


    public static void main(String[] args) {
        SpringApplication.run(BooksDataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
    }