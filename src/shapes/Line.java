package shapes;
import utils.DrawUtils;
import canvas.Canvas;
import exception.IllegalDimensionException;
import exception.NoCanvasException;
import exception.OutOfCanvasException;

public class Line implements Shape {
    
    public static void createShape(Canvas canvas, String []arguments) throws IllegalDimensionException, NoCanvasException, OutOfCanvasException {
        if (canvas.isValidCanvas() == false) {
            throw new NoCanvasException("No canvas instantiated. Create canvas before drawing!");
        }
        int x1 = Integer.parseInt(arguments[0]);
        int y1 = Integer.parseInt(arguments[1]);
        int x2 = Integer.parseInt(arguments[2]);
        int y2 = Integer.parseInt(arguments[3]);
        if((x1 == x2 && y1 < y2) || (y1 == y2 && x1 < x2)) {
            DrawUtils.drawLine(canvas, x1, y1, x2, y2, 'x');
        } else {
            throw new IllegalDimensionException("Line has illegal dimensions...");
        }
    };   
}
