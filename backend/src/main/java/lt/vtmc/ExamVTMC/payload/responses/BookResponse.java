package lt.vtmc.ExamVTMC.payload.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {

    private Long bookId;

    private String bookName;

    private Long categoryId;

    private String bookSummary;

    private String isbn;

    private int pageCount;
}
