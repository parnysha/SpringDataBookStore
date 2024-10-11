package com.example.springbookstore.service;

import com.example.springbookstore.dto.Book;
import com.example.springbookstore.exceptions.BookNotFoundException;
import com.example.springbookstore.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    @Override
    public String getBookInfo(final Long id) throws BookNotFoundException {
        final Optional<Book> bookOptional = bookRepository.findById(id);

        return bookOptional.map(Book::toString).orElseThrow(BookNotFoundException::new);
    }
    @Override
    public List<Book> getAllBooks() {
        bookRepository.findAll();
        return bookRepository
                .findAll()
                .stream()
                .filter(book -> book.getAuthor()!=null)
                .collect(Collectors.toList());
    }
    @Override
    public List<Book> getBooksByTitle(final String title) {
        return bookRepository.findByTitle(title)
                .stream()
                .filter(book -> book.getAuthor()!=null)
                .collect(Collectors.toList());
    }

    @Override
    public Book addBook(Book book) {
        final Book addedBook = bookRepository.save(book);
        bookRepository.flush();
        return addedBook;
    }
    @Override
    public List<Book> addBooks(List<Book> books) {
        final List<Book> addedBooks = bookRepository.saveAll(books);
        bookRepository.flush();
        return addedBooks;
    }
    @Override
    public boolean deleteBook(Book book) {
        final Optional<Book> bookOpt = bookRepository.findById(book.getId());
        bookRepository.delete(book);
        return bookOpt.isPresent();
    }
}
