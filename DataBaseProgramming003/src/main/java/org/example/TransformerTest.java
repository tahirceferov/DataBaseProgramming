package org.example;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

public class TransformerTest {
    public static void main(String[] args){

        try {
            String xml = "C:\\Users\\tahir\\OneDrive\\Masaüstü\\projeler\\XML\\exam.xml";
            String xsl = "C:\\Users\\tahir\\OneDrive\\Masaüstü\\projeler\\XML\\exam.xsl";
            String html = "C:\\Users\\tahir\\OneDrive\\Masaüstü\\projeler\\XML\\exam.html";

            File xmlDosya = new File(xml);
            File xslDosya = new File(xsl);
            File htmlDosya = new File(html);

            URI uriXml = xmlDosya.toURI();
            URI uriXsl = xslDosya.toURI();
            URI uriHtml = htmlDosya.toURI();

            TransformerFactory factory = TransformerFactory.newInstance();
            Source style = new StreamSource(String.valueOf(uriXsl));
            Transformer transformer = factory.newTransformer(style);

            Source data = new StreamSource(String.valueOf(uriXml));
            Result output = new StreamResult(String.valueOf(uriHtml));
            transformer.transform(data, output);
        }
        catch (TransformerException e){
            e.printStackTrace();
        }

    }
}
