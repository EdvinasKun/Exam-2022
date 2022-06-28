package lt.vtmc.ExamVTMC.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "categories_id")
    private BookCategory bookCategory;
    
    @NotBlank
    private String bookName;
    
    @NotBlank
    private String bookSummary;
    
    @NotBlank
    private String isbn;
    
//    @NotBlank
//    private String picture;
    
    @NotBlank
    private int pageCount;
    
    
}
