package com.codegym.bt_borrow_book_aop.repository;

import com.codegym.bt_borrow_book_aop.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<Book,Long> {
}
