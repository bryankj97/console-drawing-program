package shapes;
import utils.DrawUtils;
import canvas.Canvas;
import exception.IllegalDimensionException;
import exception.NoCanvasException;
import exception.OutOfCanvasException;

public class Line implements Shape {
    
    public static void createShape(Canvas canvas, String []arguments) throws IllegalDimensionException, NoCanvasException, OutOfCanvasException {
        if (!canvas.isValidCanvas()) {
            throw new NoCanvasException("No canvas instantiated. Create canvas before drawing!");
        }
        int x1 = Integer.parseInt(arguments[0]);
        int y1 = Integer.parseInt(arguments[1]);
        int x2 = Integer.parseInt(arguments[2]);
        int y2 = Integer.parseInt(arguments[3]);

        // if shape lies on border, do not draw
        if (isBorder(canvas, x1, y1, x2, y2)) {
            throw new IllegalDimensionException("Line cannot be drawn on border");
        }

        // for a valid line, it should be created in a left to right or up to down manner
        if((x1 == x2 && y1 < y2) || (y1 == y2 && x1 < x2)) {
            DrawUtils.drawLine(canvas, x1, y1, x2, y2, 'x');
        } else {
            throw new IllegalDimensionException("Line has illegal dimensions. Only vertical and horizontal lines are supported");
        }
    };

    public static boolean isBorder(Canvas canvas, int x1, int y1, int x2, int y2) {
        int w_border = canvas.getWidth() - 1;
        int h_border = canvas.getHeight() - 1;
        if (x1 == 0 || x2 == 0 || y1 == 0 || y2 == 0 ||
                x1 == w_border || x2 == w_border || y1 == h_border || y2 == h_border) {
            return true;
        } else {
            return false;
        }
    };
}
