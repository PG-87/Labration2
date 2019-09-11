package objects;

public class Circle {

    private double radius;
    private boolean filled;

    public Circle(double radius) {
        this.radius = radius;
    }

    //<editor-fold desc="Getters/Setters">
    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    //</editor-fold>

    public double getCircumrefence (){
        return radius * 2.0 * Math.PI;
    }

    public double getArea (){
        return radius * radius * Math.PI;
    }
}
