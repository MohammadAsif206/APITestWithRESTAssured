package stepsdefinition;

import io.restassured.http.ContentType;
import org.hamcrest.core.Is;

import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;

public class BDDStyleMethod {
    public static void GetOneStudent(String id){
        given().contentType(ContentType.JSON)
                .when().get(String.format("http://localhost:3000/student/%s",id))
                .then().body("name", is("khadija asif"));
    }
    public static void GetStudentsInSameClass(){
        given().contentType(ContentType.JSON)
                .when().get(String.format("http://localhost:3000/student/"))
                .then().body("class",containsInAnyOrder("ENG","ENG","ENG","HUM")).statusCode(200);
    }
    public static void GetWithPathParameter(){
        given().contentType(ContentType.JSON).
                with().pathParams("id",3).
                when().get("http://localhost:3000/student/{id}").
                        then().body("class", containsString("ENG")).log();

    }
    public static void GetWithQueryParameter(){
        given().contentType(ContentType.JSON).
                with().queryParam("id",1).
                when().get("http://localhost:3000/student").
                then().body("class", hasItem("ENG"));

    }
    public static void PostWithBoydYParams(){
        HashMap<String,String> postContent = new HashMap<>();
        postContent.put("id","6");
        postContent.put("name","Hamid");
        postContent.put("age","10");
        postContent.put("class","HUM");

        given().contentType(ContentType.JSON).
                with().body(postContent).
                when().post("http://localhost:3000/student").
                then().body("class", Is.is("HUM")).log();;

    }
}

