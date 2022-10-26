package com.codegym.bt_borrow_book_aop.service.borrow;

import com.codegym.bt_borrow_book_aop.model.BorrowBook;
import com.codegym.bt_borrow_book_aop.repository.IBorrowBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BorrowBookService implements IBorrowBookService {
    @Autowired
    private IBorrowBookRepository borrowBookRepository;

    @Override
    public Iterable<BorrowBook> findAll() {
        return borrowBookRepository.findAll();
    }

    @Override
    public Optional<BorrowBook> findById(Long id) {
        return borrowBookRepository.findById(id);
    }

    @Override
    public void save(BorrowBook borrowBook) {
        borrowBookRepository.save(borrowBook);
    }

    @Override
    public void deleteById(Long id) {
        borrowBookRepository.deleteById(id);
    }

    @Override
    public Optional<BorrowBook> findBorrowCodeByCode(String code) {
        return borrowBookRepository.findBorrowBookByBookCode(code);
    }
}
