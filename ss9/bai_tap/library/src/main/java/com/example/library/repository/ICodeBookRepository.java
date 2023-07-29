package com.example.library.repository;

import com.example.library.model.BookCode;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ICodeBookRepository extends JpaRepository<BookCode,Integer>{
    @Transactional
    @Modifying
    void deleteBookCodeByName(int name);
     BookCode findBookCodeByName(int name);
}
