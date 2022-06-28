package lt.vtmc.ExamVTMC.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.vtmc.ExamVTMC.models.BookCategory;


public interface BookCategoryRepository extends JpaRepository<BookCategory, Long>  {
	Optional<BookCategory> findByName(String name);
}
