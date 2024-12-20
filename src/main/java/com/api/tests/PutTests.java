package com.api.tests;

import com.api.utils.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PutTests extends BaseTest {

    @Test
    public void testPutEndpoint() {
        String requestBody = "{ \"name\": \"morpheus\", \"job\": \"zion resident\" }";

        Response response = getRequestSpecification()
                .body(requestBody)
                .put("/api/users/2");

        Assert.assertEquals(response.getStatusCode(), 200, "Status code mismatch!");
        Assert.assertTrue(response.getBody().asString().contains("updatedAt"), "Response body does not contain expected field!");
    }
}
