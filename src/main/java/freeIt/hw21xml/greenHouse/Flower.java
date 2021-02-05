package freeIt.hw21xml.greenHouse;
/**
 * Оранжерея. Растения, содержащиеся в оранжерее, имеют следующие характеристики:
 * — Name — название растения;
 * — Soil — почва для посадки, которая может быть следующих типов: подзолистая, грунтовая,
 * дерново-подзолистая;
 * — Origin — место происхождения растения;
 * — Visual рarameters (должно быть несколько) — внешние параметры: цвет стебля, цвет
 * листьев, средний размер растения;
 * — Growing tips (должно быть несколько) — предпочтительные условия произрастания:
 * температура (в градусах), освещение (светолюбиво либо нет), полив (мл в неделю);
 * — Multiplying — размножение: листьями, черенками либо семенами.
 * Корневой элемент назвать Flower.
 * 1) Создать файл XML и соответствующую ему схему XSD.
 * 2) При разработке XSD использовать простые и комплексные типы, перечисления, шаблоны и
 * предельные значения.
 * 3) Создать класс, соответствующий данному описанию.
 * 4) Создать приложение для разбора XML-документа и инициализации коллекции объектов
 * информацией из XML-файла. Для разбора использовать SAX, DOM и StAX парсеры. Для
 * сортировки объектов использовать интерфейс Comparator. Вывести на экран коллекцию.
 * 5) Произвести проверку XML-документа с привлечением XSD.
 */
public class Flower {

    private String name;
    private String origin;
    private Enums.Soil soil;
    private VisualParameters visualParameters;
    private GrowingTips growingTips;
    private Enums.Multiplying multiplying;

    public Flower() {
    }

    public Flower(String name, String origin, Enums.Soil soil, VisualParameters visualParameters, GrowingTips growingTips, Enums.Multiplying multiplying) {
        this.name = name;
        this.origin = origin;
        this.soil = soil;
        this.visualParameters = visualParameters;
        this.growingTips = growingTips;
        this.multiplying = multiplying;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Enums.Soil getSoil() {
        return soil;
    }

    public void setSoil(Enums.Soil soil) {
        this.soil = soil;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public VisualParameters getVisualParameters() {
        return visualParameters;
    }

    public void setVisualParameters(VisualParameters visualParameters) {
        this.visualParameters = visualParameters;
    }

    public GrowingTips getGrowingTips() {
        return growingTips;
    }

    public void setGrowingTips(GrowingTips growingTips) {
        this.growingTips = growingTips;
    }

    public Enums.Multiplying getMultiplying() {
        return multiplying;
    }

    public void setMultiplying(Enums.Multiplying multiplying) {
        this.multiplying = multiplying;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "name='" + name +
                ", origin='" + origin  +
                ", soil=" + soil +
                ", visualParameters=" + visualParameters +
                ", growingTips=" + growingTips +
                ", multiplying=" + multiplying +
                '}';
    }
}


 //<?xml version = "1.0" encoding ="UTF-8"?>
//<flowers xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
//         xmlns:jc = "https://example.com/flowers"
//         xsi:schemaLocation="http://www.example.com/flowers /freeIt/hw21xml/resources/scheme.xsd" >
//
//    <jc:flower name="Peony" origin="Japan">
//        <soil>GROUND</soil>
//        <visualParameters>
//            <stemColor>Green</stemColor>
//            <leavesColor>Pink</leavesColor>
//            <size>1</size>
//        </visualParameters>
//        <growingTips>
//            <temp>15</temp>
//            <lighting>Strong</lighting>
//            <watering>Regular</watering>
//        </growingTips>
//        <multiplying>CUTTING</multiplying>
//    </jc:flower>
//
//    <flower soil="PODZOLIC" origin="England">
//        <name>Hydrangea</name>
//        <visualParameters>
//            <stemColor>Green</stemColor>
//            <leavesColor>Blue</leavesColor>
//            <size>0.5</size>
//        </visualParameters>
//        <growingTips>
//            <temp>20</temp>
//            <lighting>Strong</lighting>
//            <watering>Infrequent</watering>
//        </growingTips>
//        <multiplying>SEEDS</multiplying>
//    </flower>
//
//    <flower soil="SOD_PODZOLIC" origin="WildNature">
//        <name>Moss</name>
//        <visualParameters>
//            <stemColor>Green</stemColor>
//            <leavesColor>Green</leavesColor>
//            <size>0.1</size>
//        </visualParameters>
//        <growingTips>
//            <temp>15</temp>
//            <lighting>Week</lighting>
//            <watering>Occasional</watering>
//        </growingTips>
//        <multiplying>LEAVES</multiplying>
//    </flower>
//</flowers>