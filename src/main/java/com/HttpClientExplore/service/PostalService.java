package com.HttpClientExplore.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Service
public class PostalService {
    @Value("${endpoint}")
    private String endPoint;

    public String getPostalDetails() throws URISyntaxException, IOException, InterruptedException {
        String response =null;
        System.out.println("End Point is : "+endPoint);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(endPoint))
                .version(HttpClient.Version.HTTP_2)
                .timeout(Duration.of(10, ChronoUnit.SECONDS))
                .GET()
                .build();
        HttpClient client =HttpClient.newBuilder().build();
        HttpResponse<String> httpResponse = client.send(request,
                HttpResponse.BodyHandlers.ofString());
          response=  httpResponse.body();
        System.out.println(httpResponse.statusCode());
        return response;
    }



}
