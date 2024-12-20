package com.api.tests;

import com.api.utils.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetTests extends BaseTest {

    @Test
    public void testGetEndpoint() {
        Response response = getRequestSpecification()
                .get("/api/users?page=2");
        
        //System.out.println("Response Body: " + response.getBody().asString());
        // optional...only if u want to print on console
        
        Assert.assertEquals(response.getStatusCode(), 200, "Status code mismatch!");
        Assert.assertTrue(response.getBody().asString().contains("data"), "Response body does not contain expected field!");
    
    
    
    
    }
}
