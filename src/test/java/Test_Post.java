import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Test_Post {

    @Test
    public void test_01() {
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("name", "Jim");
//        map.put("job", "teacher");
//        System.out.println(map);
//
//        JSONObject request = new JSONObject(map);
//        System.out.println(request);

        JSONObject request1 = new JSONObject();
        request1.put("name","Chandrima");
        request1.put("job", "Engineer");
        //System.out.println(request1);

        given()
                .header("Content-Type", "application/json")
                .body(request1.toJSONString())
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201);
    }

}
