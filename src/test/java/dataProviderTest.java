import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class dataProviderTest extends DataForTest {

    //@Test(dataProvider = "users_data")
    public void testPOST(String firstName, String lastName, int subjectId) {
        baseURI = "http://localhost:3000/";

        JSONObject obj = new JSONObject();
        obj.put("firstName", firstName);
        obj.put("lastName", lastName);
        obj.put("subjectId", subjectId);

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Content-Type", "application/json")
                .body(obj.toJSONString())
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .log().all();
    }

    //@Test(dataProvider = "deletionData")
    public void testDEL(int id) {
        baseURI = "http://localhost:3000/";

        when()
                .delete("/users/"+id)
                .then()
                .statusCode(200);
    }

    @Parameters("userId")
    @Test
    public void testDELParam(int userId) {
        baseURI = "http://localhost:3000/";

        when()
                .delete("/users/"+userId)
                .then()
                .statusCode(200);
    }
}
