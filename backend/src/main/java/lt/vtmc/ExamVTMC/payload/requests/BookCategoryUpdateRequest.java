package lt.vtmc.ExamVTMC.payload.requests;

import javax.validation.constraints.NotBlank;

import lombok.Data;
@Data
public class BookCategoryUpdateRequest {

	@NotBlank
    private Long id;

    @NotBlank
    private String name;
}
