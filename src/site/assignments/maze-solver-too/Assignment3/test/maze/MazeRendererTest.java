package maze;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MazeRendererTest {

    private static final String MAZE =
            "#####\n" +
                    "#   #\n" +
                    "#   #\n" +
                    "S   E\n" +
                    "#   #\n" +
                    "#####";

    private static final Set<Cell> PATH_FILL = Set.of(
            new Cell(' ', 1, 1),
            new Cell(' ', 2, 1),
            new Cell(' ', 3, 1),
            new Cell(' ', 1, 2),
            new Cell(' ', 2, 2),
            new Cell(' ', 3, 2),
            new Cell(' ', 1, 3),
            new Cell(' ', 2, 3),
            new Cell(' ', 3, 3),
            new Cell(' ', 1, 4),
            new Cell(' ', 2, 4),
            new Cell(' ', 3, 4)
    );
    private static final String EXPECTED_MAZE_FILL =
            "#####\n" +
                    "#ooo#\n" +
                    "#ooo#\n" +
                    "SoooE\n" +
                    "#ooo#\n" +
                    "#####\n" +
                    "Cells in final path: 12";
    private static final Set<Cell> PATH_ON_START = Set.of(
            new Cell('S', 0, 3)
    );
    private static final String EXPECTED_MAZE_START =
            "#####\n" +
                    "#   #\n" +
                    "#   #\n" +
                    "o   E\n" +
                    "#   #\n" +
                    "#####\n" +
                    "Cells in final path: 1";
    private static final Set<Cell> PATH_ON_END = Set.of(
            new Cell('E', 4, 3)
    );
    private static final String EXPECTED_MAZE_END =
            "#####\n" +
                    "#   #\n" +
                    "#   #\n" +
                    "S   o\n" +
                    "#   #\n" +
                    "#####\n" +
                    "Cells in final path: 1";
    private static final Set<Cell> PATH_EMPTY = Set.of();
    private static final String EXPECTED_MAZE_NONE = MAZE + "\nCells in final path: 0";

    private static final Maze maze = Maze.fromString(MAZE);
    private MazeRenderer classUnderTest;

    @BeforeEach
    void createMazeRenderer() {
        classUnderTest = new MazeRenderer();
    }

    @Test
    @DisplayName("Maze with no path returns original maze string with counter of zero.")
    void render_noPath_returnsCorrectStringCounterZero() {
        assertEquals(EXPECTED_MAZE_NONE, classUnderTest.render(maze, PATH_EMPTY));
    }

    @Test
    @DisplayName("Maze with path on start returns original maze string with 'o' on S and counter of one.")
    void render_startPath_returnsCorrectStringCounterOne() {
        assertEquals(EXPECTED_MAZE_START, classUnderTest.render(maze, PATH_ON_START));
    }

    @Test
    @DisplayName("Maze with path on end returns original maze string with 'o' on E and counter of one.")
    void render_endPath_returnsCorrectStringCounterOne() {
        assertEquals(EXPECTED_MAZE_END, classUnderTest.render(maze, PATH_ON_END));
    }

    @Test
    @DisplayName("Maze with path filling maze returns original maze string with 'o's everywhere and counter of twelve.")
    void render_endPath_returnsCorrectStringCounterTwelve() {
        assertEquals(EXPECTED_MAZE_FILL, classUnderTest.render(maze, PATH_FILL));
    }
}
