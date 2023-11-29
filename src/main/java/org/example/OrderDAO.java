package org.example;

import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    private static List<Order> orders = new ArrayList<>();
    public static List<Order> getAllOrders() {
        return orders;
    }

    public static Order getOrderById(int id) {
        return orders.stream()
                .filter(order -> order.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public static void addOrder(Order order) {
        orders.add(order);
    }

    public static void deleteOrder(int id) {
        orders.removeIf(order -> order.getId() == id);
    }
}
