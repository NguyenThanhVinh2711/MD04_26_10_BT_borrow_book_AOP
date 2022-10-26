package com.codegym.bt_borrow_book_aop.model;

import com.codegym.bt_borrow_book_aop.model.Book;

import javax.persistence.*;

@Entity
public class BorrowBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String bookCode;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public BorrowBook() {
    }

    public BorrowBook(String bookCode, Book book) {
        this.bookCode = bookCode;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
