package com.example.springgcpwebapp.repositories;

import com.example.springgcpwebapp.domains.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
