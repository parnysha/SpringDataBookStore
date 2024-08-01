package com.example.springbookstore.service;

import com.example.springbookstore.dto.Book;

import java.util.List;

public interface BookService {
    String getBookInfo(Long id);

    List<Book> getAllBooks();
    List<Book> getBooksByTitle(String author);
    Book addBook(final Book book);
    List<Book> addBooks(final List<Book> books);
    boolean deleteBook(final Book book);
}
