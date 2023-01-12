import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryNodeTest {

    @Test
    void getData_dataNotExists_returnsNull() {
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

    @Test
    void getData_dataExists_returnsData() {
        BinaryNode<Integer> node = new BinaryNode<>();
        node.setData(10);
        assertEquals(10, node.getData());
    }

    @Test
    void getLeft_leftExists_returnsLeft() {
        BinaryNode<Integer> node = new BinaryNode<>();
        BinaryNode<Integer> leftNode = new BinaryNode<>();
        node.setLeft(leftNode);
        assertSame(leftNode, node.getLeft());
    }

    @Test
    void getRight_rightExists_returnsRight() {
        BinaryNode<Integer> node = new BinaryNode<>();
        BinaryNode<Integer> rightNode = new BinaryNode<>();
        node.setRight(rightNode);
        assertSame(rightNode, node.getRight());
    }

    @Test
    void getData_dataConstructor_returnsData() {
        assertEquals(10, new BinaryNode<>(10).getData());
    }

    @Test
    void getLeft_dataConstructor_returnsNull() {
        assertNull(new BinaryNode<>(10).getLeft());
    }

    @Test
    void getRight_dataConstructor_returnsNull() {
        assertNull(new BinaryNode<>(10).getRight());
    }
}
