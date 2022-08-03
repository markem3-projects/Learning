package com.framework.java11httpclient;

import com.testframework.entities.User;
import com.testframework.handlers.JsonBodyHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.net.http.HttpClient.newBuilder;
import static org.junit.jupiter.api.Assertions.*;

public class Java11GetBodyTest {

    private static final String BASE_URL = "https://api.github.com/";

    @Test
    void bodyContainsCurrentUserUrl() throws IOException, InterruptedException {
        HttpClient httpClient = newBuilder().build();

        HttpRequest get = HttpRequest.newBuilder(URI.create(BASE_URL + "users/andrejs-ps"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot")
                .build();

        HttpResponse<User> response = httpClient.send(get, JsonBodyHandler.jsonBodyHandler(User.class));
        String actualLogin = response.body().getLogin();

        assertEquals("andrejs-ps", actualLogin);
    }
}
