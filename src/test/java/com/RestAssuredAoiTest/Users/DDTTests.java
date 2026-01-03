package com.RestAssuredAoiTest.Users;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.UserPayload;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTTests {
	
	@Test(priority=1, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void testPostUser(String id, String username, String email, String password)
	{
		UserPayload userpayload = new UserPayload();
		userpayload.setId(Integer.parseInt(id));
		userpayload.setUsername(username);
		userpayload.setEmail(email);
		userpayload.setPassword(password);
		
		Response response = UserEndPoints.createUser(userpayload);
		Assert.assertEquals(response.getStatusCode(), 201);
		
		
	}
	
	
	@Test(priority=2, dataProvider = "UserId", dataProviderClass = DataProviders.class)
	public void testGetUserByID(String id)
	{
		Response resp = UserEndPoints.readUser(Integer.parseInt(id));
		Assert.assertEquals(resp.getStatusCode(), 200);
	}
	
	
	
	
	
	@Test(priority = 3, dataProvider = "UserId", dataProviderClass = DataProviders.class)
	public void testDeleteUser(String id)
	{
		Response response = UserEndPoints.deleteUser(Integer.parseInt(id));
		
		Assert.assertEquals(response.getStatusCode(), 204);
		
	}
	
	
	 

}

