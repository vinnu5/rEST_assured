package rESTassured;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class trello {
 public String  url ="https://api.trello.com/";
 public String trl = "f8c4b776bf85eea467b2920a19cb9200cf5945e994f3a1841732c45d6b87581b";
 public String key ="fe2d2cc763e8887e9c60dc32bac64b4f";
 @Test
 public void t1() {
	   Response res = RestAssured.get(url);
	   
 }
 @Test 
 public void t2() {
	 RestAssured.baseURI=url;
	 given().queryParam("name","best2").queryParam("key",key)
	 .queryParam("token", trl).when()
	 .contentType(ContentType.JSON).accept(ContentType.JSON)
	 .post("/1/boards").then().log().all()	;
	 }
}