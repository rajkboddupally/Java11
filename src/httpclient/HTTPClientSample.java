package httpclient;

/* Raj Kumar Boddupally created on 2/15/2021 inside the package - httpclient */

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class HTTPClientSample {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1).connectTimeout(Duration.ofSeconds(20)).build();
        HttpRequest httpRequest = HttpRequest.newBuilder().GET().uri(URI.create("https://httpbin.org/get")).setHeader("User-Agent", "Java 11 HttpClient Bot").build();
        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        HttpHeaders httpHeaders = response.headers();
        httpHeaders.map().forEach((k, v) -> System.out.println(k + " " + v));

        System.out.println(response.statusCode());
        System.out.println(response.body());

    }
}
