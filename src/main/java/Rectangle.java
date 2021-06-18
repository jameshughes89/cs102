public class Rectangle {

    private double length;
    private double width;

    public Rectangle() {
        this(1,1);
    }

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getArea() {
        return length * width;
    }

    public String toString() {
        return String.format("Rectangle(Length = %.2f, Width = %.2f)", length, width);
    }

}
