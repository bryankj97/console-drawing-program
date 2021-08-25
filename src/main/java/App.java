import java.util.Arrays;
import canvas.Canvas;
import java.util.Scanner;
import utils.DrawUtils;
import shapes.*;
import exception.*;

public class App {
    Canvas canvas;

    public App() {
        canvas = new Canvas();
    }

    public static void main(String[] args) throws Exception {
        App app = new App();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Console Drawing Program!");
        String command = new String();
        // if quit command is encountered, program is shut down
        while (!command.equals("Q")) {
            System.out.println("\nEnter command:");
            command = sc.nextLine();
            if (command.equals("Q")) {
                break;
            }
            app.execute(command);
        }
        System.out.println("See you again soon!");
        sc.close();

    }

    private void execute(String command) throws GenericException {
        String[] params = command.split(" ");
        char c = command.charAt(0);
        String[] executable_params = Arrays.copyOfRange(params, 1, params.length);

        try {
            switch(c) {
                // identify type of command [C, L, R, B]
                case 'C':
                    this.canvas = new Canvas(executable_params);
                    System.out.println(canvas.getCanvas());
                    break;
                case 'L':
                    Line.createShape(canvas, executable_params);
                    System.out.println(canvas.getCanvas());
                    break;
                case 'R':
                    Rectangle.createShape(canvas, executable_params);
                    System.out.println(canvas.getCanvas());
                    break;
                case 'B':
                    DrawUtils.bucketFill(canvas, Integer.parseInt(executable_params[0]), Integer.parseInt(executable_params[1]), executable_params[2].charAt(0));
                    System.out.println(canvas.getCanvas());
                    break;
                default:
                    // if command is illegal, exception is thrown
                    throw new IllegalCommandException("Command not recognised, Try again with C, L, R or B");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            // if too few parameters provided for a correct command, exception is thrown
            throw new IllegalCommandException("Too little number of parameters provided. Check command...");
        }

    }
}
