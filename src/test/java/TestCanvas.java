import canvas.Canvas;
import exception.IllegalDimensionException;
import exception.OutOfCanvasException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestCanvas {

    @Test
    public void testCanvas() throws OutOfCanvasException, IllegalDimensionException {
        String[] params = {"20", "4"};
        Canvas canvas = new Canvas(params);
        assertEquals( "----------------------\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "----------------------", canvas.getCanvas());
    }

}
