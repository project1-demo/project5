package com.capgemini;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.Department;
import com.capgemini.repository.DepartmentRepository;

@RequestMapping("/api/department/")
@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	@PostMapping("/")
	public String create(@RequestBody Department department) {
		departmentRepository.save(department);
		return "Department created";
		
	
	}
	@GetMapping("/{id}")
	public Department findById(@PathVariable int id) {
		
		return departmentRepository.findById(id).get();

}
}
