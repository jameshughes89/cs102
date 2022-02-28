package maze;

public class MazeEndpointsException extends RuntimeException {

    public MazeEndpointsException() {
        super();
    }

    public MazeEndpointsException(String message) {
        super(message);
    }

    public MazeEndpointsException(Throwable cause) {
        super(cause);
    }

    public MazeEndpointsException(String message, Throwable cause) {
        super(message, cause);
    }
}
