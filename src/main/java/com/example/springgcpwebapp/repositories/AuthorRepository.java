package com.example.springgcpwebapp.repositories;

import com.example.springgcpwebapp.domains.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
