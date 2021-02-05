package freeIt.hw21xml;

import freeIt.hw21xml.greenHouse.Flower;
//import freeIt.hw21xml.parsing.DOMParseImp;
import freeIt.hw21xml.parsing.DOMParseImp;
import freeIt.hw21xml.parsing.ParsingIntoObject;
import freeIt.hw21xml.parsing.SAXParseImp;
import freeIt.hw21xml.parsing.STAXParseImp;
import freeIt.hw21xml.writing.WritingUtil;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static final String PATH = "src/main/java/freeIt/hw21xml/resources/flower.xml";
    public static final String PATH_WRITE_EXAMPLE_DOM = "src/main/java/freeIt/hw21xml/resources/writeExample.xml";

    public static void main(String[] args) {
        PropertyConfigurator.configure("src/main/java/freeIt/hw21xml/resources/log4jxml.properties");
        Logger logger = LoggerFactory.getLogger(Main.class.getName());

        DOMParseImp domParsing = new DOMParseImp();

        List<Flower> parseFlowersList = domParsing.parseIntoObject(PATH);
        for (Flower flower : parseFlowersList) {
            logger.info(flower.toString());
        }
        //Got this
        //Flower{name='Peony, origin='Japan, soil=GROUND, visualParameters=stemColor='Green', leavesColor='Pink', size=1.0}, growingTips=temp='15', lighting='Strong', watering='Regular'}, multiplying=CUTTING}
        //Flower{name='Hydrangea, origin='England, soil=PODZOLIC, visualParameters=stemColor='Green', leavesColor='Blue', size=0.5}, growingTips=temp='20', lighting='Strong', watering='Infrequent'}, multiplying=SEEDS}
        //Flower{name='Moss, origin='WildNature, soil=SOD_PODZOLIC, visualParameters=stemColor='Green', leavesColor='Green', size=0.1}, growingTips=temp='15', lighting='Week', watering='Occasional'}, multiplying=LEAVES}
        logger.info("\n");

        List<String> parseFlowersText = domParsing.parseIntoText(PATH);
        for (String node : parseFlowersText) {
            logger.info(node);
        }

        //got this

        //name Peony
        //origin Japan
        //soil
        //    GROUND
        //visualParameters
        //    stemColor  Green
        //    leavesColor  Pink
        //    size  1
        //growingTips
        //    temp  15
        //    lighting  Strong
        //    watering  Regular
        //multiplying
        //    CUTTING
        //
        //
        //name Hydrangea
        //origin England
        //soil
        //    PODZOLIC
        //visualParameters
        //    stemColor  Green
        //    leavesColor  Blue
        //    size  0.5
        //growingTips
        //    temp  20
        //    lighting  Strong
        //    watering  Infrequent
        //multiplying
        //    SEEDS
        //
        //
        //name Moss
        //origin WildNature
        //soil
        //    SOD_PODZOLIC
        //visualParameters
        //    stemColor  Green
        //    leavesColor  Green
        //    size  0.1
        //growingTips
        //    temp  15
        //    lighting  Week
        //    watering  Occasional
        //multiplying
        //    LEAVES

        ParsingIntoObject saxParse = new SAXParseImp();
        List<Flower> flowersSAX = saxParse.parseIntoObject(PATH);
        for (Flower flower : flowersSAX) {
            logger.info(flower.toString());
        }
        // Got this
//Flower{name='Peony, origin='Japan, soil=GROUND, visualParameters=stemColor='Green', leavesColor='Pink', size=1.0}, growingTips=temp='15', lighting='Strong', watering='Regular'}, multiplying=CUTTING}
//Flower{name='Hydrangea, origin='England, soil=PODZOLIC, visualParameters=stemColor='Green', leavesColor='Blue', size=0.5}, growingTips=temp='20', lighting='Strong', watering='Infrequent'}, multiplying=SEEDS}
//Flower{name='Moss, origin='WildNature, soil=SOD_PODZOLIC, visualParameters=stemColor='Green', leavesColor='Green', size=0.1}, growingTips=temp='15', lighting='Week', watering='Occasional'}, multiplying=LEAVES}

        logger.info("\n");

        ParsingIntoObject staxParse = new STAXParseImp();

        Comparator<Flower> flowerComp = (o1, o2) -> o1.getVisualParameters().getSize().compareTo(o2.getVisualParameters().getSize());

        List<Flower> flowersStax  = staxParse.parseIntoObject(PATH);
        Collections.sort(flowersStax, flowerComp);
        for (Flower flower : flowersStax) {
            logger.info(flower.toString());
        }

        WritingUtil.writeDOM(PATH_WRITE_EXAMPLE_DOM);
        WritingUtil.writeStax("src/main/java/freeIt/hw21xml/resources/writeExStax.xml");
// got the same
    }
}
