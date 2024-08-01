package com.example.springbookstore.repository;

import com.example.springbookstore.dto.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {//в качестве дженерика что мы будем сохранять в базу данных и id
    List<Book> findByTitleAndAuthor (String title,String author);
    List<Book> findByTitle(String title);
}
