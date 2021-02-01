import freeIt.hw20.Text;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class HW20MainTest {
    /**
     * Программа принимает на вход английский текст, произвольной длины,
     * обрабатывает его и выводит все слова, которые встречаются в тексте (без
     * дубликатов) группируя их по первой букве в алфавитном порядке. Знаки
     * препинания игнорируются. Регистр заглавных букв не учитывается.
     */

    public static final String TEXT = "Once upon a time a Wolf was lapping at a spring on a hillside, when, looking " +
            "up, what should he see but a Lamb just beginning to drink a little lower down.";
    private static List<String> list;
    private static Map<String, Set<String>> map;
    private static Text text;

    @BeforeClass
    public static void main() {
        text = new Text(TEXT);
        map = text.textToMap();
    }

    @Test
    public void test_Text_Without_Duplicates() {
        list = text.textToList();
        Set<String> expected = new TreeSet<>(list);
        Set<String> textWithoutDuplicates = map.entrySet().stream().flatMap(e -> e.getValue().stream()).collect(Collectors.toSet());
        Assert.assertArrayEquals(expected.toArray(new String[0]), textWithoutDuplicates.toArray(new String[0]));

    }

    @Test
    public void test_Ignore_Punctuation() {
        String TEXT = "Once upon a time a Wolf was lapping at a spring on a hillside when looking " +
                "up what should he see but a Lamb just beginning to drink a little lower down";
        String textIgnorePunc = text.getText().replaceAll("[^A-Za-z\\s]", "");
        Assert.assertEquals(TEXT, textIgnorePunc);
    }

    @Test
    public void test_Ignore_Case() {
        String expected = TEXT.toLowerCase();
        Assert.assertEquals(expected, text.ignoreCase());
    }

    @Test
    public void test_How_Much_Keys_In_Map(){
        Assert.assertEquals(11, map.entrySet().size());
    }

    @Test
    public void test_Get_First_Letter_In_First_Word() {
        String letter = text.textToList().get(0).substring(0, 1).toLowerCase();
        Assert.assertEquals("o", letter);
    }


//    @AfterClass
//    public static void logOut() {
//        PropertyConfigurator.configure("src/main/java/freeIt/log4j.properties");
//        Logger logger = LoggerFactory.getLogger(HW20MainTest.class.getName());
//        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
//            logger.info(entry.getKey() + " : " + entry.getValue());
//        }
//    }
}
