package stepsdefinition;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import utilities.RestAssuredExtension;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;

public class HTTPRequests {

    private static ResponseOptions<Response> responseOptions;

    @Given("^User executes GET operation for \"([^\"]*)\"$")
    public void user_executes_get_operation_for(String url) throws Throwable {
       responseOptions = RestAssuredExtension.GetOpsWithoutPathPrams(url);

    }

    @Then("^User should be able to see the student name as \"([^\"]*)\"$")
    public void user_should_be_able_to_see_the_student_name_as(String name) {
       //responseOptions = RestAssuredExtension.GetOpsWithoutPathPrams(name);
       assertThat(responseOptions.getBody().jsonPath().get("name"), hasItem("mohammad"));

    }

    @Given("^User executes GET operation for the \"([^\"]*)\"$")
    public void userExecutesGETOperationForThe(String arg0) {
    }

    @Then("User should be able to see the  name of the students")
    public void user_should_be_able_to_see_the_name_of_the_students() {
        // Write code here that turns the phrase above into concrete actions
        BDDStyleMethod.GetStudentsInSameClass();
    }

    @Then("User should be able to verify pathParam of GET")
    public void userShouldBeAbleToVerifyPathParamOfGET() {
       // BDDStyleMethod.GetWithPathParameter();
        BDDStyleMethod.GetWithQueryParameter();
    }

    @Given("^User executes POST operation for the \"([^\"]*)\"$")
    public void userExecutesPOSTOperationForThe(String arg) throws Throwable{
        BDDStyleMethod.PostWithBoydYParams();
    }

    @Given("^User executes POST operation for the \"([^\"]*)\" with body$")
    public void userExecutesPOSTOperationForTheWithBody(String url, DataTable table) throws Throwable {

        //set body
        final var data = table.row(1).get(0);
        final var data1 = table.row(1).get(1);
        HashMap<String,String> body = new HashMap<>();
        body.put("name", data.toString());


        //set param
        HashMap<String,String> pathParms = new HashMap<>();
        pathParms.put("profileNo",data1.toString());
        responseOptions = RestAssuredExtension.PostWithBodyPramsAndPathParams(url,pathParms,body);
    }

    @Then("User should be able to see the profile name as {string}")
    public void user_should_be_able_to_see_the_profile_name_as(String string) {
        // Write code here that turns the phrase above into concrete actions
       // System.out.println(responseOptions.getBody());
    }


}
