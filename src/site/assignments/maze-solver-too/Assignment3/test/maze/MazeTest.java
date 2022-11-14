package maze;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class MazeTest {

    private static final String EMPTY_MAZE =
            "";
    private static final String NO_START_MAZE =
            "#####\n" +
                    "# # #\n" +
                    "# # #\n" +
                    "#   E\n" +
                    "# # #\n" +
                    "#####";
    private static final String NO_END_MAZE =
            "#####\n" +
                    "# # #\n" +
                    "# # #\n" +
                    "S   #\n" +
                    "# # #\n" +
                    "#####";
    private static final String MULTIPLE_START_MAZE =
            "#####\n" +
                    "# # #\n" +
                    "# # #\n" +
                    "S   E\n" +
                    "# # #\n" +
                    "####S";
    private static final String MULTIPLE_END_MAZE =
            "#####\n" +
                    "# # #\n" +
                    "# # #\n" +
                    "S   E\n" +
                    "# # #\n" +
                    "####E";
    private static final String NON_EMPTY_MAZE =
            "#####\n" +
                    "# # #\n" +
                    "# # #\n" +
                    "S   E\n" +
                    "# # #\n" +
                    "#####";
    private static final String SMALL_MAZE =
            "SE";
    private static final String LINE_MAZE =
            "SE##################";
    private static final String WIDE_MAZE =
            "SE######################################\n" +
                    "########################################\n" +
                    "########################################\n" +
                    "########################################";
    private static final String SKINNY_MAZE =
            "S\n" +
                    "E\n" +
                    "#\n" +
                    "#\n" +
                    "#\n" +
                    "#\n" +
                    "#\n" +
                    "#\n" +
                    "#\n" +
                    "#\n" +
                    "#\n" +
                    "#\n" +
                    "#\n" +
                    "#\n" +
                    "#\n" +
                    "#\n" +
                    "#\n" +
                    "#\n" +
                    "#\n" +
                    "#\n" +
                    "#\n" +
                    "#\n" +
                    "#\n" +
                    "#";
    private static final String TALL_MAZE =
            "SE##\n" +
                    "####\n" +
                    "####\n" +
                    "####\n" +
                    "####\n" +
                    "####\n" +
                    "####\n" +
                    "####\n" +
                    "####\n" +
                    "####\n" +
                    "####\n" +
                    "####\n" +
                    "####\n" +
                    "####\n" +
                    "####\n" +
                    "####\n" +
                    "####\n" +
                    "####\n" +
                    "####\n" +
                    "####\n" +
                    "####\n" +
                    "####\n" +
                    "####\n" +
                    "####";

    private Maze classUnderTest;

    static Stream<String> mazeStringExamples() {
        return Stream.of(NON_EMPTY_MAZE, SMALL_MAZE, LINE_MAZE, WIDE_MAZE, SKINNY_MAZE, TALL_MAZE);
    }

    @Test
    @DisplayName("Making a maze with an empty String throws MazeEndpointsException.")
    void fromString_emptyString_throwsMazeEndpointsException() {
        assertThrows(MazeEndpointsException.class, () -> Maze.fromString(EMPTY_MAZE));
    }

    @Test
    @DisplayName("Making a maze with no start throws MazeEndpointsException.")
    void fromString_noStart_throwsMazeEndpointsException() {
        assertThrows(MazeEndpointsException.class, () -> Maze.fromString(NO_START_MAZE));
    }

    @Test
    @DisplayName("Making a maze with no end throws MazeEndpointsException.")
    void fromString_noEnd_throwsMazeEndpointsException() {
        assertThrows(MazeEndpointsException.class, () -> Maze.fromString(NO_END_MAZE));
    }

    @Test
    @DisplayName("Making a maze with multiple starts throws MazeEndpointsException.")
    void fromString_multipleStarts_throwsMazeEndpointsException() {
        assertThrows(MazeEndpointsException.class, () -> Maze.fromString(MULTIPLE_START_MAZE));
    }

    @Test
    @DisplayName("Making a maze with multiple ends throws MazeEndpointsException.")
    void fromString_multipleEnds_throwsMazeEndpointsException() {
        assertThrows(MazeEndpointsException.class, () -> Maze.fromString(MULTIPLE_END_MAZE));
    }

    @BeforeEach
    void createMaze() {
        classUnderTest = Maze.fromString(NON_EMPTY_MAZE);
    }

    @Test
    @DisplayName("Making a Maze with string is equal to a Maze made with a file.")
    void fromFile_fromString_equal() {
        assertEquals(classUnderTest, Maze.fromFile("./resources/maze/maze1.txt"));
    }

    @Test
    @DisplayName("Getting start from Maze returns start.")
    void getStart_onlyUseCase_returnsStart() {
        Assertions.assertEquals(new Cell('S', 0, 3), classUnderTest.getStart());
    }

    @Test
    @DisplayName("Getting end from Maze returns end.")
    void getEnd_onlyUseCase_returnsEnd() {
        assertEquals(new Cell('E', 4, 3), classUnderTest.getEnd());
    }

    @Test
    @DisplayName("Getting the height of a maze returns the proper height.")
    void getHeight_onlyUseCase_returnsHeight() {
        assertEquals(6, classUnderTest.getHeight());
    }

    @Test
    @DisplayName("Getting the width of a maze returns the proper width.")
    void getWidth_onlyUseCase_returnsWidth() {
        assertEquals(5, classUnderTest.getWidth());
    }

    @Test
    @DisplayName("Getting a cell at valid location returns a cell with correct x & y.")
    void getCell_validIndex_returnsCellWithIndex() {
        assertEquals(new Cell(' ', 2, 3), classUnderTest.getCell(2, 3));
    }

    @ParameterizedTest
    @CsvSource({"-1,-1", "0,-1", "-1,0", "5,6", "1000,1000"})
    @DisplayName("Getting a cell at an invalid index throws LocationNotInMazeException.")
    void getCell_invalidIndex_throwsLocationNotInMazeException(int x, int y) {
        assertThrows(LocationNotInMazeException.class, () -> classUnderTest.getCell(x, y));
    }

    @ParameterizedTest
    @CsvSource({"0,0", "4,0", "0,5", "4,5"})
    @DisplayName("Checking if an invalid location is in the maze returns false.")
    void isLocationInMaze_validIndex_returnsTrue(int x, int y) {
        assertTrue(classUnderTest.isLocationInMaze(x, y));
    }

    @ParameterizedTest
    @CsvSource({"-1,-1", "0,-1", "-1,0", "5,6", "1000,1000"})
    @DisplayName("Checking if an invalid location is in the maze returns false.")
    void isLocationInMaze_invalidIndex_returnsFalse(int x, int y) {
        assertFalse(classUnderTest.isLocationInMaze(x, y));
    }

    @ParameterizedTest
    @MethodSource("mazeStringExamples")
    @DisplayName("Maze toString returns string equal to string used for creation.")
    void toString_multipleMazeStrings_returnsStringFromBuild(String mazeString) {
        Maze stringMe = Maze.fromString(mazeString);
        assertEquals(mazeString, stringMe.toString());
    }
}
