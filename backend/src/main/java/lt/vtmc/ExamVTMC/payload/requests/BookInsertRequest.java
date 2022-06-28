package lt.vtmc.ExamVTMC.payload.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
@NoArgsConstructor
public class BookInsertRequest {

    @NotBlank
    private String bookName;

   

    @NotBlank
    private String bookSummary;

    @NotBlank
    private String isbn;
    
    @NotNull
    private int pageCount;
    @NotNull
    private Long categoryId;
}
