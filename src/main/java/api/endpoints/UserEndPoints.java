package api.endpoints;

import static io.restassured.RestAssured.*;

import api.payload.UserPayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class UserEndPoints {
	
	/*
	 * This method is used to create new user
	 */
	
	public static Response createUser(UserPayload payload)
	{
		
		Response response = given()
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .body(payload)
		.when()
		   .post(Routes.user_post_url);
		
		return response;
		
	}
	
	
   /*
    * This method is used to Read user
    * 
    */
	
	public static Response readUser(int id)
	{
		
		Response response = given()
		   .pathParam("id", id)
		   
		.when()
		   .get(Routes.user_get_url);
		
		return response;
		
	}
	
	/*
	 * This method is used to update user
	 */
	
	public static Response updateUser(int id, UserPayload payload)
	{
		
		Response response = given()
				   .contentType(ContentType.JSON)
				   .accept(ContentType.JSON)
				   .body(payload)
		           .pathParam("id", id)
		   
		.when()
		   .put(Routes.user_update_url);
		
		return response;
		
	}
	
	/*
	 * This method is used to delete user
	 */
	
	public static Response deleteUser(int id)
	{
		
		Response response = given()
		   .pathParam("id", id)
		   
		.when()
		   .delete(Routes.user_delete_url);
		
		return response;
		
	}
	
}
