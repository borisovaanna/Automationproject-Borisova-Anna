package Task_16;

import Task_16.DelayedResponse.RootDelayResponse;
import Task_16.ListResource.RootListResource;
import Task_16.ListUsers.RootList;
import Task_16.SingleResource.RootSingleResource;
import Task_16.SingleUser.Root;
import com.google.gson.Gson;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.*;

public class Task_16 {

    public static String readFileAsString(String fileName){
        try {
            return new String(Files.readAllBytes(Paths.get("src/test/java/Task_16/Requests/" + fileName + ".json")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    @BeforeTest
    public void preconditions(){
        baseURI = "https://reqres.in";
    }

    @Test
    public void SingleUserGetTest1(){
        String endpoint = "/api/users?id=1";
        Gson gson = new Gson();
        Root root = gson.fromJson(given().when().get(endpoint).getBody().asPrettyString(), Root.class);
        Assert.assertEquals(root.data.id, 1);
    }

    @Test
    public void SingleUserGetTest2(){
        String endpoint = "/api/users?id=5";
        Root root = given().when().get(endpoint).as(Root.class);
        Assert.assertEquals(root.data.id, 5);
    }

    @Test
    public void SingleUserGetTest3(){
        String endpoint = "/api/users?id=3";
        given().when().get(endpoint).then().statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void SingleUserGetTest4(){
        String endpoint = "/api/users";
        Assert.assertEquals(given().when().param("id", 7).get(endpoint).as(Root.class).data.id,7);
    }

    @Test
    public void ListUsersGetTest(){
        String endpoint = "/api/users";
        given().when().get(endpoint).then().statusCode(200);
        Assert.assertEquals(given().when().param("page", 1).get(endpoint).as(RootList.class).data.size(), 6);
        Assert.assertEquals(given().when().get(endpoint).as(RootList.class).data.get(2).last_name, "Wong");
    }

    @Test
    public void SingleUserNotFoundGetTest(){
        String endpoint = "/api/users/25";
        given().when().get(endpoint).then().statusCode(404);
    }

    @Test
    public void ListResourceGetTest(){
        String endpoint = "/api/unknown";
        given().when().get(endpoint).then().statusCode(200);
        Assert.assertEquals(given().when().get(endpoint).as(RootListResource.class).data.size(), 6);
        Assert.assertEquals(given().when().get(endpoint).as(RootListResource.class).data.get(0).name, "cerulean");
    }

    @Test
    public void SingleResourceGetTest(){
        String endpoint = "/api/unknown/4";
        given().when().get(endpoint).then().statusCode(200);
        Assert.assertEquals(given().when().get(endpoint).as(RootSingleResource.class).data.id, 4);
        Assert.assertEquals(given().when().get(endpoint).as(RootSingleResource.class).data.name, "aqua sky");
    }

    @Test
    public void SingleResourceNotFoundGetTest(){
        String endpoint = "api/unknown/21";
        given().when().get(endpoint).then().statusCode(404);
    }

    @Test
    public void CreatePostTest(){
        String endpoint = "/api/users";
        String requestBody = readFileAsString("post");
        Response response = given().header("Content-Type", "application/json").and().body(requestBody).and().post(endpoint).then().extract().response();
        Assert.assertEquals(response.statusCode(),201);
        Assert.assertEquals(response.jsonPath().get("name"), "morpheus");
        Assert.assertEquals(response.jsonPath().get("job"), "leader");
    }

    @Test
    public void UpdatePutTest(){
        String endpoint = "/api/users/2";
        String requestBody = readFileAsString("put");
        Response response = given().header("Content-Type", "application/json").and().body(requestBody).and().put(endpoint).then().extract().response();
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.jsonPath().get("name"), "morpheus");
        Assert.assertEquals(response.jsonPath().get("job"), "zion resident");
    }

    @Test
    public void UpdatePatchTest(){
        String endpoint = "/api/users/2";
        String requestBody = readFileAsString("patch");
        Response response = given().header("Content-Type", "application/json").and().body(requestBody).and().patch(endpoint).then().extract().response();
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.jsonPath().get("name"), "morpheus");
        Assert.assertEquals(response.jsonPath().get("job"), "zion resident");
    }

    @Test
    public void DeleteTest(){
        String endpoint = "/api/users/2";
        Response response = given().delete(endpoint).then().extract().response();
        Assert.assertEquals(response.statusCode(),204);
    }

    @Test
    public void PostRegSucTest(){
        String endpoint = "/api/register";
        String requestBody = readFileAsString("postRegSuc");
        Response response = given().header("Content-Type", "application/json").and().body(requestBody).and().post(endpoint).then().extract().response();
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.jsonPath().get("token"), "QpwL5tke4Pnpja7X4");
    }

    @Test
    public void PostRegUnSucTest(){
        String endpoint = "/api/register";
        String requestBody = readFileAsString("postRegUnSuc");
        Response response = given().header("Content-Type", "application/json").and().body(requestBody).and().post(endpoint).then().extract().response();
        Assert.assertEquals(response.statusCode(),400);
        Assert.assertEquals(response.jsonPath().get("error"), "Missing password");
    }

    @Test
    public void PostLogSucTest(){
        String endpoint = "/api/login";
        String requestBody = readFileAsString("postLogSuc");
        Response response = given().header("Content-Type", "application/json").and().body(requestBody).and().post(endpoint).then().extract().response();
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.jsonPath().get("token"), "QpwL5tke4Pnpja7X4");
    }

    @Test
    public void PostLogUnSucTest(){
        String endpoint = "/api/login";
        String requestBody = readFileAsString("postLogUnSuc");
        Response response = given().header("Content-Type", "application/json").and().body(requestBody).and().post(endpoint).then().extract().response();
        Assert.assertEquals(response.statusCode(),400);
        Assert.assertEquals(response.jsonPath().get("error"), "Missing password");
    }

    @Test
    public void DelayResponseGetTest(){
        String endpoint = "api/users?delay=4";
        given().when().get(endpoint).then().statusCode(200);
        Assert.assertEquals(given().when().get(endpoint).as(RootDelayResponse.class).data.size(), 6);
        Assert.assertEquals(given().when().get(endpoint).as(RootDelayResponse.class).data.get(2).first_name, "Emma");
        Assert.assertEquals(given().when().get(endpoint).as(RootDelayResponse.class).data.get(5).email, "tracey.ramos@reqres.in");
    }
}
