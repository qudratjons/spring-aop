package com.jonson.aop.webapp;

import com.jonson.aop.entity.Book;
import com.jonson.aop.service.BookService;
import com.jonson.aop.util.CustomResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class BookController {

    private final BookService bookService;

    @GetMapping("/books")
    public CustomResponse<Book> getAll() {
        return bookService.getAll();
    }

    @GetMapping("/books/{title}")
    public CustomResponse<Book> getBoolByTitle(@PathVariable String title) {
        return bookService.getBookByTitle(title);
    }

    @PostMapping("/books")
    public CustomResponse<Book> addBok(@RequestBody Book book) {
        return bookService.addBook(book);
    }
}
