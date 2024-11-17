package org.core.http.httpclient;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

public class HttpClientTest {

    @Test
    public void get1() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(5)).build();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://httpbin.org/ip"))
                .timeout(Duration.ofSeconds(5))
                .GET()
                .build();

        HttpResponse<String> httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));

        String body = httpResponse.body();

        System.out.println(body);
    }

    @Test
    public void get2() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(5)).build();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://httpbin.org/get?show_env=1"))
                .timeout(Duration.ofSeconds(5))
                .GET()
                .build();

        HttpResponse<String> httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));

        String body = httpResponse.body();

        System.out.println(body);
    }

    @Test
    public void post1() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(5)).build();

        HttpRequest.BodyPublisher publisher = HttpRequest.BodyPublishers.ofString("{\"id\": 999,\"value\": \"content\"}");

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://httpbin.org/post")).timeout(Duration.ofSeconds(5)).POST(publisher).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));

        String body = response.body();
        HttpHeaders headers = response.headers();

        System.out.println(body);
        System.out.println(headers);
    }

    @Test
    public void post2() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(5)).build();

        HttpRequest.BodyPublisher publisher = HttpRequest.BodyPublishers.ofString("{\"id\": 999,\"value\": \"content\"}");

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://httpbin.org/post")).timeout(Duration.ofSeconds(5)).POST(publisher).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));

        String body = response.body();
        HttpHeaders headers = response.headers();

        System.out.println(body);
        System.out.println(headers);
    }
}
