package reqres;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;


import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class GetUserListTest {
    public static String BASE_URI = "https://reqres.in/";
    public static Integer id = 3;
    @Test
    public void getList() {
             given().baseUri("https://reqres.in/api")
                .when().log().all()
                .get("/users?page=2")
                .then().log().all();

    }

    @Test
    public void getListWithResponse() {
        Response response = given().baseUri("https://reqres.in/")
                .when().log().all()
                .get("/users?page=2");

        assertEquals(200, response.getStatusCode());
        assertFalse(response.asString().isEmpty());
        System.out.println(response.asString());


    }
    @Test
    public void getListWithAssertInside () {
        given().baseUri("https://reqres.in/api")
                .when().log().all()
                .get("/users?page=2")
                .then().log().all()
                .assertThat()
                .statusCode(200)
        .body("page", Matchers.is(2));

    }
    @Test
    public void getListToClass (){
        List<UserData> users = given()
                .baseUri(BASE_URI)
                .when()
                .get("api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);
        System.out.println(users.get(0).getId());
        //users contains 6 elements
        assertEquals(6, users.size());
        // id of all elements have positive number (>0)
        for (UserData element:users) {
            assertTrue(element.getId()>0);
            assertTrue(element.getEmail().endsWith("reqres.in"));
        }
        users.forEach(element -> assertTrue(element.getId()>0));
        users.forEach(endsOfEmail -> assertTrue(endsOfEmail.getEmail().endsWith("reqres.in")));
        assertTrue(users.stream().allMatch(x->x.getId()>0 && x.getEmail().endsWith("@reqres.in")));

        //avatar of each user has id of user

        for (UserData element: users) {
            assertTrue(element.getAvatar().contains(element.getId().toString()));
        }
        users.forEach(elements-> assertTrue(elements.getAvatar().contains(elements.getId().toString())));
    }
}
