package maze;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest {

    static Stream<Character> visitableSymbols() {
        return Stream.of(' ', 'S', 'E');
    }

    @Test
    void getSymbol_onlyUseCase_returnsSymbol() {
        Cell cell = new Cell('#', 0, 0);
        assertEquals('#', cell.getSymbol());
    }

    @Test
    void getX_onlyUseCase_returnsX() {
        Cell cell = new Cell(' ', 123, 0);
        assertEquals(123, cell.getX());
    }

    @Test
    void getY_onlyUseCase_returnsY() {
        Cell cell = new Cell(' ', 0, 321);
        assertEquals(321, cell.getY());
    }

    @Test
    void isStart_symbolS_returnsTrue() {
        Cell cell = new Cell('S', 0, 0);
        assertTrue(cell.isStart());
    }

    @Test
    void isStart_symbolNotS_returnsFalse() {
        Cell cell = new Cell('#', 0, 0);
        assertFalse(cell.isStart());
    }

    @Test
    void isEnd_symbolE_returnsTrue() {
        Cell cell = new Cell('E', 0, 0);
        assertTrue(cell.isEnd());
    }

    @Test
    void isEnd_symbolNotE_returnsFalse() {
        Cell cell = new Cell('#', 0, 0);
        assertFalse(cell.isEnd());
    }

    @Test
    void isVisitable_wallCell_returnsFalse() {
        Cell cell = new Cell('#', 0, 0);
        assertFalse(cell.isVisitable());
    }

    @ParameterizedTest
    @MethodSource("visitableSymbols")
    void isVisitable_visitable_returnsTrue(char symbol) {
        Cell cell = new Cell(symbol, 0, 0);
        assertTrue(cell.isVisitable());
    }

    @Test
    void toString_stringOfSymbol() {
        Cell cell = new Cell('#', 0, 0);
        assertEquals("#", cell.toString());
    }
}
