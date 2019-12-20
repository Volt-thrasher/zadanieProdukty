package org.javastart.zadanieprodukty.repository;

import org.javastart.zadanieprodukty.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> products;

    public ProductRepository() {
        this.products = new ArrayList<>();
        Product suma = new Product("Razem", 0);
        products.add(suma);
    }

    public List<Product> add(Product product) {
        this.products.add(product);
        return products;
    }

    public List<Product> getAll() {
        return products;
    }

    public Product getSum() {
        return this.products.get(0);
    }
}
