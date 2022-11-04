package maze;

import java.util.Objects;

/**
 * The Cell class represents a location within a maze. The symbol of the cell
 * can represent what kind of cell it is, or the state of the cell. For example,
 * it can be a wall '#', open ' ', start 'S', or end 'E', but could also be the current cell 'O', in
 * the current path (on the stack) 'o', or already explored, but off the stack '.'.
 */
public final class Cell {

    private final char symbol;
    private final int x;
    private final int y;

    /**
     * Create an instance of a Cell object. The isStart and isEnd status is set based
     * on the symbol.
     *
     * @param symbol When created, the symbol can only represent the kind of cell:
     *               wall '#', open ' ', start 'S', and end 'E'.
     * @param x      x coordinate in the maze.
     * @param y      y coordinate in the maze.
     */
    public Cell(char symbol, int x, int y) {
        this.symbol = symbol;
        this.x = x;
        this.y = y;
    }

    /**
     * Get the cell's symbol.
     *
     * @return the cell's symbol
     */
    public char getSymbol() {
        return symbol;
    }

    /**
     * Get the cell's x coordinate.
     *
     * @return the cell's x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Get the cell's y coordinate.
     *
     * @return the cell's y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Check if the cell is the start of the maze.
     *
     * @return boolean indicating if it is the start (true) or not (false).
     */
    public boolean isStart() {
        return symbol == 'S';
    }

    /**
     * Check if the cell is the end of the maze.
     *
     * @return boolean indicating if it is the end (true) or not (false).
     */
    public boolean isEnd() {
        return symbol == 'E';
    }

    /**
     * Checks if a given cell is visitable. A cell is visitable if it is not a wall (#).
     * In other words, if it is open (' '), the start ('S') or the end ('E'), it is
     * visitable.
     *
     * @return true if it is open, false if it is a wall
     */
    public boolean isVisitable() {
        return symbol != '#';
    }

    /**
     * String version of the cell will simply be the current symbol.
     *
     * @return The string version of the cell's current symbol.
     */
    public String toString() {
        return String.valueOf(symbol);
    }

    /**
     * Two cell objects are equal if all fields match.
     *
     * @param o object to compare to
     * @return true if equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return this.symbol == cell.getSymbol() && this.x == cell.getX() && this.y == cell.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSymbol(), getX(), getY());
    }
}
