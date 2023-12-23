package org.example.entity;

public class Product {
    private long product_id;
    private String product_name;
    private double sales_price;

    public Product(long product_id, String product_name, double sales_price) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.sales_price = sales_price;
    }

    public Product() {
    }

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getSales_price() {
        return sales_price;
    }

    public void setSales_price(double sales_price) {
        this.sales_price = sales_price;
    }
}
