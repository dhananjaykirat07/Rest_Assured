package com.api.tests;

import com.api.utils.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HeadTests extends BaseTest {

    @Test
    public void testHeadEndpoint() {
        Response response = getRequestSpecification()
                .head("/api/users?page=2");

        Assert.assertEquals(response.getStatusCode(), 200, "Status code mismatch!");
        Assert.assertTrue(response.getHeaders().size() > 0, "Response headers are empty!");
    }
}
