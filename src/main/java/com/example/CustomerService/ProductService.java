package com.example.CustomerService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

	public List<Product> getProducts() throws SQLException, ClassNotFoundException {
       
		List<Product> productList = new ArrayList<>();

        // Load the MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish connection
        String url = "jdbc:mysql://localhost:3306/bankingapp";
        try (Connection con = DriverManager.getConnection(url, "root", "");
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM products")) {

            // Iterate through the ResultSet
        	while (rs.next()) {
                // Create a Product object for each row in the ResultSet
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("pname"));
                product.setDescription(rs.getString("pdes"));
                // Add the product to the list
                productList.add(product);
            }
        } // Connection, statement, and result set will be automatically closed

        return productList;
    }
	}

