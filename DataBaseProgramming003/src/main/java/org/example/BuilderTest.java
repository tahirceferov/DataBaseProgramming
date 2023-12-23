package org.example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class BuilderTest {

    static Document parse(String uri) throws ParserConfigurationException, IOException, SAXException, URISyntaxException{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(uri.toString());
        return document;
    }
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, URISyntaxException {
        String filePath = "C:\\Users\\tahir\\OneDrive\\Masaüstü\\projeler\\XML\\exam.xml";
        URI uri = new URI("file:///" + filePath.replace("\\", "/"));

        Document document = BuilderTest.parse(uri.toString());

        System.out.println("Belge " + document);

        Element exam = document.getDocumentElement();
        String id = exam.getAttribute("id");
        System.out.println("kimlik: " + id);

        String title = exam.getElementsByTagName("title").item(0).getTextContent();
        System.out.println("Baslik: " + title);

        NodeList questionList = exam.getElementsByTagName("question");
        for (int i = 0; i < questionList.getLength(); i++) {
            Element question = (Element) questionList.item(i);
            String number = question.getAttribute("number");
            System.out.println("No: " + number);

            String body = question.getElementsByTagName("body").item(0).getTextContent();
            System.out.println("Baslik: " + body);
        }
        NodeList optionList = exam.getElementsByTagName("option");

        for(int j=0; j< optionList.getLength();j++){
            Element option = (Element)optionList.item(j);
            String code = option.getAttribute("code");
            System.out.println("kod: " + code);
            String content = option.getTextContent();
            System.out.println("icerik: " + content);


            

        }
    }
}
