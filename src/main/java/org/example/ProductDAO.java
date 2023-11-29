package org.example;

import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private static List<Product> products = new ArrayList<>();
    public static List<Product> getAllProducts() {
        return products;
    }

    public static Product getProductById(int id) {
        return products.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public static void addProduct(Product product) {
        products.add(product);
    }

    public static void updateProduct(Product updatedProduct) {
        int index = -1;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == updatedProduct.getId()) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            products.set(index, updatedProduct);
        }
    }

    public static void deleteProduct(int id) {
        products.removeIf(product -> product.getId() == id);
    }
}
