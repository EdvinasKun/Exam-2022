package lt.vtmc.ExamVTMC.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lt.vtmc.ExamVTMC.models.Book;
import lt.vtmc.ExamVTMC.payload.requests.BookInsertRequest;
import lt.vtmc.ExamVTMC.payload.requests.BookUpdateRequest;
import lt.vtmc.ExamVTMC.payload.responses.BookResponse;
import lt.vtmc.ExamVTMC.services.BookService;

@CrossOrigin
@RestController
@RequestMapping("/api/books")
public class BookController {

	private BookService bookService;
	
	public BookController (BookService bookService) {
		this.bookService = bookService;
	}
	
	@PostMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ResponseStatus(HttpStatus.CREATED)
	public BookResponse addBook(@Valid @RequestBody BookInsertRequest bookRequest) {
		return this.bookService.saveBook(bookRequest);
	}
	@PutMapping
    @ResponseStatus(HttpStatus.OK)
    public BookResponse updateBook(@RequestBody BookUpdateRequest bookUpdateRequest) {
        return this.bookService.updateBook(bookUpdateRequest);
    }
	@DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookResponse deleteBook(@PathVariable String id) {
        return this.bookService.deleteBook(Long.valueOf(id) );
    }
	@GetMapping
	public List<Book> getAllBooks(){
		return this.bookService.getAllBooks();
	}
}
