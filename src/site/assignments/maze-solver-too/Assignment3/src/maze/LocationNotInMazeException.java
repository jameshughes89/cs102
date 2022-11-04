package maze;

public class LocationNotInMazeException extends RuntimeException {

    public LocationNotInMazeException() {
        super();
    }

    public LocationNotInMazeException(String message) {
        super(message);
    }

    public LocationNotInMazeException(Throwable cause) {
        super(cause);
    }

    public LocationNotInMazeException(String message, Throwable cause) {
        super(message, cause);
    }
}
