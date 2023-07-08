package com.example.test2.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String username;
    String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    List<Post> post = new ArrayList<>();
}
