import canvas.Canvas;
import exception.NoCanvasException;
import shapes.Line;
import shapes.Rectangle;
import exception.IllegalDimensionException;
import exception.OutOfCanvasException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestRectangle {

    @Test
    public void testCreateValidRectangle() throws NoCanvasException, OutOfCanvasException, IllegalDimensionException {
        String[] canvas_params = {"20", "4"};
        Canvas canvas = new Canvas(canvas_params);
        String[] line_params = {"14", "1", "18", "3"};
        Rectangle.createShape(canvas, line_params);
        assertEquals( "----------------------\n" +
                "|             xxxxx  |\n" +
                "|             x   x  |\n" +
                "|             xxxxx  |\n" +
                "|                    |\n" +
                "----------------------", canvas.getCanvas());
    };

    @Test
    public void testCreateRectangleOnBorder() throws OutOfCanvasException, IllegalDimensionException{
        String[] canvas_params = {"20", "4"};
        Canvas canvas = new Canvas(canvas_params);
        String[] line_params = {"14", "1", "21", "3"};
        assertThrows(IllegalDimensionException.class, () ->
                Rectangle.createShape(canvas, line_params));
    }

    @Test
    public void testCreateRectangleOutsideCanvas() throws OutOfCanvasException, IllegalDimensionException{
        String[] canvas_params = {"20", "4"};
        Canvas canvas = new Canvas(canvas_params);
        String[] line_params = {"14", "1", "22", "3"};
        assertThrows(OutOfCanvasException.class, () ->
                Rectangle.createShape(canvas, line_params));
    }

    @Test
    public void testCreateRectangleWithoutCanvas() throws NoCanvasException {
        String[] line_params = {"14", "1", "22", "3"};
        assertThrows(NoCanvasException.class, () ->
                Rectangle.createShape(new Canvas(), line_params));
    }

    @Test
    public void testCreateInvalidRectangle() throws OutOfCanvasException, IllegalDimensionException{
        String[] canvas_params = {"20", "4"};
        Canvas canvas = new Canvas(canvas_params);
        String[] line_params = {"14", "3", "13", "2"};
        assertThrows(IllegalDimensionException.class, () ->
                Rectangle.createShape(canvas, line_params));
    }



}