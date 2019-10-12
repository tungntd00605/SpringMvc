package com.ead.exam.controller;

import com.ead.exam.entity.Book;
import com.ead.exam.entity.Publisher;
import com.ead.exam.service.BookService;
import com.ead.exam.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/books")
public class BookController {
    @Autowired
    BookService bookService;
    @PostMapping
    public String search(@RequestParam String search, Model model){
        List<Book> books = bookService.searchBook(search);
        model.addAttribute("books", books);
        return "books";
    }
}
