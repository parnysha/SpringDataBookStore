package com.example.springbookstore.controller;

import com.example.springbookstore.dto.Book;
import com.example.springbookstore.exceptions.BookNotFoundException;
import com.example.springbookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    @GetMapping("/info/{id}")
    public String getBookInfo(@PathVariable long id) throws BookNotFoundException {
        return bookService.getBookInfo(id);
    }

    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/single")
    public List<Book> getAllBooksByTitle(@RequestParam String title) {
        return bookService.getBooksByTitle(title);
    }

    @PostMapping("/add/single")
    public Book getBook(@RequestBody final Book book){
        return bookService.addBook(book);
    }

    @PostMapping("/add/multi")
    public List<Book> getBooks(@RequestBody final List<Book> books){
        return bookService.addBooks(books);
    }

    @DeleteMapping("/delete/single")
    public boolean deleteBook(@RequestBody final Book book){
        return bookService.deleteBook(book);
    }
}
