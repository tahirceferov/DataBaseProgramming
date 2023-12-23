package org.example.test;

import org.example.entity.Product;
import org.example.manager.ProductManager;

import java.sql.SQLException;

public class ProductInsertTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
     Product product = new Product(0,"Iphone",3500);
     ProductManager manager = new ProductManager();
     manager.insert(product);
    

    }
}
