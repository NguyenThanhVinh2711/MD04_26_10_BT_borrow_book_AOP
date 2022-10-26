package com.codegym.bt_borrow_book_aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    private static int viewCount = 0;
    @After("execution(public * com.codegym.bt_borrow_book_aop.controller.BookController.generateCode(..))")
    public void log(){
        System.out.println("A book is borrowed");
    }
    @After("execution(public * com.codegym.bt_borrow_book_aop.controller.BookController.returnBook(..))")
    public void returnBook(){
        System.out.println("The book has been returned");
    }
    @After("execution(public * com.codegym.bt_borrow_book_aop.service.book.BookService.findAll(..))")
    public void viewCount(){
        viewCount++;
        System.out.println("View count: " + viewCount);
    }
}
