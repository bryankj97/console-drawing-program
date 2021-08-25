import canvas.Canvas;
import shapes.Line;
import exception.NoCanvasException;
import exception.IllegalDimensionException;
import exception.OutOfCanvasException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestLine {

    @Test
    public void testCreateValidHorizontalLine() throws NoCanvasException, OutOfCanvasException, IllegalDimensionException {
        String[] canvas_params = {"20", "4"};
        Canvas canvas = new Canvas(canvas_params);
        String[] line_params = {"1", "1", "5", "1"};
        Line.createShape(canvas, line_params);
        assertEquals( "----------------------\n" +
                "|xxxxx               |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "----------------------", canvas.getCanvas());
    };

    @Test
    public void testCreateValidVerticalLine() throws NoCanvasException, OutOfCanvasException, IllegalDimensionException {
        String[] canvas_params = {"20", "4"};
        Canvas canvas = new Canvas(canvas_params);
        String[] line_params = {"1", "1", "1", "4"};
        Line.createShape(canvas, line_params);
        assertEquals( "----------------------\n" +
                "|x                   |\n" +
                "|x                   |\n" +
                "|x                   |\n" +
                "|x                   |\n" +
                "----------------------", canvas.getCanvas());
    };

    @Test
    public void testCreateLineOnBorder() throws OutOfCanvasException, IllegalDimensionException{
        String[] canvas_params = {"20", "4"};
        Canvas canvas = new Canvas(canvas_params);
        String[] line_params = {"1", "1", "21", "1"};
        assertThrows(IllegalDimensionException.class, () ->
                Line.createShape(canvas, line_params));
    }

    @Test
    public void testCreateLineWithoutCanvas() throws NoCanvasException {
        String[] line_params = {"1", "1", "21", "1"};
        assertThrows(NoCanvasException.class, () ->
                Line.createShape(new Canvas(), line_params));
    }

    @Test
    public void testCreateLineOutsideCanvas() throws OutOfCanvasException, IllegalDimensionException{
        String[] canvas_params = {"20", "4"};
        Canvas canvas = new Canvas(canvas_params);
        String[] line_params = {"1", "1", "22", "1"};
        assertThrows(OutOfCanvasException.class, () ->
                Line.createShape(canvas, line_params));
    }

    @Test
    public void testCreateDiagonalLine() throws OutOfCanvasException, IllegalDimensionException{
        String[] canvas_params = {"20", "4"};
        Canvas canvas = new Canvas(canvas_params);
        String[] line_params = {"1", "1", "4", "4"};
        assertThrows(IllegalDimensionException.class, () ->
                Line.createShape(canvas, line_params));
    }





}