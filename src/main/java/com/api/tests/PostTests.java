package com.api.tests;

import com.api.utils.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostTests extends BaseTest {

    @Test
    public void testPostEndpoint() {
        String requestBody = "{ \"name\": \"mahesh\", \"job\": \"QA-leader\" }";

        Response response = getRequestSpecification()
                .body(requestBody)
                .post("/api/users");

        Assert.assertEquals(response.getStatusCode(), 201, "Status code mismatch!");
        Assert.assertTrue(response.getBody().asString().contains("id"), "Response body does not contain expected value!");
    
        //below is optional
        String name = response.jsonPath().getString("name");
        String job = response.jsonPath().getString("job");
        String id = response.jsonPath().getString("id");
        String createdAt = response.jsonPath().getString("createdAt");

        // Validate the extracted values
        Assert.assertEquals(name, "mahesh", "Name value mismatch!");
        Assert.assertEquals(job, "QA-leader", "Job value mismatch!");
        Assert.assertNotNull(id, "ID is missing in response!");
        Assert.assertNotNull(createdAt, "CreatedAt is missing in response!");
    }
}
