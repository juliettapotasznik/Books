package org.example;

import org.example.updater.IUpdate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication(scanBasePackages = "org.example")
public class BooksUpdaterApplication implements CommandLineRunner {

    private final IUpdate updater;

    public BooksUpdaterApplication(IUpdate updater) {
        this.updater = updater;
    }


    public static void main(String[] args) {
        SpringApplication.run(BooksUpdaterApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
       updater.update("biblia");
       updater.updateDetailsAuthor("sanderson");
       updater.updateSubject("fantasy");
       // updater.updateWork("fantasy");
       // updater.updateAuthor("fantasy");

    }


}
