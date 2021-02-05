package freeIt.hw21xml.greenHouse;

public class VisualParameters {
    private String stemColor;
    private String leavesColor;
    private Double size;

    public VisualParameters() {
    }

    public VisualParameters(String stemColor, String leavesColor, Double size) {
        this.stemColor = stemColor;
        this.leavesColor = leavesColor;
        this.size = size;
    }

    public String getStemColor() {
        return stemColor;
    }

    public void setStemColor(String stemColor) {
        this.stemColor = stemColor;
    }

    public String getLeavesColor() {
        return leavesColor;
    }

    public void setLeavesColor(String leavesColor) {
        this.leavesColor = leavesColor;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return  "stemColor='" + stemColor + '\'' +
                ", leavesColor='" + leavesColor + '\'' +
                ", size=" + size +
                '}';
    }
}
