package com.codegym.bt_borrow_book_aop.service.borrow;

import com.codegym.bt_borrow_book_aop.model.BorrowBook;
import com.codegym.bt_borrow_book_aop.service.IGeneralService;

import java.util.Optional;

public interface IBorrowBookService extends IGeneralService<BorrowBook> {
    Optional<BorrowBook> findBorrowCodeByCode(String code);

}
