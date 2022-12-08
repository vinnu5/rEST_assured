package rESTassured;
import io.restassured.*;
import static io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class restAssured {
   public String url = "https://reqres.in/api/users?page=2" ;
   @Test(enabled = false)
   public void t1(){
	   Response rep = RestAssured.get(url) ;
	   int actual = rep.statusCode();
	   Assert.assertEquals(actual, 200);
	   
	   }
   @Test()
   public void t2(){
	   given().get(url).then().statusCode(200).log().all();
	   given().get(url).then().statusCode(200).body("data.id",hasItems(8));
   }
}
