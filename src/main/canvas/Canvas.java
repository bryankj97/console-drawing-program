package canvas;
import exception.IllegalDimensionException;
import exception.OutOfCanvasException;
import utils.DrawUtils;

public final class Canvas {
    private char[][] canvas;
    private int width;
    private int height;

    public Canvas(){}

    public Canvas(String[] params) throws OutOfCanvasException, IllegalDimensionException {
        int width = Integer.parseInt(params[0]);
        int height = Integer.parseInt(params[1]);

        if (width < 1 || height < 1 ) {
            throw new IllegalDimensionException("Illegal canvas dimensions. Canvas should be at least 1x1");
        } 

        this.width = width + 2;
        this.height = height + 2;
        this.canvas = new char[this.height][this.width];
    
        // draw out border
        DrawUtils.drawLine(this, 0, 0, this.width-1, 0, '-');
        DrawUtils.drawLine(this, 0, this.height-1, this.width-1, this.height-1, '-');
        DrawUtils.drawLine(this, 0, 1, 0, this.height-2, '|');
        DrawUtils.drawLine(this, this.width-1, 1, this.width-1, this.height-2, '|');
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public char getCoordinate(int x, int y) {
        return this.canvas[y][x];
    }

    public void shadeCanvas(int x, int y, char symbol) throws OutOfCanvasException {
        try {
            this.canvas[y][x] = symbol;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new OutOfCanvasException("Attempting to draw out of canvas");
        }
    }

    public boolean isValidCanvas() {
        if (this.canvas == null) {
            return false;
        } else {
            return true;
        }
    }

    public String getCanvas() {
        StringBuilder sb = new StringBuilder();
        for(int y = 0; y < this.height; y++) {
            for(int x = 0; x < this.width; x++) {
                if (this.canvas[y][x] == '\u0000') {
                    sb.append(" ");
                } else {
                    sb.append(this.canvas[y][x]);
                }
            }
            sb.append("\n");
        }
        return sb.toString().trim();
    }

}