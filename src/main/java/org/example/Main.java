package org.example;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) {
        int serverPort = 8000;
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(serverPort), 0);
            server.createContext("/api/user", new MyHTTPHandler());
            server.setExecutor(null);
            server.start();

        Product product = new Product(1, "Product one", 29.99, "Cat1", 150);
        Product product2 = new Product(2, "Product two", 56.50, "Cat2", 75);

        Thread.sleep(600000000);

        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}