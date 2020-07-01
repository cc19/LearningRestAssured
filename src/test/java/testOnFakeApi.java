import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class testOnFakeApi {


    public void testGET() {
        baseURI = "http://localhost:3000/";
        given()
                .get("/users")
                .then()
                .statusCode(200);

        // Searching for a particular element
        given()
                .param("name", "Physics")
                .get("/subjects")
                .then()
                .statusCode(200)
                .log().all();
    }

    public void testPOST() {
         baseURI = "http://localhost:3000/";

         JSONObject obj = new JSONObject();
         obj.put("name", "History");
         //System.out.println(obj);

         given()
                 .contentType(ContentType.JSON)
                 .accept(ContentType.JSON)
                 .header("Content-Type", "application/json")
                 .body(obj.toJSONString())
                 .when()
                 .post("/subjects")
                 .then()
                 .statusCode(201)
         .log().all();
     }

    public void testPatch() {
        baseURI = "http://localhost:3000/";

        JSONObject obj = new JSONObject();
        obj.put("name", "Biology");
        //System.out.println(obj);

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Content-Type", "application/json")
                .body(obj.toJSONString())
                .when()
                .patch("/subjects/3")
                .then()
                .statusCode(200)
                .log().all();
    }

    public void testPut() {
        baseURI = "http://localhost:3000/";

        JSONObject obj = new JSONObject();
        obj.put("id", "4");
        obj.put("name", "Stats");

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Content-Type", "application/json")
                .body(obj.toJSONString())
                .when()
                .put("/subjects/4")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void testDEL() {
        baseURI = "http://localhost:3000/";

        when()
                .delete("/subjects/4")
                .then()
                .statusCode(200);
    }
}
