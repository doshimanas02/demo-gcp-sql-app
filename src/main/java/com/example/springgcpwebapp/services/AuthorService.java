package com.example.springgcpwebapp.services;

import com.example.springgcpwebapp.domains.Author;
import com.example.springgcpwebapp.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository repo;

    public Iterable<Author> listAll() {
        return repo.findAll();
    }

    public void save(Author author) {
        repo.save(author);
    }

    public Author get(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

}