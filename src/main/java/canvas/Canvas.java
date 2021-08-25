package canvas;
import exception.IllegalDimensionException;
import exception.OutOfCanvasException;
import utils.DrawUtils;

public final class Canvas {
    private char[][] canvas;
    private int width;
    private int height;

    // constructor for invalid canvas object
    public Canvas(){}

    // constructor for valid canvas object, with 2D char array representation
    public Canvas(String[] params) throws OutOfCanvasException, IllegalDimensionException {
        int width = Integer.parseInt(params[0]);
        int height = Integer.parseInt(params[1]);

        // canvas should be at least be 1 x 1 in dimensions to be valid
        if (width < 1 || height < 1 ) {
            throw new IllegalDimensionException("Illegal canvas dimensions. Canvas should be at least 1x1");
        } 

        // add 2 to width and height to allow for border in char 2D array representation
        this.width = width + 2;
        this.height = height + 2;
        this.canvas = new char[this.height][this.width];
    
        // draw out border using drawLine
        DrawUtils.drawLine(this, 0, 0, this.width-1, 0, '-');
        DrawUtils.drawLine(this, 0, this.height-1, this.width-1, this.height-1, '-');
        DrawUtils.drawLine(this, 0, 1, 0, this.height-2, '|');
        DrawUtils.drawLine(this, this.width-1, 1, this.width-1, this.height-2, '|');
    }

    // height getter
    public int getHeight() {
        return this.height;
    }

    // width getter
    public int getWidth() {
        return this.width;
    }

    // symbol getter at coordinate x, y in canvas char 2D array
    public char getCoordinate(int x, int y) throws OutOfCanvasException {
        try {
            return this.canvas[y][x];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new OutOfCanvasException("Point selected is out of canvas and is invalid.");
        }
    }

    // getter for string representation of canvas char 2D array
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

    // helper for filling coordinate x, y with symbol
    public void shadeCanvas(int x, int y, char symbol) throws OutOfCanvasException {
        try {
            this.canvas[y][x] = symbol;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new OutOfCanvasException("Attempting to draw out of canvas");
        }
    }

    // helper to check if canvas has valid 2D char array representation
    public boolean isValidCanvas() {
        if (this.canvas == null) {
            return false;
        } else {
            return true;
        }
    }

}