package com.jonson.aop.service;

import com.jonson.aop.entity.Book;
import com.jonson.aop.repository.BookRepository;
import com.jonson.aop.util.CustomResponse;
import com.jonson.aop.util.CustomStatus;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public CustomResponse<Book> getAll() {
        try {
            log.info("Rest request to get all books");
            List<Book> bookList = bookRepository.findAll();
            log.info("fonds all books size: {}", bookList.size());
            return new CustomResponse<>(bookList, CustomStatus.SUCCESS);
        } catch (Exception e) {
            log.error("error occurred: {}", e.getMessage());
            log.error("er", e);
            return new CustomResponse<>(null, CustomStatus.EXCEPTON);
        }
    }

    public CustomResponse<Book> getBookByTitle(String title) {
        try {
            log.info("Rest request to get book by title: {}", title);
            Book book = bookRepository.findBookByTitle(title)
                    .orElseThrow();
            log.info("fond book with given title: {}", book);
            return new CustomResponse<>(List.of(book), CustomStatus.SUCCESS);
        } catch (NoSuchElementException e) {
            log.error("NoSuchElementException occurred: {}", e.getMessage());
            log.error("e", e);
            return new CustomResponse<>(null, CustomStatus.NOT_FOUND);
        }
    }

    public CustomResponse<Book> addBook(Book book) {
        Book save = bookRepository.save(book);
        return new CustomResponse<>(List.of(save), CustomStatus.SUCCESS);
    }
}
