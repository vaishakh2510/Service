package com.example.CustomerService;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    ProductService pservice;

    @GetMapping("/getProducts")
    public List<Product> getProducts() {
        try {
            return pservice.getProducts();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); // Handle exceptions properly
            return null; // Or return an error response
        }
    }
}