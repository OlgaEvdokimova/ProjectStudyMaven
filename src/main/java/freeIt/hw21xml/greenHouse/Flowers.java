package freeIt.hw21xml.greenHouse;

import java.util.ArrayList;
import java.util.List;

public class Flowers {
    List<Flower> list;

    public Flowers() {
        this.list = new ArrayList<>();
    }

    public List<Flower> getList() {
        return list;
    }

    public void setList(List<Flower> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Flowers{" +
                "list=" + list +
                '}';
    }
}
