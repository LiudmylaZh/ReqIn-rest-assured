package reqres;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest {
    public static String BASE_URI = "https://reqres.in";
    @Test
    public void successfulLogin (){
        Specifications.installSpecification(Specifications.requestSpecification(BASE_URI),
                Specifications.response200Ok());
        SuccessfulRegisterRequest request = new SuccessfulRegisterRequest ("eve.holt@reqres.in", "cityslicka");
        SuccessfulRegistrationResponse response = given()
                .body(request)
                .when().log().all()
                .post("/api/login")
                .then().log().all()
                .extract().body().as(SuccessfulRegistrationResponse.class);
        assertEquals("QpwL5tke4Pnpja7X4", response.getToken());

    }

    @Test
    public void unsuccessfulLogin (){
        Specifications.installSpecification(Specifications.requestSpecification(BASE_URI),
                Specifications.response400());
        SuccessfulRegisterRequest request = new SuccessfulRegisterRequest ("", "cityslicka");
        UnsuccessfulRegistrationResponse response = given()
                .body(request)
                .when().log().all()
                .post("/api/login")
                .then().log().all()
                .extract().body().as(UnsuccessfulRegistrationResponse.class);
        assertEquals("Missing email or username", response.getError());

    }

    @Test
    public void unsuccessfulLoginWithNotValidEmail (){
        Specifications.installSpecification(Specifications.requestSpecification(BASE_URI),
                Specifications.response400());
        SuccessfulRegisterRequest request = new SuccessfulRegisterRequest ("dfdf@ds", "cityslicka");
        UnsuccessfulRegistrationResponse response = given()
                .body(request)
                .when().log().all()
                .post("/api/login")
                .then().log().all()
                .extract().body().as(UnsuccessfulRegistrationResponse.class);
        assertEquals("user not found", response.getError());

    }
}
