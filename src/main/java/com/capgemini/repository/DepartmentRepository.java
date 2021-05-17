package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.entities.Department;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
