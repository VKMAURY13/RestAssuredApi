package api.endpoints;

import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import api.payload.UserPayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class UserEndPoints2 {
	
	//method for creating getting URL from properties file
	
	static ResourceBundle getURL()
	{
		ResourceBundle routes = ResourceBundle.getBundle("Routes");
		return routes;
	}
	
	/*
	 * This method is used to create new user
	 */
	
	public static Response createUser(UserPayload payload)
	{
		String user_post_url = getURL().getString("user_post_url");
		
		Response response = given()
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .body(payload)
		.when()
		   .post(user_post_url);
		
		return response;
		
	}
	
	
   /*
    * This method is used to Read user
    * 
    */
	
	public static Response readUser(int id)
	{
		String user_get_url = getURL().getString("user_get_url");
		Response response = given()
		   .pathParam("id", id)
		   
		.when()
		   .get(user_get_url);
		
		return response;
		
	}
	
	/*
	 * This method is used to update user
	 */
	
	public static Response updateUser(int id, UserPayload payload)
	{
		String user_update_url = getURL().getString("user_update_url");
		
		Response response = given()
				   .contentType(ContentType.JSON)
				   .accept(ContentType.JSON)
				   .body(payload)
		           .pathParam("id", id)
		   
		.when()
		   .put(user_update_url);
		
		return response;
		
	}
	
	/*
	 * This method is used to delete user
	 */
	
	public static Response deleteUser(int id)
	{
		String user_delete_url = getURL().getString("user_delete_url");
		
		Response response = given()
		   .pathParam("id", id)
		   
		.when()
		   .delete(user_delete_url);
		
		return response;
		
	}
	
}
