package dummy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CreateUserResponse {
    private String id;
    private String title;
    private String firstName;
    private String lastName;
    private String email;
    private String registerDate;
    private String updatedDate;


}
