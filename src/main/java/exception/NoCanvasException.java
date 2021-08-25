package exception;

public class NoCanvasException extends GenericException {
    // exception thrown for attempting to draw without valid canvas
    public NoCanvasException(String message) {
        super(message);
    }
}
