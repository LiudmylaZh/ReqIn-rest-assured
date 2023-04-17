package reqres;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class GetSingleUser {
    public static String BASE_URI = "https://reqres.in/";
    public static Integer id = 3;
   @Test
    public void getUser () {
       UserData user = given()
               .baseUri(BASE_URI)
               .when()
               .get("api/users/"+id)
               .then().log().all()
               .extract().body().jsonPath().getObject("data", UserData.class);
       // field is not empty
       assertEquals(id, user.getId());
       assertFalse(user.getLast_name().isEmpty());
       assertNotNull(user.getAvatar());
        // avatar have "image"
       assertTrue(user.getAvatar().contains("image"));
       //email have end "@reqres.in"
       assertTrue(user.getEmail().contains("@reqres.in"));
       assertTrue(user.getEmail().endsWith("@reqres.in"));






    }
}
