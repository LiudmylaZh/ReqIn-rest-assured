package dummy;

import io.restassured.http.ContentType;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import reqres.SuccessfulRegisterRequest;
import reqres.UnsuccessfulRegistrationResponse;
import reqres.UserData;

import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    public static String BASE_URI = "https://dummyapi.io/data/v1";

    @Test
    public void testGetList(){
        List <dummy.UserData> users =given()
                .baseUri(BASE_URI)
                .header("app-id", "638de9557c13851837e24c4c")
                .when().log().all()
                .contentType(ContentType.JSON)
                .get("/user")
                .then().log().all()
                .extract().body().jsonPath().getList("data", dummy.UserData.class);

        assertEquals(20, users.size());
        users.forEach(elements-> assertNotNull(elements.getId()));
    }

    public static String generateRandomEmail() {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-";
        String email = "";
        String temp = RandomStringUtils.random(12, allowedChars);
        email = temp.substring(0, temp.length() - 3) + "@robot-mail.com";
        return email;
    }

    @Test
    public void testCreateUser(){
        CreateUserRequest request = new CreateUserRequest ( "John", "Wick", generateRandomEmail());
        CreateUserResponse response = given()
                .baseUri(BASE_URI)
                .body(request)
                .header("app-id", "638de9557c13851837e24c4c")
                .when().log().all()
                .contentType(ContentType.JSON)
                .post("/user/create")
                .then().log().all()
                .extract().body().as(CreateUserResponse.class);
        assertNotNull(response.getId());



    }
}
