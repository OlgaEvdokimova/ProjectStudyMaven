package freeIt.hw21xml.parsing;
import freeIt.hw21xml.greenHouse.Flower;
import java.util.List;

public interface Parsing {
    List<String> parseIntoText(String PATH);
    List<Flower> parseInto(String PATH);
}
