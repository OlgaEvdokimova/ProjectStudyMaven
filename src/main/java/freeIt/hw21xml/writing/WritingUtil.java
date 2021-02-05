package freeIt.hw21xml.writing;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;

public class WritingUtil {
    public static void writeDOM(String pathForWrite) {
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse("src/main/java/freeIt/hw21xml/resources/flower.xml");
            add(document);
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource domSource = new DOMSource(document);
            FileOutputStream fos = new FileOutputStream(pathForWrite);
            StreamResult streamResult = new StreamResult(fos);
            transformer.transform(domSource, streamResult);

        } catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
            e.printStackTrace();
        }
    }

    public static void add(Document document) {
        Node root = document.getDocumentElement();
        Element flower = document.createElement("flower");
        flower.setAttribute("name", "rosa");
        flower.setAttribute("origin", "Russia");
        Element soil = document.createElement("soil");
        soil.setTextContent("PODZOLIC");
        flower.appendChild(soil);
        Element visualParameters = document.createElement("visualParameters");
        Element stemColor = document.createElement("stemColor");
        stemColor.setTextContent("Green");
        visualParameters.appendChild(stemColor);
        Element leavesColor = document.createElement("leavesColor");
        leavesColor.setTextContent("Red");
        visualParameters.appendChild(leavesColor);
        Element size = document.createElement("size");
        size.setTextContent("2");
        visualParameters.appendChild(size);
        flower.appendChild(visualParameters);
        Element growingTips = document.createElement("growingTips");
        Element temp = document.createElement("temp");
        temp.setTextContent("20");
        growingTips.appendChild(temp);
        Element lighting = document.createElement("lighting");
        lighting.setTextContent("Strong");
        growingTips.appendChild(lighting);
        Element watering = document.createElement("watering");
        watering.setTextContent("Often");
        growingTips.appendChild(watering);
        flower.appendChild(growingTips);
        Element multiplying = document.createElement("multiplying");
        multiplying.setTextContent("SEED");
        flower.appendChild(multiplying);
        root.appendChild(flower);
    }
}
