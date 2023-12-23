package org.example;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class XmlGenerateDomTest {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException {

        String file = "C:\\Users\\tahir\\OneDrive\\Masaüstü\\projeler\\XML\\exam2.xml";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newNSInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element exam = document.createElement("exam");
        document .appendChild(exam);

        Attr id = document.createAttribute("id");
        id.setValue("geometry-3");
        exam.setAttributeNode(id);

        Element title = document.createElement("title");
        exam.appendChild(title);
        Text text = document.createTextNode("Geometry 3 Sinavi");
        title.appendChild(text);

        TransformerFactory transFactory = TransformerFactory.newInstance();
        Transformer transformer = transFactory.newTransformer();

        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(file);
        transformer.transform(source,result);
    }
}
