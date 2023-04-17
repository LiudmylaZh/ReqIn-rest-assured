package dummy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class UserData {
    private String id;
    private String title;
    private String firstName;
    private String lastName;
    private String picture;




}
