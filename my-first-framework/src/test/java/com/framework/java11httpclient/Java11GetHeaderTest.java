package com.framework.java11httpclient;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.net.http.HttpClient.newBuilder;
import static org.junit.jupiter.api.Assertions.*;

public class Java11GetHeaderTest {

    private static final String BASE_URL = "https://api.github.com/";
    static HttpClient httpClient = newBuilder().build();
    static HttpResponse<Void> response;

    @BeforeAll
    static void sendGetToBaseEndpoint() throws IOException, InterruptedException {
        HttpRequest get = HttpRequest.newBuilder(URI.create(BASE_URL))
                .setHeader("User-Agent", "Java 11 Http bot")
                .build();
        response = httpClient.send(get, HttpResponse.BodyHandlers.discarding());
    }

    @Test
    void getReturns200() throws IOException, InterruptedException {
        int actualCode = response.statusCode();
        assertEquals(200, actualCode);
    }

    @ParameterizedTest
    @CsvSource({
            "X-RateLimit-Limit,60",
            "content-type,application/json; charset=utf-8",
            "server,GitHub.com",
            "x-frame-options,deny"
    })
    void parametrizedTestForHeaders(String header, String expectedValue) throws IOException, InterruptedException {
        String contentType = response.headers().firstValue(header).get();
        assertEquals(expectedValue, contentType);
    }

//    @Test
//    void contentTypeIsJson() throws IOException, InterruptedException {
//        HttpClient httpClient = HttpClient.newBuilder().build();
//        HttpRequest get = HttpRequest.newBuilder(URI.create(BASE_URL))
//                .setHeader("User-Agent", "Java 11 Http bot")
//                .build();
//
//        HttpResponse<Void> response = httpClient.send(get, HttpResponse.BodyHandlers.discarding());
//        String contentType = response.headers().firstValue("content-type").get();
//
//        Assertions.assertEquals("application/json; charset=utf-8", contentType);
//    }
//
//    @Test
//    void xRateLimitIsPresent() throws IOException, InterruptedException {
//        HttpClient httpClient = HttpClient.newBuilder().build();
//        HttpRequest get = HttpRequest.newBuilder(URI.create(BASE_URL))
//                .setHeader("User-Agent", "Java 11 Http bot")
//                .build();
//
//        HttpResponse<Void> response = httpClient.send(get, HttpResponse.BodyHandlers.discarding());
//        String xRateLimit = response.headers().firstValue("X-RateLimit-Limit").get();
//
//        Assertions.assertEquals(60, Integer.parseInt(xRateLimit));
//    }


}
