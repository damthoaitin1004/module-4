package com.example.library.repository;

import com.example.library.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ILogRepository extends JpaRepository<Log, Integer> {
    @Transactional
    Log findLogByName(String name);
}
