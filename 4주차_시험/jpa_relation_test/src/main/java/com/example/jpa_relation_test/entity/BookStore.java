package com.example.jpa_relation_test.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class BookStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    private String name;

    @JsonIgnore
    private String address;

    @JsonIgnore
    @OneToMany(mappedBy = "bookStore")
    private List<Book> bookList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void addBook(Book book){
        this.bookList.add(book);
        book.changeBookStore(this);
    }
}
