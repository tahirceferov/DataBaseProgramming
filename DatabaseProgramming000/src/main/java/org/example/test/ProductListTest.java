package org.example.test;

import org.example.entity.Product;
import org.example.manager.ProductManager;

import java.sql.SQLException;
import java.util.List;

public class ProductListTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ProductManager manager = new ProductManager();
        List<Product> productList = manager.list();
        for(Product product : productList){
            System.out.printf("%10d %-20s %10.2f \r\n",product.getProduct_id()
                    ,product.getProduct_name()
                    ,product.getSales_price());
        }
    }
}
