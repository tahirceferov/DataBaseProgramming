package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class UrlConnectionTest {
    public static void main(String[] args) throws IOException {
        String address = "http://godoro.com";
        URL url = new URL(address);
        URLConnection connection = url.openConnection();
        InputStream in = connection.getInputStream();
        InputStreamReader ins = new InputStreamReader(in);
        BufferedReader reader = new BufferedReader(ins);

        String line;
        StringBuilder builder = new StringBuilder();
        while((line=reader.readLine())!=null){
            builder.append(line).append("\r\n");
        }
         String content = builder.toString();
        System.out.println(content);

    }
}
