package org.example.test;

import org.example.entity.Product;
import org.example.manager.ProductManager;

import java.sql.SQLException;

public class ProductUpdateTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ProductManager manager = new ProductManager();
        Product product = new Product(24,"Xiaomi",3500);
        boolean updated = manager.update(product);
        System.out.println("Guncellendi mi? " + updated);

   
    }

}
