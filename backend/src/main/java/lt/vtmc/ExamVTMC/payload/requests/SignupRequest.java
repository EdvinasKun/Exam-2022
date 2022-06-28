package lt.vtmc.ExamVTMC.payload.requests;

import java.util.Set;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {

	@NotBlank
	private String username;

	@NotBlank
	@Email
	private String email;

	@NotBlank
	@Size(min = 6)
	private String password;

	private Set<String> role;
}
