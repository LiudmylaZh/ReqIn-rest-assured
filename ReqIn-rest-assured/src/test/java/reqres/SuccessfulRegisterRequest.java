package reqres;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor

public class SuccessfulRegisterRequest {
    private String email;
    private String password;
}
