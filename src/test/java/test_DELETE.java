import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class test_DELETE {

    @Test
    public void test_del() {
        given()
                .delete("https://reqres.in/api/users/2")
                .then()
                .statusCode(204)
        .log().all();
    }
}
