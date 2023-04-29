import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;


public class ReqresInTest2 {

    public static String guotes(String s) {
        return "\"" + s + "\"";
    }

    @Test
    void checkCreateNewUser() {
        //  String body = "{ \"name\": \"morpheus\", \"job\": \"leader\" }";
        String name = "morpheus";
        String job = "leader";
        String body = String.format("{ %s: %s, %s: %s}", guotes("name"), guotes(name),
                guotes("job"), guotes(job));

        given()
                .log().uri()
                .log().body()
                .body(body)
                .contentType(JSON)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .log().status()
                .log().body()
                .statusCode(201)
                .body("name", is("morpheus"));
    }

}

