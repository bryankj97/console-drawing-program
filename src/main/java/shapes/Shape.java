package shapes;
import canvas.Canvas;
import exception.IllegalDimensionException;
import exception.NoCanvasException;

public interface Shape {
    public static void createShape(Canvas canvas, String []arguments) throws IllegalDimensionException, NoCanvasException {};
}
