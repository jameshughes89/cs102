package maze;

import java.util.Set;

public interface MazeSolver {

    /**
     * Returns a single solution to a given maze as a Set of cells. If no solution exists
     * for the provided maze, the Set will be empty. If the solver has multiple possible
     * solutions for a given maze, any may be returned.
     * <p>
     * The solution contains both the Start and End points of the maze.
     *
     * @param maze The maze to be solved.
     * @return Set of cells in the final path. If no path exists the set is empty
     */
    Set<Cell> solve(Maze maze);
}
