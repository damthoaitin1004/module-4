package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void giveBook(Book book) {
        book.setQuantity(book.getQuantity()+1);
        bookRepository.save(book);
    }

    @Override
    public void rentalBook(Book book) {
        book.setQuantity(book.getQuantity()-1);
        bookRepository.save(book);
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id).orElse(null);
    }
}
