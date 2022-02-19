import org.junit.jupiter.api.BeforeEach;

public class ArrayQueueThoroughTest {

    private Queue<Integer> classUnderTest;
    private Queue<Integer> preState;

    @BeforeEach
    void newQueue() {
        classUnderTest = new ArrayQueue<>();
        preState = new ArrayQueue<>();
    }
}
