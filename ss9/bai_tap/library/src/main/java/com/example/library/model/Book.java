package com.example.library.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "TEXT")
    private String name;
    private Integer quantity;
    @Column(columnDefinition = "TEXT")

    private String information;
    @Column(columnDefinition = "TEXT")
    private String img;
    @OneToMany(mappedBy = "book")
    private Set<BookCode> bookCode;


    public Book() {
    }

    public Book(int id, String name, Integer quantity, String information, String img, Set<BookCode> bookCode) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.information = information;
        this.img = img;
        this.bookCode = bookCode;
    }

    public Set<BookCode> getBookCode() {
        return bookCode;
    }

    public void setBookCode(Set<BookCode> bookCode) {
        this.bookCode = bookCode;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }



}
