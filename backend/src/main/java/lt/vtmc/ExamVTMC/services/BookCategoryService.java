package lt.vtmc.ExamVTMC.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.vtmc.ExamVTMC.models.BookCategory;
import lt.vtmc.ExamVTMC.payload.requests.BookCategoryInsertRequest;
import lt.vtmc.ExamVTMC.payload.requests.BookCategoryUpdateRequest;
import lt.vtmc.ExamVTMC.payload.responses.BookCategoryResponse;
import lt.vtmc.ExamVTMC.repositories.BookCategoryRepository;


@Service
public class BookCategoryService {
	private final BookCategoryRepository bookCategoryRepository;

    @Autowired
    public BookCategoryService(BookCategoryRepository bookCategoryRepository) {
        this.bookCategoryRepository = bookCategoryRepository;
    }
    public List<BookCategory> getAllBookCategories() {
        return bookCategoryRepository.findAll();
    }
    public BookCategoryResponse deleteBookCategory(Long id) {
        Optional<BookCategory> deletingBookCategory = bookCategoryRepository.findById(id);
        if (deletingBookCategory.isEmpty()) {
            throw new RuntimeException("Category does not exist");
        }
        bookCategoryRepository.deleteById(id);
        return null;
    }
    public BookCategoryResponse saveBookCategory(BookCategoryInsertRequest bookCategoryInsertRequest) {
        String categoryName = bookCategoryInsertRequest.getName();
        String bookCategoryName = categoryName.substring(0, 1).toUpperCase() + categoryName.substring(1);
        Optional<BookCategory> bookCategory = bookCategoryRepository.findByName(bookCategoryName);
        if (bookCategory.isPresent()) {
            throw new RuntimeException("Category already exists");
        }
        BookCategory newBookCategory = new BookCategory(bookCategoryName);
        bookCategoryRepository.save(newBookCategory);
        return new BookCategoryResponse(newBookCategory.getId(), newBookCategory.getName());
    }

    public BookCategoryResponse updateBookCategory(BookCategoryUpdateRequest bookCategoryUpdateRequest) {
        BookCategory bookCategory = bookCategoryRepository.getById(bookCategoryUpdateRequest.getId());
        if (bookCategory == null) {
            throw new RuntimeException("Category does not exist");
        }
        String categoryName = bookCategoryUpdateRequest.getName();
        String bookCategoryName = categoryName.substring(0, 1).toUpperCase() + categoryName.substring(1);
        Optional<BookCategory> bookCategory2 = bookCategoryRepository.findByName(bookCategoryName);
        if (bookCategory2.isPresent()) {
            throw new RuntimeException("Category already exists");
        }
        bookCategory.setName(bookCategoryName);
        bookCategoryRepository.save(bookCategory);
        return new BookCategoryResponse(bookCategory.getId(), bookCategory.getName());
    }
    
}
