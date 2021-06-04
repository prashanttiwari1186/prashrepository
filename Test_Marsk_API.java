import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;

public class Test_Marsk {
    public static void main(String[] args) {

        RestAssured.baseURI= "https://rahulshettyacademy.com";
        //Capturing the response
        String response=given().baseUri("https://api.spacexdata.com")
            .when().get("/v4/launches/latest")
                .then().assertThat().statusCode(200).
                extract().response().asString();

        System.out.println(response);
        // Converting the raw reponse to json path for parsing
        JsonPath js=new JsonPath(response); //for parsing Json
        // Capturing value for specific field in the response
        String id=js.getString("id");
        //Printing the value of specific field
        System.out.println("Id of the response: "+id);//5fe3af84b3467846b3242161
    }
}
