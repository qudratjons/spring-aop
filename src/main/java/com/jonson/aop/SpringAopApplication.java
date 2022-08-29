package com.jonson.aop;

import com.jonson.aop.entity.Book;
import com.jonson.aop.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringAopApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAopApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(BookRepository bookRepository) {
        return args -> {

            List<Book> of = List.of(
                    new Book("War and peace ", "Tolstoy"),
                    new Book("Guru", "Guru")
            );
            bookRepository.saveAll(of);
        };
    }

}
