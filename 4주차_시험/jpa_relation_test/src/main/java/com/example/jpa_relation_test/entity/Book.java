package com.example.jpa_relation_test.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private Integer price;

    private Integer stock;

    @ManyToOne
    private BookStore bookStore;

    public void updateBook(Book book){
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.price = book.getPrice();
        this.stock = book.getStock();
    }

    public void changeBookStore(BookStore newBookStore){
        this.bookStore = newBookStore;
    }
}
