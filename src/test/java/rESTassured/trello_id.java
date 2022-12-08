package rESTassured;

import static io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;



public class trello_id {
	public String  url ="https://api.trello.com/";
	 public String trl = "f8c4b776bf85eea467b2920a19cb9200cf5945e994f3a1841732c45d6b87581b";
	 public String key ="fe2d2cc763e8887e9c60dc32bac64b4f";
	 public String id;

	@Test(enabled=true)
	public void tc1_create() {
		JSONObject js = new JSONObject();	
	   RestAssured.baseURI=url;
	   Response response=given().queryParam("name", "bhuvi")
				.queryParam("key", key)
				.queryParam("token", trl)
				.header("Content-Type", "application/json")
				.when()
				.post("/1/boards/")
				.then()
				.assertThat().statusCode(200).contentType(ContentType.JSON)
				.extract().response();
				String jsonresponse = response.asString();
				JsonPath jr= new JsonPath(jsonresponse);	
				id = jr.get("id");
				System.out.println(id);		
			}
	@Test(enabled=false)
	public void tc2_getall() {
		JSONObject js = new JSONObject();
		   RestAssured.baseURI=url;
		    given().queryParam("key", key).queryParam("token", trl).contentType(ContentType.JSON).accept(ContentType.JSON).
		    when().get("1/members/me/boards/").then().statusCode(200).log().all();
		}
	@Test(enabled=false)
	public void tc3_update() {
		JSONObject js = new JSONObject();
		   RestAssured.baseURI=url;
		    given().queryParam("name", "trellb").queryParam("key", key).queryParam("token", trl).contentType(ContentType.JSON)
		    .accept(ContentType.JSON).when().put("1/boards/GkfEH5cd").then().statusCode(200).log().all();
		}
	@Test(enabled=true)
	public void tc4_delete() {
		JSONObject js = new JSONObject();
		   RestAssured.baseURI=url;
		    given().queryParam("key", key).queryParam("token", trl).contentType(ContentType.JSON)
		    .accept(ContentType.JSON).when().delete("/1/boards/"+id).then().log().all();
		}
	}

