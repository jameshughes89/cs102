public class EmptyCollectionException extends RuntimeException {

    public EmptyCollectionException() {
        super();
    }

    public EmptyCollectionException(String message) {
        super(message);
    }

    public EmptyCollectionException(Throwable cause) {
        super(cause);
    }

    public EmptyCollectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
