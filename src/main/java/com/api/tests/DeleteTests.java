package com.api.tests;

import com.api.utils.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteTests extends BaseTest {

    @Test
    public void testDeleteEndpoint() {
        Response response = getRequestSpecification()
                .delete("/api/users/2");

        Assert.assertEquals(response.getStatusCode(), 204, "Status code mismatch!");
        Assert.assertTrue(response.getBody().asString().isEmpty(), "Response body is not empty!");
    }
}
