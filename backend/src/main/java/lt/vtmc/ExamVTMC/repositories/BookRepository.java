package lt.vtmc.ExamVTMC.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.vtmc.ExamVTMC.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
