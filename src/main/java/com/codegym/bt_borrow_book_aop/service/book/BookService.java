package com.codegym.bt_borrow_book_aop.service.book;

import com.codegym.bt_borrow_book_aop.model.Book;
import com.codegym.bt_borrow_book_aop.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public Iterable findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
