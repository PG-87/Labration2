package products;

public class Speaker {

    private String modelName;
    private String brand;
    private boolean smartSpeaker;
    private boolean bluetooth;
//    private Dimensions dimensions;

    public Speaker(String modelName, String brand, boolean smartSpeaker, boolean bluetooth) {
        this.modelName = modelName;
        this.brand = brand;
        this.smartSpeaker = smartSpeaker;
        this.bluetooth = bluetooth;

    }
}
