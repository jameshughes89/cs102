import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DfsMazeSolverTest {

    private static final String MAZE_NO_SOLUTION =
            "#####\n" +
                    "#   #\n" +
                    "#   #\n" +
                    "S  #E\n" +
                    "#   #\n" +
                    "#####";
    private static final String MAZE_ONE_SOLUTION =
            "#####\n" +
                    "#####\n" +
                    "#####\n" +
                    "S   E\n" +
                    "#####\n" +
                    "#####";
    private static final String MAZE_TWO_SOLUTION =
            "#####\n" +
                    "#####\n" +
                    "#   #\n" +
                    "S # E\n" +
                    "#   #\n" +
                    "#####";
    private static final String MAZE_THREE_SOLUTION =
            "#   #\n" +
                    "# # #\n" +
                    "#   #\n" +
                    "S # E\n" +
                    "#   #\n" +
                    "#####";

    private static final Set<Cell> PATH_NO_SOLUTION = Set.of();
    private static final Set<Cell> PATH_ONE_SOLUTION = Set.of(
            new Cell('S', 0, 3),
            new Cell(' ', 1, 3),
            new Cell(' ', 2, 3),
            new Cell(' ', 3, 3),
            new Cell('E', 4, 3)
    );
    private static final Set<Cell> PATH_TWO_SOLUTION_A = Set.of(
            new Cell('S', 0, 3),
            new Cell(' ', 1, 3),
            new Cell(' ', 1, 2),
            new Cell(' ', 2, 2),
            new Cell(' ', 3, 2),
            new Cell(' ', 3, 3),
            new Cell('E', 4, 3)
    );
    private static final Set<Cell> PATH_TWO_SOLUTION_B = Set.of(
            new Cell('S', 0, 3),
            new Cell(' ', 1, 3),
            new Cell(' ', 1, 4),
            new Cell(' ', 2, 4),
            new Cell(' ', 3, 4),
            new Cell(' ', 3, 3),
            new Cell('E', 4, 3)
    );
    private static final Set<Cell> PATH_THREE_SOLUTION_A = Set.of(
            new Cell('S', 0, 3),
            new Cell(' ', 1, 3),
            new Cell(' ', 1, 2),
            new Cell(' ', 1, 1),
            new Cell(' ', 1, 0),
            new Cell(' ', 2, 0),
            new Cell(' ', 3, 0),
            new Cell(' ', 3, 1),
            new Cell(' ', 3, 2),
            new Cell(' ', 3, 3),
            new Cell('E', 4, 3)
    );
    private static final Set<Cell> PATH_THREE_SOLUTION_B = Set.of(
            new Cell('S', 0, 3),
            new Cell(' ', 1, 3),
            new Cell(' ', 1, 2),
            new Cell(' ', 2, 2),
            new Cell(' ', 3, 2),
            new Cell(' ', 3, 3),
            new Cell('E', 4, 3)
    );
    private static final Set<Cell> PATH_THREE_SOLUTION_C = Set.of(
            new Cell('S', 0, 3),
            new Cell(' ', 1, 3),
            new Cell(' ', 1, 4),
            new Cell(' ', 2, 4),
            new Cell(' ', 3, 4),
            new Cell(' ', 3, 3),
            new Cell('E', 4, 3)
    );

    private MazeSolver classUnderTest;

    @BeforeEach
    void createMazeAndSolver() {
        classUnderTest = new DfsMazeSolver();
    }

    @Test
    void solve_noSolution_returnsEmptySet() {
        Maze maze = Maze.fromString(MAZE_NO_SOLUTION);
        assertEquals(PATH_NO_SOLUTION, classUnderTest.solve(maze));
    }

    @Test
    void solve_oneSolution_returnsPath() {
        Maze maze = Maze.fromString(MAZE_ONE_SOLUTION);
        assertEquals(PATH_ONE_SOLUTION, classUnderTest.solve(maze));
    }

    @Test
    void solve_twoSolution_returnsAnyPath() {
        Maze maze = Maze.fromString(MAZE_TWO_SOLUTION);
        Set<Cell> solution = classUnderTest.solve(maze);
        assertTrue(solution.equals(PATH_TWO_SOLUTION_A)
                || solution.equals(PATH_TWO_SOLUTION_B));
    }

    @Test
    void solve_threeSolution_returnsAnyPath() {
        Maze maze = Maze.fromString(MAZE_THREE_SOLUTION);
        Set<Cell> solution = classUnderTest.solve(maze);
        assertTrue(solution.equals(PATH_THREE_SOLUTION_A)
                || solution.equals(PATH_THREE_SOLUTION_B)
                || solution.equals(PATH_THREE_SOLUTION_C));
    }
}
