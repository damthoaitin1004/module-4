package com.example.library.model;

import javax.persistence.*;

@Entity
public class BookCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Integer name;
    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;


    public BookCode(Integer name, Book book) {
        this.name = name;
        this.book = book;
    }

    public BookCode(int id, Integer name, Book book) {
        this.id = id;
        this.name = name;
        this.book = book;
    }

    public BookCode() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
