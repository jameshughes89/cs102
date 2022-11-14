package maze;

import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("getSymbol returns correct symbol.")
    void getSymbol_onlyUseCase_returnsSymbol() {
        Cell cell = new Cell('#', 0, 0);
        assertEquals('#', cell.getSymbol());
    }

    @Test
    @DisplayName("getX returns correct x.")
    void getX_onlyUseCase_returnsX() {
        Cell cell = new Cell(' ', 123, 0);
        assertEquals(123, cell.getX());
    }

    @Test
    @DisplayName("getY returns correct y.")
    void getY_onlyUseCase_returnsY() {
        Cell cell = new Cell(' ', 0, 321);
        assertEquals(321, cell.getY());
    }

    @Test
    @DisplayName("isStart on cell with symbol S returns true.")
    void isStart_symbolS_returnsTrue() {
        Cell cell = new Cell('S', 0, 0);
        assertTrue(cell.isStart());
    }

    @Test
    @DisplayName("isStart on cell with symbol not S returns false.")
    void isStart_symbolNotS_returnsFalse() {
        Cell cell = new Cell('#', 0, 0);
        assertFalse(cell.isStart());
    }

    @Test
    @DisplayName("isEnd on cell with symbol E returns true.")
    void isEnd_symbolE_returnsTrue() {
        Cell cell = new Cell('E', 0, 0);
        assertTrue(cell.isEnd());
    }

    @Test
    @DisplayName("isEnd on cell with symbol not E returns true.")
    void isEnd_symbolNotE_returnsFalse() {
        Cell cell = new Cell('#', 0, 0);
        assertFalse(cell.isEnd());
    }

    @Test
    @DisplayName("Wall cells are not visitable.")
    void isVisitable_wallCell_returnsFalse() {
        Cell cell = new Cell('#', 0, 0);
        assertFalse(cell.isVisitable());
    }

    @ParameterizedTest
    @DisplayName("Open, start, and end cells are visitable.")
    @MethodSource("visitableSymbols")
    void isVisitable_visitable_returnsTrue(char symbol) {
        Cell cell = new Cell(symbol, 0, 0);
        assertTrue(cell.isVisitable());
    }

    @Test
    @DisplayName("toString of Cell returns string version of symbol.")
    void toString_stringOfSymbol() {
        Cell cell = new Cell('#', 0, 0);
        assertEquals("#", cell.toString());
    }
}
