package maze;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Class representing a maze. The maze is made up of a 2D array of Cells. Mazes
 * are loaded based on the contents of a file.
 * <p>
 * Note that, visually, the origin of the maze is the top left.
 * <p>
 * The ASCII legend/key for the maze is:
 * - wall:     '#'
 * - open:     ' '
 * - start:    'S' <-- must have exactly one
 * - end:      'E' <-- must have exactly one
 * <p>
 * e.g.
 * #####
 * #   #
 * # ###
 * S   #
 * # # #
 * ###E#
 */
public final class Maze {

    private final Cell[][] maze;
    private final Cell start;
    private final Cell end;

    private Maze(Cell[][] maze, Cell start, Cell end) {
        this.maze = maze;
        this.start = start;
        this.end = end;
    }

    /**
     * Create a maze from a String. The format of the maze is an
     * ASCII representation of the maze. If the maze has no starting
     * or ending cell, a MazeEndpointsException is thrown. If a maze
     * has multiple starts/ends, a MazeEndpointsException is thrown.
     *
     * @param mazeString String representation of the maze
     * @return A new maze based on the String
     * @throws MazeEndpointsException Exception for missing S/E or multiple S/Es
     */
    public static Maze fromString(String mazeString) {
        Cell[][] maze;
        Cell start = null;
        Cell end = null;
        // Split the maze string on newline characters for Windows|Unix
        String[] rows = mazeString.split("(\r\n|\n)");
        maze = new Cell[rows.length][rows[0].length()];
        for (int y = 0; y < maze.length; y++) {
            for (int x = 0; x < maze[y].length; x++) {
                maze[y][x] = new Cell(rows[y].charAt(x), x, y);
                if (maze[y][x].isStart()) {
                    // If a start already exists, throw exception
                    if (start != null) throw new MazeEndpointsException("Maze has multiple starts.");
                    start = maze[y][x];
                }
                if (maze[y][x].isEnd()) {
                    // If an end already exists, throw exception
                    if (end != null) throw new MazeEndpointsException("Maze has multiple ends.");
                    end = maze[y][x];
                }
            }
        }
        // If the maze has no start/end, throw exception
        if (start == null) throw new MazeEndpointsException("Maze has no start.");
        if (end == null) throw new MazeEndpointsException("Maze has no end.");
        return new Maze(maze, start, end);
    }

    /**
     * Create a maze from a file. The format of the maze in the file is
     * an ASCII representation of the maze.
     *
     * @param mazeFile Filename of maze to load
     * @return A new maze based on the file
     * @throws UncheckedIOException Any general UncheckedIOException
     */
    public static Maze fromFile(String mazeFile) {
        try {
            return Maze.fromString(Files.readString(Paths.get(mazeFile)));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    /**
     * Get Cell corresponding to the start of the maze.
     *
     * @return The start Cell
     */
    public Cell getStart() {
        return start;
    }

    /**
     * Get Cell corresponding to the end of the maze.
     *
     * @return The end Cell
     */
    public Cell getEnd() {
        return end;
    }

    /**
     * Get reference to cell at specified location. If the specified location
     * does not exist in the maze, a LocationNotInMazeException is thrown.
     *
     * @param x x coordinate of the cell
     * @param y y coordinate of the cell
     * @return Reference to specified cell
     * @throws LocationNotInMazeException If specified location is outside
     *                                    the maze
     */
    public Cell getCell(int x, int y) {
        if (!isLocationInMaze(x, y))
            throw new LocationNotInMazeException(String.format("Location  x=%d, y=%d not in maze.", x, y));
        return maze[y][x];
    }

    /**
     * Checks if a given location exists in the maze.
     *
     * @param x x coordinate of the location to check
     * @param y y coordinate of the location to check
     * @return true if valid, false otherwise
     */
    public boolean isLocationInMaze(int x, int y) {
        return x >= 0 && x < maze[0].length && y >= 0 && y < maze.length;
    }

    /**
     * Returns the string representation of the maze. This simply is the ASCII
     * representation of the maze used when loading the maze from file.
     *
     * @return String ASCII representation of the maze
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int y = 0; y < maze.length; y++) {
            for (int x = 0; x < maze[0].length; x++) {
                s.append(maze[y][x]);
            }
            // Only add newline characters if it's
            // not the last line of the maze
            if (y != maze.length - 1) {
                s.append("\n");
            }
        }
        return s.toString();
    }

    /**
     * Returns the height of the maze. The height is along the y-axis.
     *
     * @return Height of the maze
     */
    public int getHeight() {
        return maze.length;
    }

    /**
     * Returns the width of the maze. The width is along the x-axis.
     *
     * @return Width of the maze
     */
    public int getWidth() {
        return maze[0].length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Maze maze1 = (Maze) o;
        return Arrays.deepEquals(maze, maze1.maze);
    }

    @Override
    public int hashCode() {
        return 31 + Arrays.deepHashCode(maze);
    }
}
