package com.codegym.bt_borrow_book_aop.service;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T>  findAll();
    Optional<T> findById(Long id);
    void save(T t);
    void deleteById(Long id);

}
