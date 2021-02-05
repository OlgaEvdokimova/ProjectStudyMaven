package freeIt.hw21xml.parsing;

import freeIt.hw21xml.greenHouse.Enums;
import freeIt.hw21xml.greenHouse.Flower;

import freeIt.hw21xml.greenHouse.GrowingTips;
import freeIt.hw21xml.greenHouse.VisualParameters;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SAXParseImp implements Parsing {
    Flower flower;


    @Override
    public List<String> parseIntoText(String PATH) {
        return new ArrayList<>();
    }

    @Override
    public List<Flower> parseInto(String PATH) {
        List<Flower> flowersList = new ArrayList<>();
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {

                String tag = "";
                String name, origin, stemColor, leavesColor, temp, lighting, watering, soil, multiplying;
                Double size;
                boolean flag  = false;

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("flower")) {
                        name = attributes.getValue("name");
                        origin = attributes.getValue("origin");
//                        flower.setName(name);
//                        flower.setOrigin(origin);
                        flag = true;
                    }
                    tag = qName;
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    String information = new String(ch, start, length);
                    information = information.replace("\n", "").trim();
                    if (true) {
                        if (!information.isEmpty()) {

                            if (tag.equalsIgnoreCase("soil"))
                                //flower.setSoil(Enums.Soil.valueOf(information));
                                soil = information;

                            if (tag.equalsIgnoreCase("stemColor"))
                                stemColor = information;

                            if (tag.equalsIgnoreCase("leavesColor"))
                                leavesColor = information;

                            if (tag.equalsIgnoreCase("size"))
                                size = Double.valueOf(information);

                            if (tag.equalsIgnoreCase("temp"))
                                temp = information;

                            if (tag.equalsIgnoreCase("lighting"))
                                lighting = information;

                            if (tag.equalsIgnoreCase("watering"))
                                watering = information;

                            if (tag.equalsIgnoreCase("multiplying")) {
                                // flower.setMultiplying(Enums.Multiplying.valueOf(information));
                                multiplying = information;
                            }
                        }
                    }
                }
                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    if (qName.equalsIgnoreCase("flower"))
                    if ((stemColor != null && !stemColor.isEmpty()) && (leavesColor != null && !leavesColor.isEmpty()) &&
                            (size != null && size != 0) && (temp != null && !temp.isEmpty()) && (lighting != null && !lighting.isEmpty()) &&
                            (watering != null && !watering.isEmpty())) {
                        flower = new Flower(name, origin, Enums.Soil.valueOf(soil), new VisualParameters(stemColor, leavesColor, size),
                                new GrowingTips(temp, lighting, watering), Enums.Multiplying.valueOf(multiplying));
                        flowersList.add(flower);
                        flag = false;
                    }
                    tag = "";
                }
            };

            saxParser.parse(PATH, handler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.getCause();
        }
        return flowersList;
    }
}