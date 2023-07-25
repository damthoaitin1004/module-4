package com.example.blog.model;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "TEXT")

    private String content;
    private String name;
    @Column(name="date",columnDefinition ="DATE")
    private Date date;

    private String author;

    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;
    public Blog(){

    }

    public Blog(int id, String content, String name, Date date, String author, Category category) {
        this.id = id;
        this.content = content;
        this.name = name;
        this.date = date;
        this.author = author;
        this.category = category;
    }

    public Blog(String content, String name, Date date, String author, Category category) {
        this.content = content;
        this.name = name;
        this.date = date;
        this.author = author;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Blog(int id, String content, Date date) {
        this.id = id;
        this.content = content;
        this.date = date;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
