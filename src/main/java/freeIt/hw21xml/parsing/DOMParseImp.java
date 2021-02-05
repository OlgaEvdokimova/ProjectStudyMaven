package freeIt.hw21xml.parsing;

import freeIt.hw21xml.greenHouse.Enums;
import freeIt.hw21xml.greenHouse.Flower;
import freeIt.hw21xml.greenHouse.GrowingTips;
import freeIt.hw21xml.greenHouse.VisualParameters;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DOMParseImp implements ParsingIntoObject, ParsingIntoText {
    public DOMParseImp() {
    }

    @Override
    public List<Flower> parseIntoObject(String PATH) {
        String stemColor = "", leavesColor= "", temp = "", lighting = "", watering = "";
        Double size = 0.0;
        List<Flower> flowersList = new ArrayList<>();

        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(PATH);
            Node root = document.getDocumentElement();
            NodeList flowers = root.getChildNodes();
            for (int i = 0; i < flowers.getLength(); i++) {
                Flower flowerMain = new Flower();
                Node flower = flowers.item(i);

                if (flower.hasAttributes()) {
                    if (flower.getNodeType() != Node.TEXT_NODE) {
                        NamedNodeMap attributes = flower.getAttributes();
                        flowerMain.setName(attributes.item(0).getNodeValue());
                        flowerMain.setOrigin(attributes.item(1).getNodeValue());
                    }
                }
                if (flower.getNodeType() != Node.TEXT_NODE) {
                    NodeList flowerProps = flower.getChildNodes();

                    for (int j = 0; j < flowerProps.getLength(); j++) {
                        Node flowerProp = flowerProps.item(j);
                        if (flowerProp.getNodeType() != Node.TEXT_NODE) {

                            if (flowerProp.getChildNodes().getLength() > 1) {
                                NodeList flowerPropList = flowerProp.getChildNodes();

                                for (int k = 0; k < flowerPropList.getLength(); k++) {
                                    Node innerProp = flowerPropList.item(k);
                                    if (flowerProp.getNodeName().equalsIgnoreCase("visualParameters")) {
                                        if (flowerProp.getNodeType() != Node.TEXT_NODE) {
                                            if (innerProp.getNodeName().equalsIgnoreCase("stemColor")) {
                                                stemColor = innerProp.getTextContent();
                                            }
                                            if (innerProp.getNodeName().equalsIgnoreCase("leavesColor")) {
                                                leavesColor = innerProp.getTextContent();
                                            }
                                            if (innerProp.getNodeName().equalsIgnoreCase("size")) {
                                                size = Double.valueOf(innerProp.getTextContent());
                                            }
                                        }
                                    }

                                    if (flowerProp.getNodeName().equalsIgnoreCase("growingTips")) {
                                        if (flowerProp.getNodeType() != Node.TEXT_NODE) {
                                            if (innerProp.getNodeName().equalsIgnoreCase("temp")) {
                                                temp = innerProp.getTextContent();
                                            }
                                            if (innerProp.getNodeName().equalsIgnoreCase("lighting")) {
                                                lighting = innerProp.getTextContent();
                                            }
                                            if (innerProp.getNodeName().equalsIgnoreCase("watering")) {
                                                watering = innerProp.getTextContent();
                                            }
                                        }

                                    }
                                }
                                flowerMain.setVisualParameters(new VisualParameters(stemColor, leavesColor, size));
                                flowerMain.setGrowingTips(new GrowingTips(temp, lighting, watering));
                            } else if (flowerProp.getNodeName().equalsIgnoreCase("soil")) {
                                flowerMain.setSoil(Enums.Soil.valueOf(flowerProps.item(j).getTextContent()));
                            } else if (flowerProp.getNodeName().equalsIgnoreCase("multiplying")) {
                                flowerMain.setMultiplying(Enums.Multiplying.valueOf(flowerProps.item(j).getTextContent()));
                            }
                        }
                    }
                    flowersList.add(flowerMain);
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return flowersList;
    }





    @Override
    public List<String> parseIntoText(String PATH) {
        List<String> flowersList = new ArrayList<>();
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(PATH);
            Node root = document.getDocumentElement();
            NodeList flowers = root.getChildNodes();
            for (int i = 0; i < flowers.getLength(); i++) {
                Node flower = flowers.item(i);

                if (flower.hasAttributes()) {
                    if (flower.getNodeType() != Node.TEXT_NODE) {
                        NamedNodeMap attributes = flower.getAttributes();
                        for (int a = 0; a < attributes.getLength(); a++) {
                            Node attribute = attributes.item(a);
                            flowersList.add(attribute.getNodeName().concat(" ").concat(attribute.getNodeValue()));
                        }
                    }
                }
                if (flower.getNodeType() != Node.TEXT_NODE) {
                    NodeList flowerProps = flower.getChildNodes();
                    for (int j = 0; j < flowerProps.getLength(); j++) {
                        Node flowerProp = flowerProps.item(j);
                        if (flowerProp.getNodeType() != Node.TEXT_NODE) {
                            flowersList.add(flowerProp.getNodeName());
                            if (flowerProp.getChildNodes().getLength() > 1) {
                                NodeList flowerPropList = flowerProp.getChildNodes();
                                for (int k = 0; k < flowerPropList.getLength(); k++) {
                                    Node flowerPropListItem = flowerPropList.item(k);
                                    if (flowerPropListItem.getNodeType() != Node.TEXT_NODE) {

                                        flowersList.add("    " + flowerPropListItem.getNodeName() + "  " + flowerPropListItem.getTextContent());
                                    }
                                }
                            } else {

                                flowersList.add("    " + flowerProp.getChildNodes().item(0).getTextContent());
                            }
                        }
                    }
                    flowersList.add("\n");
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return flowersList;
    }
}