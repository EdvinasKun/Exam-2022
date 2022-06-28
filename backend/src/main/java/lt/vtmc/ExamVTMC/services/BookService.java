package lt.vtmc.ExamVTMC.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.vtmc.ExamVTMC.models.Book;
import lt.vtmc.ExamVTMC.models.BookCategory;
import lt.vtmc.ExamVTMC.payload.requests.BookInsertRequest;
import lt.vtmc.ExamVTMC.payload.requests.BookUpdateRequest;
import lt.vtmc.ExamVTMC.payload.responses.BookResponse;
import lt.vtmc.ExamVTMC.repositories.BookCategoryRepository;
import lt.vtmc.ExamVTMC.repositories.BookRepository;



@Service
public class BookService {
	private final BookRepository bookRepository;
    private final BookCategoryRepository bookCategoryRepository;

    @Autowired
    public BookService(BookRepository bookRepository,  BookCategoryRepository bookCategoryRepository) {
        this.bookRepository = bookRepository;
        this.bookCategoryRepository = bookCategoryRepository;
    }
    public BookResponse saveBook(BookInsertRequest bookInsertRequest) {
        BookCategory bookCategory = bookCategoryRepository.getById(bookInsertRequest.getCategoryId());
        String bookName = bookInsertRequest.getBookName();
        Book book = new Book(
                );
        book.setBookCategory(bookCategory);
        book.setBookName(bookName.substring(0, 1).toUpperCase() + bookName.substring(1));
        book.setBookSummary(bookInsertRequest.getBookSummary());
        book.setIsbn(bookInsertRequest.getIsbn());
        book.setPageCount(bookInsertRequest.getPageCount());

        bookRepository.save(book);
        return new BookResponse(
                book.getId(),
                bookInsertRequest.getBookName(),
                bookInsertRequest.getCategoryId(),
                bookInsertRequest.getBookSummary(),
                bookInsertRequest.getIsbn(),
                bookInsertRequest.getPageCount()
                
                );
    }
    public BookResponse updateBook(BookUpdateRequest bookUpdateRequest) {
    	return null;
        
    }

    public BookResponse deleteBook(String id) {

        Book deletingBook = bookRepository.getById(Long.valueOf(id));

        bookRepository.delete(deletingBook);
        return null;
    }
    
	public List<Book> getAllBooks(){
		return this.bookRepository.findAll();
	}
}
