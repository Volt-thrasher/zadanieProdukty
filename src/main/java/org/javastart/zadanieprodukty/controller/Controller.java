package org.javastart.zadanieprodukty.controller;

import org.javastart.zadanieprodukty.model.Product;
import org.javastart.zadanieprodukty.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@org.springframework.stereotype.Controller
public class Controller {
    public ProductRepository repository;

    @Autowired
    public Controller(ProductRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/home")
    public String addProduct(Product product) {
        repository.add(product);
        return "success";
    }

    @GetMapping("/home")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("products", repository.getAll());
        return "products";

    }

    @GetMapping("/list")
    public String showProductList(Model model) {
        model.addAttribute("products", repository.getAll());
        double sum = 0;
        for (Product product : repository.getAll()) {
            sum += product.getPrice();
        }
        repository.getSum().setPrice(sum - repository.getSum().getPrice());
        return "list";
    }

    @GetMapping("/array")
    public String showProductArray(Model model) {
        model.addAttribute("products", repository.getAll());
        double sum = 0;
        for (Product product : repository.getAll()) {
            sum += product.getPrice();
        }
        repository.getSum().setPrice(sum - repository.getSum().getPrice());
        return "array";
    }
}
