package com.codegym.bt_borrow_book_aop.controller;

import com.codegym.bt_borrow_book_aop.Exception.NotFoundException;
import com.codegym.bt_borrow_book_aop.model.Book;
import com.codegym.bt_borrow_book_aop.model.BorrowBook;
import com.codegym.bt_borrow_book_aop.service.book.IBookService;
import com.codegym.bt_borrow_book_aop.service.borrow.IBorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import java.util.Optional;

@Controller
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IBorrowBookService borrowBookService;

    @GetMapping("/books")
    public ModelAndView getBookList() {
        ModelAndView modelAndView = new ModelAndView("/book/menu");
        List<Book> books = (List<Book>) bookService.findAll();
        modelAndView.addObject("books", books);
        modelAndView.addObject("borrowCode", new BorrowBook());
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView showBookDetail(@PathVariable("id") Long id) throws NotFoundException {
        Optional<Book> bookOptional = bookService.findById(id);
        if (!bookOptional.isPresent()) {
            throw new NotFoundException();
        }
        return new ModelAndView("/book/view","book",bookOptional.get());
    }

    @GetMapping("/borrow/{id}")
    public ModelAndView generateCode(@PathVariable("id") Long id) throws NotFoundException {
        Optional<Book> bookOptional = bookService.findById(id);
        if (!bookOptional.isPresent()) {
            throw new NotFoundException();
        } else {
            ModelAndView modelAndView = new ModelAndView("/book/view");
            Book book = bookOptional.get();
            int currentAmount = book.getAmount();
            if (currentAmount == 0) {
                modelAndView.addObject("message", "This book is not available now");
                modelAndView.addObject("book", book);
            } else {
                book.setAmount(currentAmount - 1);
                bookService.save(book);
                modelAndView.addObject("book", book);
                String code = String.valueOf((int) ((Math.random()*(99999-10000)) + 1000));
                BorrowBook borrowBook = new BorrowBook(code, bookOptional.get());
                borrowBookService.save(borrowBook);
                modelAndView.addObject("code", code);
            } return modelAndView;
        }
    }

    @PostMapping("/return")
    public ModelAndView returnBook(@ModelAttribute("borrowCode") BorrowBook borrowBook) throws NotFoundException {
        Optional<BorrowBook> borrowCodeOptional = borrowBookService.findBorrowCodeByCode(borrowBook.getBookCode());
        if (!borrowCodeOptional.isPresent()) {
            throw  new NotFoundException();
        } else {
            BorrowBook borrowCode1 = borrowCodeOptional.get();
            Book book = borrowCode1.getBook();
            book.setAmount(book.getAmount() + 1);
            bookService.save(book);
            borrowBookService.deleteById(borrowCode1.getId());
            return new ModelAndView("redirect:/books");
        }
    }

}
