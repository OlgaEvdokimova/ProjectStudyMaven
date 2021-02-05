package freeIt.hw21xml.writing;

import freeIt.hw21xml.parsing.DOMParseImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class WritingUtil {
   static Logger logger = LoggerFactory.getLogger(WritingUtil.class.getName());

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
            logger.error(e.getMessage());
        }
    }

    private static void add(Document document) {
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

    public static void writeStax(String pathForWrite) {
        XMLOutputFactory outputFactory =  XMLOutputFactory.newInstance();
        try {
            XMLStreamWriter writer = outputFactory.createXMLStreamWriter(new FileWriter(pathForWrite));
            writer.writeStartDocument("UTF-8", "1.0");
            writer.writeStartElement("Flowers");

            writer.writeStartElement("flower");
            writer.writeAttribute("name", "Rosa");
            writer.writeAttribute("origin", "Belarus");

            writer.writeStartElement("soil");
            writer.writeCharacters("PODZOLIC");
            writer.writeEndElement();

            writer.writeStartElement("visualParameters");

            writer.writeStartElement("stemColor");
            writer.writeCharacters("Green");
            writer.writeEndElement();

            writer.writeStartElement("leavesColor");
            writer.writeCharacters("Red");
            writer.writeEndElement();

            writer.writeStartElement("size");
            writer.writeCharacters("2");
            writer.writeEndElement();

            writer.writeEndElement();

            writer.writeStartElement("growingTips");

            writer.writeStartElement("temp");
            writer.writeCharacters("20");
            writer.writeEndElement();

            writer.writeStartElement("lighting");
            writer.writeCharacters("Strong");
            writer.writeEndElement();

            writer.writeStartElement("watering");
            writer.writeCharacters("Often");
            writer.writeEndElement();

            writer.writeEndElement();

            writer.writeStartElement("multiplying");
            writer.writeCharacters("SEED");
            writer.writeEndElement();

            writer.writeEndElement();

            writer.writeEndElement();
            writer.writeEndDocument();
            writer.flush();
        } catch (XMLStreamException | IOException e) {
            logger.error(e.getMessage());
        }

    }
}
