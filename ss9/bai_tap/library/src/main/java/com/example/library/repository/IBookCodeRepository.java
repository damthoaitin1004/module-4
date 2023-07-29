package com.example.library.repository;

import com.example.library.model.BookCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface IBookCodeRepository extends JpaRepository<BookCode,Integer>{
    @Transactional
    @Modifying
    void deleteBookCodeByName(int name);
     BookCode findBookCodeByName(int name);
}
