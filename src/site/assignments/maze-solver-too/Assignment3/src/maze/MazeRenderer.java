package maze;

import java.util.Set;

public class MazeRenderer {

    /**
     * Build the string representing the maze with the final path included.
     *
     * @param maze      The maze being solved that the path exists in
     * @param finalPath Set of cells in the final path
     * @return String representation of the rendered maze
     */
    public String render(Maze maze, Set<Cell> finalPath) {
        StringBuilder solution = new StringBuilder();
        for (int y = 0; y < maze.getHeight(); y++) {
            for (int x = 0; x < maze.getWidth(); x++) {
                if (finalPath.contains(maze.getCell(x, y))) {
                    solution.append('o');
                } else {
                    solution.append(maze.getCell(x, y).getSymbol());
                }
            }
            solution.append("\n");
        }
        solution.append(String.format("Cells in final path: %d", finalPath.size()));
        return solution.toString();
    }
}
