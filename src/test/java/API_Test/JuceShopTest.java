package API_Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;


public class JuceShopTest {

    @Test(priority = 1)
    public void newUser() {
        RestAssured.baseURI = "http://localhost:3000";
        Response resp = RestAssured.given().header("Content-Type", "application/json").body("{\n" +
                "  \"email\": \"abcde12345@gmail.com\",\n" +
                "  \"password\": \"password\",\n" +
                "  \"passwordRepeat\": \"password\",\n" +
                "  \"securityQuestion\": {\n" +
                "    \"id\": 1,\n" +
                "    \"question\": \"Your eldest siblings middle name?\",\n" +
                "    \"createdAt\": \"2020-06-05T08:56:52.477Z\",\n" +
                "    \"updatedAt\": \"2020-06-05T08:56:52.477Z\"\n" +
                "  },\n" +
                "  \"securityAnswer\": \"test\"\n" +
                "}").post("/api/Users").then().assertThat().statusCode(201).log().all().extract().response();

        String str_respone = resp.toString();
        System.out.println(str_respone);

    }
    @Test(priority = 2)
    public void getItem() {
        RestAssured.baseURI = "http://localhost:3000";

        Response rep = RestAssured.given().header("Content-Type", "application/json").when().queryParam("q", "apple").
                get("/rest/products/search").then().assertThat().statusCode(200).log().all().extract().response();
        String str = rep.toString();
        System.out.println(str);
    }
}
