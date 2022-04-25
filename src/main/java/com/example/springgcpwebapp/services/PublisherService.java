package com.example.springgcpwebapp.services;

import com.example.springgcpwebapp.domains.Publisher;
import com.example.springgcpwebapp.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {
    @Autowired
    private PublisherRepository repo;

    public Iterable<Publisher> listAll() {
        return repo.findAll();
    }

    public void save(Publisher publisher) {
        repo.save(publisher);
    }

    public Publisher get(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

}