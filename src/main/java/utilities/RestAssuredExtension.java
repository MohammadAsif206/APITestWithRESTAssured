/**
 * NON-BDD-Style REST-assured
 *
 */


package utilities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public class RestAssuredExtension {

    public static RequestSpecification Request;
    public RestAssuredExtension(){
        //Arrange
        RequestSpecBuilder  builder = new RequestSpecBuilder();
        builder.setBaseUri("http://localhost:3000");
        builder.setContentType(ContentType.JSON);
        var requestSpec = builder.build();
        Request = RestAssured.given().spec(requestSpec);

    }

    // Act
    public static  void GetOpsWithPathPrams(String url, Map<String,String> pathPram) {
        Request.pathParams(pathPram);
        try {
            Request.get(new URI(url));
        }catch (URISyntaxException e){
            e.printStackTrace();
        }

    }
    public static ResponseOptions<Response> GetOpsWithoutPathPrams(String url){
        //Act
        try {
            return Request.get(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResponseOptions<Response> PostWithBodyPramsAndPathParams(String url, Map<String,String> pathPram, Map<String,String> body) {
        Request.pathParams(pathPram);
        Request.body(body);
        return Request.post(url);

    }

}
