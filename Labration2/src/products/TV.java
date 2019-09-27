package products;

import java.util.Objects;

public class TV  {
    private String modelName;
    private String brand;
    private int screenSize;
    private String panelType;
    private int resolution; //720, 1080, 2160
    private boolean smartTv;

    public TV(String modelName, String brand, int screenSize, String panelType, int resolution, boolean smartTv) {
        this.modelName = modelName;
        this.brand = brand;
        this.screenSize = screenSize;
        this.panelType = panelType;
        this.resolution = resolution;
        this.smartTv = smartTv;
    }

    //<editor-fold desc="Getters">
    public String getModelName() {
        return modelName;
    }

    public String getBrand() {
        return brand;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public String getPanelType() {
        return panelType;
    }

    public int getResolution() {
        return resolution;
    }

    public boolean isSmartTv() {
        return smartTv;
    }
    //</editor-fold>

    @Override
    public String toString() {
        return "\nModel: "+modelName+
                "\nBrand: "+brand+
                "\nScreensize: "+screenSize+"\""+
                "\nPaneltype: "+panelType+
                "\nResolution: "+resolution+"p"+
                "\nSmartTv: "+smartTv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TV tv = (TV) o;
        return screenSize == tv.screenSize &&
                resolution == tv.resolution &&
                smartTv == tv.smartTv &&
                Objects.equals(modelName, tv.modelName) &&
                Objects.equals(brand, tv.brand) &&
                Objects.equals(panelType, tv.panelType);

    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), modelName, brand, screenSize, panelType, resolution, smartTv);
    }
}


