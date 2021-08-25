import exception.IllegalCommandException;
import exception.IllegalDimensionException;
import exception.NoCanvasException;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestEndToEnd {

    //TESTING APP SIDE END TO END FUNCTIONALITY
    // regular case
    @Test
    public void testEndtoEnd1() {
        String userInput = String.format("C 20 4%sL 1 2 6 2%sL 6 3 6 4%sR 14 1 18 3%sB 10 3 o%sQ",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        assertDoesNotThrow(() ->
                App.main(null));
    }

    // too few parameters given
    @Test
    public void testEndtoEnd2() {
        String userInput = String.format("C 20 4%sL 1 2 6 2%sL 6 3 6 4%sR 14 1 18%sB 10 3 o%sQ",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        assertThrows(IllegalCommandException.class, () ->
                App.main(null));
    }

    //TESTING DRAWING FUNCTIONALITY

    // no canvas produced
    @Test
    public void testEndtoEnd3() {
        String userInput = String.format("L 1 2 6 2%sL 6 3 6 4%sR 14 1 18 3%sB 10 3 o%sQ",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        assertThrows(NoCanvasException.class, () ->
                App.main(null));
    }

    // shapes drawn outside canvas
    @Test
    public void testEndtoEnd4() {
        String userInput = String.format("C 20 4%sL 1 2 21 2%sL 6 3 6 4%sR 14 1 18 3%sB 10 3 o%sQ",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        assertThrows(IllegalDimensionException.class, () ->
                App.main(null));
    }

    // drawing irregular shapes
    @Test
    public void testEndtoEnd5() {
        String userInput = String.format("C 20 4%sL 1 2 6 2%sL 6 3 5 2%sR 14 1 18 3%sB 10 3 o%sQ",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        assertThrows(IllegalDimensionException.class, () ->
                App.main(null));
    }

    // illegal canvas dimensions
    @Test
    public void testEndtoEnd6() {
        String userInput = String.format("C 0 4%sL 1 2 6 2%sL 6 3 5 2%sR 14 1 18 3%sB 10 3 o%sQ",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        assertThrows(IllegalDimensionException.class, () ->
                App.main(null));
    }

}
