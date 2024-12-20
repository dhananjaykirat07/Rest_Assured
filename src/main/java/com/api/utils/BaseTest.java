package com.api.utils;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseTest {

    // Base URL for all API requests
    protected static final String BASE_URL = "https://reqres.in";

    static {
        // Configure RestAssured to use the base URI globally
        RestAssured.baseURI = BASE_URL;
    }

    /**
     * Returns a pre-configured RequestSpecification for common headers
     */
    protected RequestSpecification getRequestSpecification() {
        return RestAssured.given()
                .header("Content-Type", "application/json"); // Set default headers
    }
}
