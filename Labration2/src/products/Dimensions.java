package products;

import java.util.Objects;

public class Dimensions {

    private int height;
    private int width;
    private int depth;
    private double weight;

    public Dimensions(String dim){
        String[] dimToString = dim.split("x");

    }
    public Dimensions(int height, int width, int depth, double weight) {
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Height: " + height + "cm" +
                "\nWidth: " + width + "cm" +
                "\nDepth: " + depth + "cm" +
                "\nWeight: " + weight + "kg";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dimensions that = (Dimensions) o;
        return height == that.height &&
                width == that.width &&
                depth == that.depth &&
                Double.compare(that.weight, weight) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, width, depth, weight);
    }
}