package com.example.library.service;

import com.example.library.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
   Book findById(int id);
   void giveBook(Book book);
   void rentalBook(Book book);
}
