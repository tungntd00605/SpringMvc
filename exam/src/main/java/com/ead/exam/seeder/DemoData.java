package com.ead.exam.seeder;

import com.ead.exam.entity.Book;
import com.ead.exam.entity.Publisher;
import com.ead.exam.service.BookService;
import com.ead.exam.service.PublisherService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DemoData {

    private final PublisherService publisherService;
    private final BookService bookService;

    public DemoData(PublisherService publisherService, BookService bookService) {
        this.publisherService = publisherService;
        this.bookService = bookService;
    }

    @EventListener
    public void appReady(ApplicationReadyEvent event) {
        List<Publisher> publisherResult = publisherService.publisherList();
        if(publisherResult.size() <= 0){
            ArrayList<Publisher> publishers = new ArrayList<>(Arrays.asList(
                    new Publisher("Tuoi Tre", "Ha Noi - Viet Nam", "This is my contact", "0999999999"),
                    new Publisher("Kim Dong", "Tp.HCM - Viet Nam", "This is my contact", "0999999999")));
            if (publishers.size() > 0){
                ArrayList<Book> books = new ArrayList<>(Arrays.asList(
                        new Book("Doraemon", "Fujiko Fujio", "Thieu nhi, Hai huoc", publishers.get(0)),
                        new Book("Conan", "Aoyama Gōshō", "Trinh tham", publishers.get(1))
                ));
                for (Book book : books) {
                    bookService.save(book);
                }
            }
        }





    }
}