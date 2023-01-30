import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedIteratorTest {

    @SafeVarargs
    private <T> Node<T> makeLinkedStructure(T t1, T... ts) {
        Node<T> head = new Node<>(t1);
        Node<T> current = head;
        for (T t : ts) {
            Node<T> node = new Node<>(t);
            current.setNext(node);
            current = node;
        }
        return head;
    }

    @Nested
    class WhenEmpty {

        @Test
        void hasNext_empty_returnsFalse() {
            Node<Integer> head = null;
            Iterator<Integer> iterator = new LinkedIterator<>(head);
            assertFalse(iterator.hasNext());
        }

        @Test
        void next_empty_throwsNoSuchElementException() {
            Node<Integer> head = null;
            Iterator<Integer> iterator = new LinkedIterator<>(head);
            assertThrows(NoSuchElementException.class, () -> iterator.next());
        }
    }

    @Nested
    class WhenSingleton {
        @Test
        void hasNext_singleton_returnsTrue() {
            Node<Integer> head = makeLinkedStructure(10);
            Iterator<Integer> iterator = new LinkedIterator<>(head);
            assertTrue(iterator.hasNext());
        }

        @Test
        void next_singleton_returnsElement() {
            Node<Integer> head = makeLinkedStructure(10);
            Iterator<Integer> iterator = new LinkedIterator<>(head);
            List<Integer> list = new ArrayList<>();
            iterator.forEachRemaining(list::add);
            assertEquals(List.of(10), list);
        }
    }

    @Nested
    class WhenMany {
        @Test
        void hasNext_many_returnsTrue() {
            Node<Integer> head = makeLinkedStructure(10, 11, 12, 13, 14);
            Iterator<Integer> iterator = new LinkedIterator<>(head);
            assertTrue(iterator.hasNext());
        }

        @Test
        void next_calledMany_returnsElements() {
            Node<Integer> head = makeLinkedStructure(10, 11, 12, 13, 14);
            Iterator<Integer> iterator = new LinkedIterator<>(head);
            List<Integer> list = new ArrayList<>();
            iterator.forEachRemaining(list::add);
            assertEquals(List.of(10, 11, 12, 13, 14), list);
        }
    }
}
