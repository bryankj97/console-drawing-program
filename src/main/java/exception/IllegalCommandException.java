package exception;

public class IllegalCommandException extends GenericException {
    // exception thrown for illegal commands on app side
    public IllegalCommandException(String message) {
        super(message);
    }
}
