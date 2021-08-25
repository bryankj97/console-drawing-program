package shapes;
import canvas.Canvas;
import exception.IllegalDimensionException;
import exception.NoCanvasException;

public interface Shape {
    // helper function to draw shape on canvas using utils.DrawUtils helper functions
    public static void createShape(Canvas canvas, String []arguments) throws IllegalDimensionException, NoCanvasException {};
    // helper function to check if desired shape lies on border
    public static boolean isBorder(Canvas canvas, int x1, int y1, int x2, int y2) {return true;};
}
