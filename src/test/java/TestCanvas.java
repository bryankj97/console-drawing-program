import canvas.Canvas;
import exception.IllegalDimensionException;
import exception.OutOfCanvasException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestCanvas {

    private Exception IllegalDimensionException;

    @Test
    public void testCreateValidCanvas() throws OutOfCanvasException, IllegalDimensionException {
        String[] params = {"20", "4"};
        Canvas canvas = new Canvas(params);
        assertEquals( "----------------------\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "----------------------", canvas.getCanvas());
    };

    @Test
    public void testCreateInvalidCanvas() {
        String[] params = {"0", "4"};
        assertThrows(IllegalDimensionException.class, () ->
                new Canvas(params));
    }

}
