package com.amazon.step_defs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;

public class APIDefs {


    String url = "https://jsonplaceholder.typicode.com/posts";
    Response response;
    @Given("Get a list of blog posts")
    public void get_a_list_of_blog_posts() {
                response = RestAssured
                .given()
                .accept(ContentType.JSON)
                .when()
                .get("https://jsonplaceholder.typicode.com/posts");

        Assert.assertEquals(200, response.statusCode());


    }


    List<Integer> listOfID;
    List<Integer> listOfUserID;
    @Then("Verify {string} have numposts as {int}")
    public void verifyHaveNumpostsAs(String arg0, int arg1) {

        listOfID = response.path("id");
        listOfUserID = response.path("userId");

        int a=0;
        for(int i=0;i<listOfID.size();i++){
            if(listOfUserID.get(i)==Integer.parseInt(arg0)){
                a++;
            }
        }
        System.out.println("a for " + arg0 + " = " + a);
        Assert.assertEquals(arg1,a);

    }

    @Then("Verify that per ID is unique")
    public void verifyThatPerIDIsUnique() {
        List<String> ID = response.path("id");
        boolean bool = true;
        for (int i = 0; i < ID.size()-1; i++) {
            for (int j=i+1;j<ID.size();j++){
                if(ID.get(i)==ID.get(j)){
                    bool = false;
                    break;
                }
            }
        }
       //verify that all id's are unique
       Assert.assertTrue(bool);

    }
}
