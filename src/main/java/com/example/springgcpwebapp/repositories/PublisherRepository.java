package com.example.springgcpwebapp.repositories;

import com.example.springgcpwebapp.domains.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
