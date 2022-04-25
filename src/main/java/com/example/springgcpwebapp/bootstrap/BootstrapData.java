package com.example.springgcpwebapp.bootstrap;

import com.example.springgcpwebapp.domains.Author;
import com.example.springgcpwebapp.domains.Book;
import com.example.springgcpwebapp.domains.Publisher;
import com.example.springgcpwebapp.repositories.AuthorRepository;
import com.example.springgcpwebapp.repositories.BookRepository;
import com.example.springgcpwebapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;

public class BootstrapData implements CommandLineRunner {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public BootstrapData (AuthorRepository au, BookRepository bu, PublisherRepository pu) {
        authorRepository = au;
        bookRepository = bu;
        publisherRepository = pu;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());
    }
}
