import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

// dataProvider method and test method in the same class

public class DataDrivenExample1 {

    @DataProvider(name = "users_data")
    public Object[][] dataProvide() {
//        Object[][] data = new Object[2][3]; //we have 2 rows for 3 columns
//        data[0][0] = "Rajat";
//        data[0][1] = "Kapoor";
//        data[0][2] = 6;
//
//        data[1][0] = "Seema";
//        data[1][1] = "Biswas";
//        data[1][2] = 3;
//
//        return data;
//      Same thing as above can be done also as:

        return new Object[][]  {
                {"Leena", "Vaidya", 3},
                {"Pramod", "Mathur", 5},
                {"Captain","Cool", 6}
};

    }

    @Test(dataProvider = "users_data")
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

    //Deletion using DataProvider
    @DataProvider(name = "deletionData")
    public Object[] dataForDeletion() {
        return new Object[] {
                1, 3, 8
        };
    }

    //@Test(dataProvider = "deletionData")
    public void testDEL(int id) {
        baseURI = "http://localhost:3000/";

        when()
                .delete("/users/"+id)
                .then()
                .statusCode(200);
    }
}
