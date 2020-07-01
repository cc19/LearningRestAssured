import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class test_PUT {

    @Test
    public void test_01() {
        JSONObject obj = new JSONObject();
        obj.put("name", "Sana");
        obj.put("job", "dancer");

        given()
                .body(obj.toJSONString())
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .statusCode(200);
    }


}
