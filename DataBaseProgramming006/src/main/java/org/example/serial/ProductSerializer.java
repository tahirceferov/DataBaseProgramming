package org.example.serial;

import java.io.*;

public class ProductSerializer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String path = "C:\\Users\\tahir\\OneDrive\\Masaüstü\\project\\XML\\product.ser";
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Product product = (Product)ois.readObject();
        ois.close();

        System.out.println(" Urun no: " + product.getProductId() +"\n"+ " Urun adi: " + product.getProductName() +"\n"+
                " Urun fiyati: " + product.getSalesPrice());
    }
}
