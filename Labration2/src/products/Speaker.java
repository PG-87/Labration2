package products;

public class Speaker {

    private String modelName;
    private String brand;
    private boolean smartSpeaker;
    private boolean bluetooth;

    //<editor-fold desc="Getters">
    public String getModelName() {
        return modelName;
    }

    public String getBrand() {
        return brand;
    }

    public boolean isSmartSpeaker() {
        return smartSpeaker;
    }

    public boolean isBluetooth() {
        return bluetooth;
    }
    //</editor-fold>

    public Speaker(String modelName, String brand, boolean smartSpeaker, boolean bluetooth) {
        this.modelName = modelName;
        this.brand = brand;
        this.smartSpeaker = smartSpeaker;
        this.bluetooth = bluetooth;

    }
}
