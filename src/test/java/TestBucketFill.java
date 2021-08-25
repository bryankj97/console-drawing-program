import canvas.Canvas;
import exception.NoCanvasException;
import shapes.Line;
import shapes.Rectangle;
import utils.DrawUtils;
import exception.IllegalDimensionException;
import exception.OutOfCanvasException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestBucketFill {

    public Canvas instantiateCanvas() throws NoCanvasException, OutOfCanvasException, IllegalDimensionException {
        String[] canvas_params = {"20", "4"};
        Canvas canvas = new Canvas(canvas_params);
        String[] string_params = {"1", "2", "6", "2"};
        Line.createShape(canvas, string_params);
        String[] string_params2 = {"6", "3", "6", "4"};
        Line.createShape(canvas, string_params2);
        String[] rect_params = {"14", "1", "18", "3"};
        Rectangle.createShape(canvas, rect_params);
        return canvas;
    }


    @Test
    public void testBucketFill() throws NoCanvasException, OutOfCanvasException, IllegalDimensionException {
        Canvas canvas = instantiateCanvas();
        DrawUtils.bucketFill(canvas, 10, 3, 'o');
        assertEquals( "----------------------\n" +
                "|oooooooooooooxxxxxoo|\n" +
                "|xxxxxxooooooox   xoo|\n" +
                "|     xoooooooxxxxxoo|\n" +
                "|     xoooooooooooooo|\n" +
                "----------------------", canvas.getCanvas());
    };

    @Test
    public void testBucketFillonBorder() throws NoCanvasException, OutOfCanvasException, IllegalDimensionException{
        Canvas canvas1 = instantiateCanvas();
        Canvas canvas2 = instantiateCanvas();
        DrawUtils.bucketFill(canvas2, 21, 3, 'o');
        assertEquals(canvas2.getCanvas(), canvas1.getCanvas());
    }

    @Test
    public void testBucketFillOutsideCanvas() throws NoCanvasException, OutOfCanvasException, IllegalDimensionException{
        Canvas canvas = instantiateCanvas();
        assertThrows(OutOfCanvasException.class, () ->
                DrawUtils.bucketFill(canvas, 99, 99, 'o'));
    }


}