package com.ead.exam.service;

import com.ead.exam.entity.Book;
import com.ead.exam.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public void save(Book book){
        bookRepository.save(book);
    }

    public List<Book> findAll(){
       return bookRepository.findAll();
    }

    public List<Book> searchBook(String query){
       return bookRepository.searchBook(query);
    }

}
