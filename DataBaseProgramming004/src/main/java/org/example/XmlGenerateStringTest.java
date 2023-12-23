package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class XmlGenerateStringTest {
    public static void main(String[] args) throws IOException {
        String file = "C:\\Users\\tahir\\OneDrive\\Masaüstü\\projeler\\XML\\exam3.xml";
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        bw.write("<exam id'\"chemistry-3\">");
        bw.write("<title> Kimya 3 Sinavi</title>");
        bw.write("</exam>");
        bw.close();
    }
}
