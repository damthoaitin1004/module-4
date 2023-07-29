package com.example.library.service;

import com.example.library.model.BookCode;

public interface IBookCodeService {
    void add(BookCode bookCode);
    void delete(int name);
    BookCode findByName(int name);
}
