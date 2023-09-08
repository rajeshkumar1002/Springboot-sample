package com.incedo.graphql.app.controller;

import com.incedo.graphql.app.entity.Book;
import com.incedo.graphql.app.entity.BookInput;
import com.incedo.graphql.app.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @QueryMapping
    List<Book> allBooks(){
        return bookService.getAllBooks();
    }

    @QueryMapping
    Book getBook(@Argument Integer id){
        return bookService.getBookById(id);
    }

    @MutationMapping
    Book saveBook(@Argument BookInput book){
        Book newBook = new Book();
        newBook.setAuthor(book.getAuthor());
        newBook.setTitle(book.getTitle());
        return bookService.saveBook(newBook);
    }
}
