package org.example.test;

import org.example.entity.Product;
import org.example.manager.ProductManager;

import java.sql.SQLException;

public class ProductDeleteTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ProductManager manager = new ProductManager();
        long product_id = 23;
        Product product = manager.find(product_id);
        if(product!=null){
            manager.delete(product_id);
        }
        else{
            System.out.println("urun bulunamadi " + product_id);
        }
    }


}
