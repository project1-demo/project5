package com.capgemini;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.Department;
import com.capgemini.entities.Employee;
import com.capgemini.repository.DepartmentRepository;
import com.capgemini.repository.EmployeeRepository;

@RequestMapping("/api/employee/")
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	@PostMapping("/")
	public String create(@RequestBody  Employee employee) {
		employeeRepository.save(employee);
		return "Employee added";
	}
		@GetMapping("/{id}")
		public Employee findById(@PathVariable int id) {
			return employeeRepository.findById(id).get();
		}
		

		
		@GetMapping("/email/{emailId}")
		public Employee findByEmailllllll(@PathVariable String emailId) {
			
			return employeeRepository.findByEmail(emailId);
		}
		
		@GetMapping("/mobile/{mobile}")
		public List<Employee> findByMobile(@PathVariable String mobile) {
			
			return employeeRepository.findByMobile(mobile);
		}
		
		
		@GetMapping("/all")
		List<Employee> findAllEmployees() {
			// return employeeRepository.findAll();
			
			return employeeRepository.customFindAllEmployees();
		}
		
		
		@PostMapping("/custom/authenticate")
		Employee customFindByEmailAndPassword(@RequestBody Employee employee) {
			
			return employeeRepository.customFindByEmailAndPassword(employee.getEmail(), employee.getPassword());
		}
		
		
		
		
		
		
		
		
		
		@PutMapping("/{employeeId}/department/{departmentId}")
		public String asssignDeparment(@PathVariable int employeeId, @PathVariable int departmentId ) {
		
			Employee employee = employeeRepository.findById(employeeId).get();
			Department department =  departmentRepository.findById(departmentId).get();
			
			// associate them / link them
			employee.setDepartment(department);
			
			// update method
			employeeRepository.save(employee);
			
			return "Departmeent Linked";
		
	}
}