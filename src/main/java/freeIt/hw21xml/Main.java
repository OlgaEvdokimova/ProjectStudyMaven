package freeIt.hw21xml;

import freeIt.hw21xml.greenHouse.Flower;
//import freeIt.hw21xml.parsing.DOMParseImp;
import freeIt.hw21xml.parsing.DOMParseImp;
import freeIt.hw21xml.parsing.ParsingIntoObject;
import freeIt.hw21xml.parsing.SAXParseImp;
import freeIt.hw21xml.parsing.STAXParseImp;
import freeIt.hw21xml.writing.WritingUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static final String PATH = "src/main/java/freeIt/hw21xml/resources/flower.xml";
    public static final String PATH_WRITE_EXAMPLE = "src/main/java/freeIt/hw21xml/resources/writeExample.xml";

    public static void main(String[] args) {
        DOMParseImp domParsing = new DOMParseImp();

        List<Flower> parseFlowersList = domParsing.parseIntoObject(PATH);
        for (Flower node : parseFlowersList) {
            System.out.println(node);
        }
        //Got this
        //Flower{name='Peony, origin='Japan, soil=GROUND, visualParameters=stemColor='Green', leavesColor='Pink', size=1.0}, growingTips=temp='15', lighting='Strong', watering='Regular'}, multiplying=CUTTING}
        //Flower{name='Hydrangea, origin='England, soil=PODZOLIC, visualParameters=stemColor='Green', leavesColor='Blue', size=0.5}, growingTips=temp='20', lighting='Strong', watering='Infrequent'}, multiplying=SEEDS}
        //Flower{name='Moss, origin='WildNature, soil=SOD_PODZOLIC, visualParameters=stemColor='Green', leavesColor='Green', size=0.1}, growingTips=temp='15', lighting='Week', watering='Occasional'}, multiplying=LEAVES}
        System.out.println();

        List<String> parseFlowersText = domParsing.parseIntoText(PATH);
        for (String node : parseFlowersText) {
            System.out.println(node);
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
            System.out.println(flower);
        }
        // Got this
//Flower{name='Peony, origin='Japan, soil=GROUND, visualParameters=stemColor='Green', leavesColor='Pink', size=1.0}, growingTips=temp='15', lighting='Strong', watering='Regular'}, multiplying=CUTTING}
//Flower{name='Hydrangea, origin='England, soil=PODZOLIC, visualParameters=stemColor='Green', leavesColor='Blue', size=0.5}, growingTips=temp='20', lighting='Strong', watering='Infrequent'}, multiplying=SEEDS}
//Flower{name='Moss, origin='WildNature, soil=SOD_PODZOLIC, visualParameters=stemColor='Green', leavesColor='Green', size=0.1}, growingTips=temp='15', lighting='Week', watering='Occasional'}, multiplying=LEAVES}

        System.out.println();

        ParsingIntoObject staxParse = new STAXParseImp();

        Comparator<Flower> flowerComp = (o1, o2) -> o1.getVisualParameters().getSize().compareTo(o2.getVisualParameters().getSize());

        List<Flower> flowersStax  = staxParse.parseIntoObject(PATH);
        Collections.sort(flowersStax, flowerComp);
        for (Flower flower : flowersStax) {
            System.out.println(flower);
        }

        WritingUtil.writeDOM(PATH_WRITE_EXAMPLE);
// got the same
    }
}
