package com.capgemini;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.Authors;
import com.capgemini.repository.AuthorsRepository;

@RestController
	@RequestMapping("/api/authors/")
	public class AuthorController {
		
		@Autowired
		private AuthorsRepository authorRepository;

		@PostMapping("/")
		public String create(@RequestBody Authors author) {
			
			authorRepository.save(author);
			
			return "Author Created!!";
		}
		
		
		@GetMapping("/{id}")
		public Authors findById(@PathVariable int id) {
			
			return authorRepository.findById(id).get();
		}
}
