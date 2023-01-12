import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class BinaryNodeTest {

    @Test
    void getDate_dataNotExists_returnsNull() {
        assertNull(new BinaryNode<>().getData());
    }

    @Test
    void getLeft_leftNotExists_returnsNull() {
        assertNull(new BinaryNode<>().getLeft());
    }

    @Test
    void getRight_rightNotExists_returnsNull() {
        assertNull(new BinaryNode<>().getRight());
    }
}
