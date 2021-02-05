package freeIt.hw21xml.greenHouse;

public class GrowingTips {
    private String temp;
    private String lighting;
    private String watering;

    public GrowingTips(String temp, String lighting, String watering) {
        this.temp = temp;
        this.lighting = lighting;
        this.watering = watering;
    }

    public GrowingTips() {
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getLighting() {
        return lighting;
    }

    public void setLighting(String lighting) {
        this.lighting = lighting;
    }

    public String getWatering() {
        return watering;
    }

    public void setWatering(String watering) {
        this.watering = watering;
    }

    @Override
    public String toString() {
        return  "temp='" + temp + '\'' +
                ", lighting='" + lighting + '\'' +
                ", watering='" + watering + '\'' +
                '}';
    }
}
