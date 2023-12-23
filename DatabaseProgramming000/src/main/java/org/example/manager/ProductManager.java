package org.example.manager;

import org.example.entity.Product;
import org.example.library.database.DatabaseUtilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    public boolean insert(Product product) throws ClassNotFoundException, SQLException {
        Connection connection = DatabaseUtilities.getConnection();

        String sql = "insert into Product(product_name,sales_price) values(?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1,product.getProduct_name());
        statement.setDouble(2,product.getSales_price());
        int affected = statement.executeUpdate();


        connection.close();
        return affected==1?true:false;
    }
    public boolean update (Product product) throws ClassNotFoundException, SQLException {
        Connection connection = DatabaseUtilities.getConnection();

        String sql = "update Product set product_name =?, sales_price=? where product_id=?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1,product.getProduct_name());
        statement.setDouble(2,product.getSales_price());
        statement.setLong(3,product.getProduct_id());
        int affected = statement.executeUpdate();


        connection.close();
        return affected==1?true:false;
    }

    public void delete(long product_id) throws ClassNotFoundException, SQLException {

        Connection connection = DatabaseUtilities.getConnection();

        String sql = "delete from Product where product_id=?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setLong(1, product_id);

        int affected = statement.executeUpdate();
        System.out.println("Etkilenen satir sayisi : " + affected);


        connection.close();
    }

    public Product find(long product_id) throws SQLException, ClassNotFoundException {

        Product product = null;
        Connection connection = DatabaseUtilities.getConnection();

        String sql = "select * from Product where product_id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1,product_id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
             product = new Product();
            product.setProduct_id(resultSet.getLong("product_id"));
             product.setProduct_name(resultSet.getString("product_name"));
            product.setSales_price(resultSet.getDouble("sales_price"));
        }



        connection.close();
        return product;
    }
    public List<Product> list() throws SQLException, ClassNotFoundException {
       List<Product> productList = new ArrayList<Product>();
      

        Connection connection = DatabaseUtilities.getConnection();
        String sql = "select * from Product";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Product product = new Product();
            product.setProduct_id(resultSet.getLong("product_id"));
            product.setProduct_name(resultSet.getString("product_name"));
            product.setSales_price(resultSet.getDouble("sales_price"));
            productList.add(product);
        }

        connection.close();
        
       return  productList;


    }

    public List<Product> listBySalesPriceGreater(double salesPrice) throws SQLException, ClassNotFoundException {
        List<Product> productList = new ArrayList<Product>();


        Connection connection = DatabaseUtilities.getConnection();
        String sql = "select * from Product where sales_price>?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setDouble(1,salesPrice);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Product product = new Product();
            product.setProduct_id(resultSet.getLong("product_id"));
            product.setProduct_name(resultSet.getString("product_name"));
            product.setSales_price(resultSet.getDouble("sales_price"));
            productList.add(product);
        }

        connection.close();

        return  productList;


    }
    public List<Product> listByProductNameLike(String productNamePattern) throws SQLException, ClassNotFoundException {
        List<Product> productList = new ArrayList<Product>();


        Connection connection = DatabaseUtilities.getConnection();
        String sql = "select * from Product where product_name like?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,productNamePattern);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Product product = new Product();
            product.setProduct_id(resultSet.getLong("product_id"));
            product.setProduct_name(resultSet.getString("product_name"));
            product.setSales_price(resultSet.getDouble("sales_price"));
            productList.add(product);
        }

        connection.close();

        return  productList;


    }
    public List<Product> listFilter(String productNamePattern, double salesPrice) throws SQLException, ClassNotFoundException {
        List<Product> productList = new ArrayList<Product>();


        Connection connection = DatabaseUtilities.getConnection();
        String sql = "select * from Product where product_name like? or sales_price>?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,productNamePattern);
        statement.setDouble(2,salesPrice);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Product product = new Product();
            product.setProduct_id(resultSet.getLong("product_id"));
            product.setProduct_name(resultSet.getString("product_name"));
            product.setSales_price(resultSet.getDouble("sales_price"));
            productList.add(product);
        }

        connection.close();

        return  productList;


    }
}
