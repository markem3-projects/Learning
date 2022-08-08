package com.framework.restassured;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class BasicRestAssuredApiTest {

    @Test
    public void getStatusCodeIs200() {
        RestAssured.get("https://api.github.com")
                .then()
                .statusCode(200);
    }

    @Test
    public void headersContainCorrectValues() {
        RestAssured.get("https://api.github.com")
                .then()
                .assertThat()
                .header("content-type", "application/json; charset=utf-8")
                .header("X-RateLimit-Limit", "60");
    }

    @Test
    public void bodyContainsCorrectValues() {
        RestAssured.get("https://api.github.com/users/andrejs-ps")
                .then()
                .assertThat()
                .body("login", equalTo("andrejs-ps"))
                .body("type", equalTo("User"));
    }
}
