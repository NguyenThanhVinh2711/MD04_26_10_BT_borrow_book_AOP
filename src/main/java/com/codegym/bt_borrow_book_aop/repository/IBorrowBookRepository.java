package com.codegym.bt_borrow_book_aop.repository;

import com.codegym.bt_borrow_book_aop.model.Book;
import com.codegym.bt_borrow_book_aop.model.BorrowBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IBorrowBookRepository extends JpaRepository<BorrowBook,Long> {
    Optional<BorrowBook> findBorrowBookByBookCode(String bookCode );
}
