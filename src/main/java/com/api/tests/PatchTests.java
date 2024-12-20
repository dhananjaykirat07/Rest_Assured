package com.api.tests;

import com.api.utils.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PatchTests extends BaseTest {

    @Test
    public void testPatchEndpoint() {
        // Request body with only the "name" field
        String requestBody = "{ \"name\": \"morpheus\" }";

        Response response = getRequestSpecification()
                .body(requestBody)
                .patch("/api/users/2");

        // Assertions
        Assert.assertEquals(response.getStatusCode(), 200, "Status code mismatch!");
        Assert.assertTrue(response.getBody().asString().contains("updatedAt"), "Response body does not contain 'updatedAt' field!");
        Assert.assertTrue(response.getBody().asString().contains("morpheus"), "Response body does not contain updated name!");
    }
}
