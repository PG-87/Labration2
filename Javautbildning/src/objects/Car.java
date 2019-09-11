package objects;

public class Car {

    private byte passengers;
    private String model;
    private int fuelCap;
    private double literKm;
    private boolean spareWheel;

    public Car() {
    }

    public byte getPassengers() {
        return passengers;
    }

    public void setPassengers(byte passengers) {
        this.passengers = passengers;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getFuelCap() {
        return fuelCap;
    }

    public void setFuelCap(int fuelCap) {
        this.fuelCap = fuelCap;
    }

    public double getLiterKm() {
        return literKm;
    }

    public void setLiterKm(double literKm) {
        this.literKm = literKm;
    }

    public boolean isSpareWheel() {
        return spareWheel;
    }

    public void setSpareWheel(boolean spareWheel) {
        this.spareWheel = spareWheel;
    }

    public double getcomputeRange(){
        return fuelCap / literKm;
    }
}
