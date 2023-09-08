package com.incedo.graphql.app.service;

import com.incedo.graphql.app.entity.Book;
import com.incedo.graphql.app.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Integer id) {
        return bookRepository.findById(id).orElseThrow(() ->  new RuntimeException("Not found book"));
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }
}
