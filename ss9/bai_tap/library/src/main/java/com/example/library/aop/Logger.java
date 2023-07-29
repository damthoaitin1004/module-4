package com.example.library.aop;

import com.example.library.model.Book;
import com.example.library.model.BookCode;
import com.example.library.model.Log;
import com.example.library.repository.ILogRepository;
import com.example.library.service.IBookCodeService;
import com.example.library.service.IBookService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    @Autowired
    private ILogRepository iLogRepository;
    @Autowired
    private IBookCodeService bookCodeService;

    private static Integer count;

    @After("execution (* com.example.library.controller.BookController.*(..))")
    public void count() {
        Log log = iLogRepository.findLogByName("views");
        if (log == null){
            log = new Log();
            count = 0;
            log.setName("views");
        }else {
            count = log.getCount();
        }
        count++;
        log.setCount(count);
        System.out.println("Số người đã truy cập trang wed là "+ count);
        iLogRepository.save(log);
    }
    @Around("execution(* com.example.library.service.BookCodeService.add(..))")
    public void loggingCreateByOneBookCode(JoinPoint joinPoint ){
        Object[] args = joinPoint.getArgs();
        Integer code = (Integer) args[0];
        BookCode bookCode = bookCodeService.findByName(code);
        Log log = new Log();
        log.setCount(1);
        log.setName(bookCode.getName()+"was created");
        iLogRepository.save(log);
    }


}
