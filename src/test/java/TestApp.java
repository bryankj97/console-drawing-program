import exception.IllegalCommandException;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


public class TestApp {

    @Test
    public void testIncorrectCommand() throws IllegalCommandException{
        String userInput = String.format("X 1 2 3");
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        assertThrows(IllegalCommandException.class, () ->
                App.main(null));
    }

    @Test
    public void testIncorrectParametersProvided() {
        String userInput = String.format("C 20 4%sL 1 2",
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        assertThrows(IllegalCommandException.class, () ->
                App.main(null));
    }

    @Test
    public void testQuit() {
        String userInput = String.format("C 20 4%sQ",
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        assertDoesNotThrow(() ->
                App.main(null));
    }

    @Test
    public void testQuitAtFirstCommand() {
        String userInput = String.format("Q");
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        assertDoesNotThrow(() ->
                App.main(null));
    }



}
