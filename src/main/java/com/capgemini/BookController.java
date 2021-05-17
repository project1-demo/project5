package com.capgemini;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.Authors;
import com.capgemini.entities.Books;
import com.capgemini.repository.AuthorsRepository;
import com.capgemini.repository.BooksRepository;

@RestController
@RequestMapping("/api/books/")
public class BookController {
	
	@Autowired
	private BooksRepository booksRepository;
	
	@Autowired
	private AuthorsRepository authorsRepository;
	
	@PostMapping("/")
	public String create(@RequestBody Books books) {
		booksRepository.save(books);
		return "books crearted";
	}
	@GetMapping("/{id}")
	public Books findById(@PathVariable int id) {
		
		return booksRepository.findById(id).get();
	}		
		@PutMapping("/{booksId}/authors/{authorsId}")
		public String assignAuthors(@PathVariable int booksId, @PathVariable int authorsId) {
			
			Books books = booksRepository.findById(booksId).get();
			Authors authors = authorsRepository.findById(authorsId).get();
			
			books.getAuthors().add(authors);
			booksRepository.save(books);
			
			return "Author assigned";

}
}