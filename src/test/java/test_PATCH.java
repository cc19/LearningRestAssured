import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class test_PATCH {

    @Test
    public void test_01_patch() {
        JSONObject obj = new JSONObject();
        obj.put("first_name", "david");
        obj.put("job", "biker");
        given()
                .body(obj.toJSONString())
                .when()
                .patch("https://reqres.in/api/users/3")
                .then()
                .statusCode(200)
        .log().all();
    }
}
