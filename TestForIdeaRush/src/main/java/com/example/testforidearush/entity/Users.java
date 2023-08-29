package com.example.testforidearush.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Setter;

import javax.annotation.processing.Generated;

@Entity
@Setter
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    boolean commentAlarm;

    public void changeAlarm() {
        this.commentAlarm = !this.commentAlarm;
    }
}
