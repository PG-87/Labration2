package products;

public class Soundbar {

    private String modelName;
    private String brand;
    private double channels;
//    private Dimensions dimensions;

    //<editor-fold desc="Getters">
    public String getModelName() {
        return modelName;
    }

    public String getBrand() {
        return brand;
    }

    public double getChannels() {
        return channels;
    }
    //</editor-fold>

    public Soundbar(String modelName, String brand, double channels) {
        this.modelName = modelName;
        this.brand = brand;
        this.channels = channels;
    }
}
