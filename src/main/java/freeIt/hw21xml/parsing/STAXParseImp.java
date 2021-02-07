package freeIt.hw21xml.parsing;

import freeIt.hw21xml.greenHouse.*;
import freeIt.hw21xml.writing.WritingUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class STAXParseImp implements ParsingIntoObject {
    Logger logger = LoggerFactory.getLogger(STAXParseImp.class.getName());

    @Override
    public List<Flower> parseIntoObject(String PATH) {
        String name = "", origin = "", soil = "", stemColor = "", leavesColor= "", temp = "", lighting = "", watering = "", multiplying ="";
        Double size = 0.0;

        //List<Flower> flowersList = new ArrayList<>();
        Flowers flowersList = new Flowers();
        try {
            XMLInputFactory xmlf = XMLInputFactory.newInstance();
            XMLEventReader reader = xmlf.createXMLEventReader(new FileInputStream(PATH));
            while (reader.hasNext()) {

                XMLEvent nextEvent = reader.nextEvent();
                if (nextEvent.isStartElement()) {

                    StartElement startElement = nextEvent.asStartElement();
                    switch (startElement.getName().getLocalPart()) {
                        case "flower":
                            //Flower flower = new Flower();
                            Iterator<Attribute> iterator = startElement.getAttributes();
                            while (iterator.hasNext()) {
                                Attribute attribute = iterator.next();
                                QName nameAtr = attribute.getName();
                                String value = attribute.getValue();
                                if (nameAtr.toString().equals("name")) {
                                    name= value;
                                }
                                if (nameAtr.toString().equals("origin")) {
                                    origin=value;
                                }
                            }
                            break;
                        case "soil":
                            nextEvent = reader.nextEvent();
                            soil = nextEvent.asCharacters().getData();
                            break;
                        case "stemColor":
                            nextEvent = reader.nextEvent();
                             stemColor = nextEvent.asCharacters().getData();
                            break;
                        case "leavesColor":
                            nextEvent = reader.nextEvent();
                             leavesColor = nextEvent.asCharacters().getData();
                            break;
                        case "size":
                            nextEvent = reader.nextEvent();
                             size = Double.valueOf(nextEvent.asCharacters().getData());
                            break;
                        case "temp":
                            nextEvent = reader.nextEvent();
                             temp = nextEvent.asCharacters().getData();
                            break;
                        case "lighting":
                            nextEvent = reader.nextEvent();
                             lighting = nextEvent.asCharacters().getData();
                            break;
                        case "watering":
                            nextEvent = reader.nextEvent();
                             watering = nextEvent.asCharacters().getData();
                            break;
                        case "multiplying":
                            nextEvent = reader.nextEvent();
                            multiplying = nextEvent.asCharacters().getData();
                            break;
                    }

                }

                if(nextEvent.isEndElement()){

                    EndElement endElement = nextEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("flower")){
                        Flower flower = new Flower();
                        flower.setName(name);
                        flower.setOrigin(origin);
                        flower.setSoil(Enums.Soil.valueOf(soil));
                        flower.setVisualParameters(new VisualParameters(stemColor, leavesColor, size));
                        flower.setGrowingTips(new GrowingTips(temp, lighting, watering));
                        flower.setMultiplying(Enums.Multiplying.valueOf(multiplying));
                        flowersList.getList().add(flower);
                    }
                }

            }
        } catch (XMLStreamException | FileNotFoundException e) {
            logger.error(e.getMessage());
        }
        return flowersList.getList();
    }
}
