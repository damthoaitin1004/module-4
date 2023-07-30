package com.example.library.controller;

import com.example.library.exception.DuplicateException;
import com.example.library.model.Book;
import com.example.library.model.BookCode;
import com.example.library.service.IBookCodeService;
import com.example.library.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Random;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    IBookCodeService bookCodeService;
    @Autowired
    private IBookService bookService;

    @GetMapping("/list")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("list", bookService.findAll());
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/detail");
        Book book = bookService.findById(id);
        modelAndView.addObject("book", book);
        return modelAndView;
    }

    @GetMapping("/rental/{id}")
    public ModelAndView rentalBook(@PathVariable int id) throws DuplicateException {
        ModelAndView modelAndView ;
        Random random = new Random();
        // Tạo một số ngẫu nhiên có 5 chữ số
        Integer randNum = 10000 + random.nextInt(90000);
        Book book = bookService.findById(id);
        if (book.getQuantity() > 0) {
            modelAndView = new ModelAndView("code");
            bookService.rentalBook(book);
            BookCode bookCode = new BookCode(randNum, book);
            bookCodeService.add(bookCode);
            modelAndView.addObject("codeRental", randNum);
        } else {

            throw new DuplicateException("Số sách hiện đã hết");
        }
        return modelAndView;
    }


    @GetMapping("/give/{id}")
    public ModelAndView showGiveBook(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("give");
        modelAndView.addObject("book", bookService.findById(id));
        return modelAndView;
    }

    @PostMapping("/give")
    public String giveBook(@RequestParam int nameBookCode, Model model) {
        BookCode bookGive = bookCodeService.findByName(nameBookCode);
        Book book = bookGive.getBook();
        bookCodeService.delete(nameBookCode);
        bookService.giveBook(book);
        model.addAttribute("msg", "Cảm ơn bạn đã tin dùng dịch vụ");
        model.addAttribute("list", bookService.findAll());
        return "list";
    }

    @ExceptionHandler(DuplicateException.class)
    public String duplicateException(){
        return "errors";
    }
}
