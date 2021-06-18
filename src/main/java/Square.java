public class Square extends Rectangle {

    public Square() {
        super();
    }

    public Square(double side) {
        super(side, side);
    }

    public double getSide() {
        // Could have done getLength
        return getWidth();
    }

    public String toString() {
        return String.format("Square(Side = %.2f)", getSide());
    }
}
