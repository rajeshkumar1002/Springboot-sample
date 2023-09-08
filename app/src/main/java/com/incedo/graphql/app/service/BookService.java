package com.incedo.graphql.app.service;

import com.incedo.graphql.app.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(Integer id);
    Book saveBook(Book book);
}
