package org.example;

import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

public class Main {
    public static void main(String[] args) {
        Product product = new Product(1, "Product One", 25.99, "Cat1", 100);
        String BASE_URI = "http://localhost:8000/";
        ResourceConfig resourceConfig = new ResourceConfig(ProductResource.class);
        GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), resourceConfig);
        System.out.println("Server started at: " + BASE_URI);
    }
}