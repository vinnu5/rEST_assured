package rESTassured;
import io.restassured.*;
import static io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class login_post {
   public String url = "https://reqres.in/api/users?page=2" ;
   @Test(enabled = false)
   public void t1(){
	   Response rep = RestAssured.get(url) ;
	   int actual = rep.statusCode();
	   Assert.assertEquals(actual, 200);
	   
	   }
   @Test()
   public void t2(){
	  JSONObject js = new JSONObject();
	  js.put("email", "eve.holt@reqres.in");
	  js.put("password", "cityslicka");
	  System.out.println(js);
	  given().contentType(ContentType.JSON).accept(ContentType.JSON).body(js).when().post("https://reqres.in/api/login").then().log().all();
   }
}
