package lt.vtmc.ExamVTMC.payload.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class BookUpdateRequest {

    @NotBlank
    private Long bookId;

    @NotBlank
    private String bookName;

    @NotBlank
    private Long categoryId;

    @NotBlank
    private String bookSummary;

    @NotBlank
    private String isbn;
    
    @NotNull
    private int pageCount;
}
