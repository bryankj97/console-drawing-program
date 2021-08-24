package utils;
import canvas.Canvas;
import exception.OutOfCanvasException;

public class DrawUtils {
    
    public static void drawLine(Canvas canvas, int x1, int y1, int x2, int y2, char symbol) throws OutOfCanvasException {
        for (int y = y1; y < y2 + 1; y++) {
            for (int x = x1; x < x2 + 1; x++) {
                canvas.shadeCanvas(x, y, symbol);
            }
        }
    };

    public static void bucketFill(Canvas canvas, int x, int y, char symbol) throws OutOfCanvasException {
        if(canvas.getCoordinate(x, y) != '\u0000') {
            return;
        }
        if(x > 0 || x  < canvas.getWidth() || y > 0 || y < canvas.getHeight()) {
            if(canvas.getCoordinate(x, y) == '\u0000') {
                canvas.shadeCanvas(x, y, symbol);
            }
            bucketFill(canvas, x+1, y, symbol);
            bucketFill(canvas, x-1, y, symbol);
            bucketFill(canvas, x, y-1, symbol);
            bucketFill(canvas, x, y+1, symbol);
        }
    }
}
