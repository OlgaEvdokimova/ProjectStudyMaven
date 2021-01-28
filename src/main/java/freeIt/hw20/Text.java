package freeIt.hw20;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text {
    private String text;

    public Text(String text) {
        this.text = text;
    }


    public List<String> textToList() {
        List<String> list = new ArrayList<>();
        return splitText(list);
    }

    public List<String> splitText(List<String> list) {
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String m = matcher.group().toLowerCase().trim();
            list.add(m);
        }
        return list;
    }

    public Map<String, Set<String>> textToMap() {
        Map<String, Set<String>> map = new TreeMap<>();
        List<String> textList = textToList();
        for (String s : textList) {
            if (!map.containsKey(s.substring(0, 1))) {
                map.put(s.substring(0, 1), new TreeSet<>());
            }
            map.get(s.substring(0, 1)).add(s);
        }
        return map;
    }

//    public String[] textWithoutDublicates() {
//        List<String> textList = textToList();
//        Set<String> set = new HashSet<>(textList);
//        return set.toArray(new String[set.size()]);
//    }

    public String ignoreCase() {
        return text.toLowerCase();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
