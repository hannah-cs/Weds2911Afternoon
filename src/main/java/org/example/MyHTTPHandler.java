package org.example;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

class MyHTTPHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        System.out.printf("Accepted %s request%n", exchange.getRequestMethod());

        if (exchange.getRequestMethod().equals("GET")) {
            handleGetRequest(exchange);
        } else if (exchange.getRequestMethod().equals("POST")) {
            handlePostRequest(exchange);
        }
    }

    public Headers handleGetRequest(HttpExchange exchange) throws IOException {
        Headers headers = exchange.getResponseHeaders();
        String response = "Hello, " + exchange.getRequestURI().toString().split("=")[1];
        exchange.sendResponseHeaders(200, response.getBytes().length);
        exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
        try (OutputStream stream = exchange.getResponseBody()) {
            stream.write(response.getBytes());
        }
        return headers;
    }

    public Headers handlePostRequest(HttpExchange exchange) throws IOException {
        Headers headers = exchange.getResponseHeaders();
        String response = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(exchange.getRequestBody()))) {
            while (reader.ready()) {
                response += reader.readLine();
            }
        }
        response = "Hello, " + response.split(":")[1].replaceAll("[^a-zA-Z]", "");
        System.out.println("Content type: " + exchange.getRequestHeaders().get("Content-type"));
        exchange.sendResponseHeaders(200, response.length());
        try (OutputStream stream = exchange.getResponseBody()) {
            stream.write(response.getBytes());
        }
        return headers;
    }

}

