package exception;

public class OutOfCanvasException extends GenericException {
    // exception thrown for attempting to shade or get coordinates outside of range of char 2D array representation
    public OutOfCanvasException(String message) {
        super(message);
    }
}
