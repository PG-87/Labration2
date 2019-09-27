package products;

public class Headphones {

    private String modelName;
    private String brand;
    private boolean wireless;


    public Headphones(String modelName, String brand, boolean wireless) {
        this.modelName = modelName;
        this.brand = brand;
        this.wireless = wireless;
    }

    //<editor-fold desc="Getters">
    public String getModelName() {
        return modelName;
    }

    public String getBrand() {
        return brand;
    }
        public boolean isWireless() {
            return wireless;
    }
    //</editor-fold>
}
