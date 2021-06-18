/**
 * The square class inherits from the Rectangle class
 */
public class Square extends Rectangle {

    // Notice that we do not have any new fields

    /**
     * Call the superclass' (Rectangle) matching
     * constructor
     */
    public Square() {
        // Could have done this(1)
        super();
    }

    /**
     * This call's the superclass' (Rectangle)
     * constructor. Since a square only has a
     * side length, we call Rectangle's
     * constructor that takes two parameters,
     * but we simply provide side twice since
     * side will be both the length and width.
     *
     * @param side  Side length of the square
     */
    public Square(double side) {
        super(side, side);
    }

    /**
     * A new method not inherited from the
     * superclass. Return the side length
     * of the square. Since both the width
     * and length will be the same, either
     * method call would work.
     *
     * @return Side length of the square
     */
    public double getSide() {
        // Could have done getLength
        return getWidth();
    }

    /**
     * Override the superclass' (Rectangle)
     * toString. Remember, the Rectangle's
     * toString overrides it's superclass's
     * (the Object class) toString.
     * @return
     */
    public String toString() {
        return String.format("Square(Side = %.2f)", getSide());
    }
}
