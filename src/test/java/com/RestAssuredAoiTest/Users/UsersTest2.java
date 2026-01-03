package com.RestAssuredAoiTest.Users;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.endpoints.UserEndPoints2;
import api.payload.UserPayload;
import io.restassured.response.Response;

public class UsersTest2 {
	
	Faker faker;
	UserPayload userdata;
	
	public Logger logger;
	
	@BeforeClass
	public void setData()
	{
		userdata = new UserPayload();
		faker = new Faker();
		
		userdata.setId(faker.idNumber().hashCode());
		userdata.setUsername(faker.name().username());
		userdata.setEmail(faker.internet().emailAddress());
		userdata.setPassword(faker.internet().password());
		
		//logs
		logger = LogManager.getLogger(this.getClass());
	
	}
	
	
	@Test(priority = 1)
	public void testAdd_A_New_User()
	{
		logger.info("*********** Creating User *************");
		Response resp = UserEndPoints2.createUser(userdata);
		resp.then().log().all();
		
		Assert.assertEquals(resp.getStatusCode(), 201);
		
		logger.info("*********** User is Created *************");
		
	}
	
	@Test(priority=2)
	public void testGet_A_Single_User()
	{
		logger.info("*********** Reading User Information *************");
	 Response resp = UserEndPoints2.readUser(this.userdata.getId());
	 resp.then().log().all();
	 Assert.assertEquals(resp.getStatusCode(), 200);
	 
	 logger.info("*********** User Information displayed *************");
	}
	
	
	@Test(priority=3)
	public void testUpdate_A_User()
	{
		logger.info("*********** Updating User  *************");
		userdata.setEmail(faker.internet().emailAddress());
		userdata.setPassword(faker.internet().password());
		
		Response response  = UserEndPoints2.updateUser(this.userdata.getId(), userdata);
		response.then().assertThat().statusCode(200);
		response.then().assertThat().time(Matchers.lessThan(3000L));
		
		//checking data after update
		Response respAfterUpdate = UserEndPoints2.readUser(this.userdata.getId());
		Assert.assertEquals(respAfterUpdate.getStatusCode(), 200);
		
		logger.info("*********** User Updated *************");
		
	}
	
	@Test(priority=4)
	public void testDelete_A_User()
	{
		logger.info("*********** Deleting User *************");
		Response response = UserEndPoints2.deleteUser(this.userdata.getId());
		response.then().statusCode(anyOf(is(200), is(204)));
		logger.info("*********** User Deleted *************");
		
	}


}
