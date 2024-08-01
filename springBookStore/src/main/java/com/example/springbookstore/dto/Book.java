package com.example.springbookstore.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data //создаст геттеры и сеттеры на полях и переопределит иквел и хэш код
@AllArgsConstructor //создаст конструкторы с аргументами и без
@NoArgsConstructor
public class Book {
    @Id //говорит что это поле индекс колонки базы данных
    @GeneratedValue(strategy = GenerationType.AUTO) //автоинкрементируется значений поля
    private long id;

    @Column(nullable = false) //это имя поля должно быть смаплено в колонку с таким же названием поля
    private String title;

    @Column(nullable = false)
    private String author;
}

