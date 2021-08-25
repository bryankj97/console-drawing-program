package shapes;
import canvas.Canvas;
import exception.IllegalDimensionException;
import exception.NoCanvasException;

public interface Shape {
    public static void createShape(Canvas canvas, String []arguments) throws IllegalDimensionException, NoCanvasException {};
    public static boolean isBorder(Canvas canvas, int x1, int y1, int x2, int y2) {return true;};
}
