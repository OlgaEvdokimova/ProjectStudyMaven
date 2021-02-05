package freeIt.hw21xml;

import freeIt.hw21xml.greenHouse.Flower;
//import freeIt.hw21xml.parsing.DOMParseImp;
import freeIt.hw21xml.parsing.DOMParseImp;
import freeIt.hw21xml.parsing.Parsing;
import freeIt.hw21xml.parsing.SAXParseImp;

import java.util.List;

public class Main {
    public static final String PATH = "src/main/java/freeIt/hw21xml/resources/flower.xml";

    public static void main(String[] args) {
        Parsing domParsing = new DOMParseImp();
//        List<String> parseFlowersList = domParsing.parseIntoText(PATH);
//        for (String node : parseFlowersList) {
//            System.out.println(node);
//        }

        List<Flower> parseFlowersList = domParsing.parseInto(PATH);
        for (Flower node : parseFlowersList) {
            System.out.println(node);
        }
        System.out.println();
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

        Parsing saxParse = new SAXParseImp();
        List<Flower> flowersSAX = saxParse.parseInto(PATH);
        for (Flower flower: flowersSAX){
            System.out.println(flower);
        }

    }
}
