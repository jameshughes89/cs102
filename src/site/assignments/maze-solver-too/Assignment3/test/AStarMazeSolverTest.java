import maze.Cell;
import maze.Maze;
import maze.MazeSolver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AStarMazeSolverTest {
    private static final String MAZE_NO_SOLUTION = "#####\n" + "#   #\n" + "#   #\n" + "S  #E\n" + "#   #\n" + "#####";
    private static final String MAZE_ONE_SOLUTION = "#####\n" + "#   #\n" + "#   #\n" + "S   E\n" + "#   #\n" + "#   #\n" + "#####";
    private static final String MAZE_TWO_SOLUTION_ALPHA = "#####\n" + "#   #\n" + "#   #\n" + "S # E\n" + "#   #\n" + "#   #\n" + "#####";

    private static final String MAZE_TWO_SOLUTION_BETA = "####\n" + "S  #\n" + "#  E\n" + "####";

    private static final Set<Cell> PATH_NO_SOLUTION = Set.of();
    private static final Set<Cell> PATH_ONE_SOLUTION = Set.of(new Cell('S', 0, 3), new Cell(' ', 1, 3), new Cell(' ', 2, 3), new Cell(' ', 3, 3), new Cell('E', 4, 3));
    private static final Set<Cell> PATH_TWO_SOLUTION_ALPHA_A = Set.of(new Cell('S', 0, 3), new Cell(' ', 1, 3), new Cell(' ', 1, 2), new Cell(' ', 2, 2), new Cell(' ', 3, 2), new Cell(' ', 3, 3), new Cell('E', 4, 3));
    private static final Set<Cell> PATH_TWO_SOLUTION_ALPHA_B = Set.of(new Cell('S', 0, 3), new Cell(' ', 1, 3), new Cell(' ', 1, 4), new Cell(' ', 2, 4), new Cell(' ', 3, 4), new Cell(' ', 3, 3), new Cell('E', 4, 3));
    private static final Set<Cell> PATH_TWO_SOLUTION_BETA_A = Set.of(new Cell('S', 0, 1), new Cell(' ', 1, 1), new Cell(' ', 2, 1), new Cell(' ', 2, 2), new Cell('E', 3, 2));
    private static final Set<Cell> PATH_TWO_SOLUTION_BETA_B = Set.of(new Cell('S', 0, 1), new Cell(' ', 1, 1), new Cell(' ', 1, 2), new Cell(' ', 2, 2), new Cell('E', 3, 2));

    private MazeSolver classUnderTest;

    static Stream<Arguments> twoSolutionExamples() {
        return Stream.of(Arguments.of(MAZE_TWO_SOLUTION_ALPHA, PATH_TWO_SOLUTION_ALPHA_A, PATH_TWO_SOLUTION_ALPHA_B), Arguments.of(MAZE_TWO_SOLUTION_BETA, PATH_TWO_SOLUTION_BETA_A, PATH_TWO_SOLUTION_BETA_B));
    }

    @BeforeEach
    void createMazeAndSolver() {
        classUnderTest = new AStarMazeSolver();
    }

    @Test
    void solve_noSolution_returnsEmptySet() {

    }

    @Test
    void solve_oneSolution_returnsPath() {

    }

    @ParameterizedTest
    @MethodSource("twoSolutionExamples")
    void solve_twoSolution_returnsAnyPath(String mazeString, Set<Cell> pathA, Set<Cell> pathB) {

    }
}
