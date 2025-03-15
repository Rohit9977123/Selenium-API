package APITesting;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class DummyJSON {
	@Test
	public void Fetch_All_Recipes()
	{ 
		given().get("https://dummyjson.com/recipes")
		.then()
		.statusCode(200)
		.log()
		.all();
		
		
	}
	
	@Test
	public void Fetch_a_Single_Recipe()
	{ 
		given().get("https://dummyjson.com/recipes/1")
		.then()
		.statusCode(200)
		.log()
		.all();
		
		
	}
	
	@Test
	public void Search_Recipes_by_Name()
	{ 
		given().get(" https://dummyjson.com/recipes/search?q=chicken")
		.then()
		.statusCode(200)
		.log()
		.all();
		
		
	}
	
	@Test
	public void Add_a_New_Recipe()
	{ 
		 given()
	        .header("Content-Type", "application/json")
	   
	        .when().post("https://dummyjson.com/recipes/add")
	    .then().statusCode(200).log().all();
	
		
		
	}
   
	@Test
	public void Update_a_Recipe()
	{ 
		 given()
	        .header("Content-Type", "application/json")
	   
	        .when().put("https://dummyjson.com/recipes/50")
	    .then().statusCode(200).log().all();
	
		
		
	}
	
	@Test
	public void Delete()
	{ 
		given().get("https://dummyjson.com/recipes/49")
		.then()
		.statusCode(200)
		.log()
		.all();
		
		
	}
}
