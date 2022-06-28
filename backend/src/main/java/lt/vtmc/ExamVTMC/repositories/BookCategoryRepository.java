package lt.vtmc.ExamVTMC.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.vtmc.ExamVTMC.models.BookCategory;

@Repository
public interface BookCategoryRepository extends JpaRepository<BookCategory, Long>  {
	Optional<BookCategory> findByName(String name);
}
