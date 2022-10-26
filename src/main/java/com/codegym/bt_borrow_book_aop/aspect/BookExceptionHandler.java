package com.codegym.bt_borrow_book_aop.aspect;

import com.codegym.bt_borrow_book_aop.Exception.NotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class BookExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView notFound(){
        return new ModelAndView("/error-404");
    }
}
