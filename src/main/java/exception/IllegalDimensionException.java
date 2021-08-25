package exception;

public class IllegalDimensionException extends GenericException {
    // exception thrown for illegal dimensions provided for shape drawing
    // e.g unsupported shapes, shapes that extend out of canvas
    public IllegalDimensionException(String message) {
        super(message);
    }
}
