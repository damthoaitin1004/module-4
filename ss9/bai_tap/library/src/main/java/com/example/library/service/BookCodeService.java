package com.example.library.service;

import com.example.library.model.BookCode;
import com.example.library.repository.IBookCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookCodeService implements IBookCodeService {
    @Autowired
    private IBookCodeRepository iBookCodeRepository;
    @Override
    public void add(BookCode bookCode) {
            iBookCodeRepository.save(bookCode);
    }

    @Override
    public void delete(int name) {
        iBookCodeRepository.deleteBookCodeByName(name);
    }

    @Override
    public BookCode findByName(int name) {
        return iBookCodeRepository.findBookCodeByName(name);
    }


}
