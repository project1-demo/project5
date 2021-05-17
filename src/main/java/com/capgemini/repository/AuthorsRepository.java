package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.entities.Authors;
@Repository
public interface AuthorsRepository extends JpaRepository<Authors, Integer>{

}
