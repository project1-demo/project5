package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.entities.Books;
@Repository
public interface BooksRepository extends JpaRepository<Books, Integer> {

}
