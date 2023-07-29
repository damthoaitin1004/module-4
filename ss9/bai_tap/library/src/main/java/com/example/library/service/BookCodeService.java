package com.example.library.service;

import com.example.library.model.BookCode;
import com.example.library.repository.ICodeBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookCodeService implements IBookCodeService {
    @Autowired
    private ICodeBookRepository iCodeBookRepository;
    @Override
    public void add(BookCode bookCode) {
            iCodeBookRepository.save(bookCode);
    }

    @Override
    public void delete(int name) {
        iCodeBookRepository.deleteBookCodeByName(name);
    }

    @Override
    public BookCode findByName(int name) {
        return iCodeBookRepository.findBookCodeByName(name);
    }


}
