package reqres;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Register {
    public static String BASE_URI = "https://reqres.in";

    @Test
    public void successfulRegistration (){
        Specifications.installSpecification(Specifications.requestSpecification(BASE_URI),
                Specifications.response200Ok());
        SuccessfulRegisterRequest request = new SuccessfulRegisterRequest ("eve.holt@reqres.in", "pistol");
        SuccessfulRegistrationResponse response = given()
                .body(request)
                .when().log().all()
                .post("/api/register")
                .then().log().all()
                .extract().body().as(SuccessfulRegistrationResponse.class);
        assertEquals(4, response.getId());
        assertEquals("QpwL5tke4Pnpja7X4", response.getToken());

    }
    @Test
    public void unsuccessfulRegistrationWithoutPassword (){
        Specifications.installSpecification(Specifications.requestSpecification(BASE_URI),
                Specifications.response400());
        SuccessfulRegisterRequest request = new SuccessfulRegisterRequest ("eve.holt@reqres.in", "");
        UnsuccessfulRegistrationResponse response = given()
                .body(request)
                .when().log().all()
                .post("/api/register")
                .then().log().all()
                .extract().body().as(UnsuccessfulRegistrationResponse.class);
        assertEquals("Missing password", response.getError());


    }

    @Test
    public void unsuccessfulRegistrationWithoutEmail (){
        Specifications.installSpecification(Specifications.requestSpecification(BASE_URI),
                Specifications.response400());
        SuccessfulRegisterRequest request = new SuccessfulRegisterRequest ("", "pistol");
        UnsuccessfulRegistrationResponse response = given()
                .body(request)
                .when().log().all()
                .post("/api/register")
                .then().log().all()
                .extract().body().as(UnsuccessfulRegistrationResponse.class);
        assertEquals("Missing email or username", response.getError());


    }

}
