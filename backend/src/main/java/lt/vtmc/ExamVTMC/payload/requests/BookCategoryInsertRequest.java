package lt.vtmc.ExamVTMC.payload.requests;

import javax.validation.constraints.NotBlank;

import lombok.Data;
@Data
public class BookCategoryInsertRequest {

	@NotBlank
    private String name;
	
}
