package org.example.test;

import org.example.entity.Product;
import org.example.manager.ProductManager;

import java.sql.SQLException;

public class ProductFindTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ProductManager manager = new ProductManager();
        long product_id = 28;
        Product product = manager.find(product_id);
        if(product!=null){
            System.out.println(product.getProduct_id()
                    + " " + product.getProduct_name()
                    + " " + product.getSales_price());
        }
        else{
            System.out.println("urun bulunamadi " + product_id);
        }

    }
}
