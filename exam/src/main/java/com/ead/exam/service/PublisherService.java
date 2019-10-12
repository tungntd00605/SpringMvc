package com.ead.exam.service;

import com.ead.exam.entity.Publisher;
import com.ead.exam.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    @Autowired
    PublisherRepository publisherRepository;

    public List<Publisher> publisherList(){
        return publisherRepository.findAll();
    }


    public void save(Publisher publisher) {
        publisherRepository.save(publisher);
    }
}
