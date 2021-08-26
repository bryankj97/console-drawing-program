# Console Drawing Program

You're given the task of writing a simple console version of a drawing program. 
At this time, the functionality of the program is quite limited but this might change in the future. 
In a nutshell, the program should work as follows:
 1. Create a new canvas
 2. Start drawing on the canvas by issuing various commands
 3. Quit

### Valid Commands

|Command              |Description
|---------------------|:------------------------------------------------- 
|**C** w h            |Should create a new canvas of width w and height h.
|**L** x1 y1 x2 y2    |Should create a new line from (x1,y1) to (x2,y2). Currently only horizontal or vertical lines are supported. Horizontal and vertical lines will be drawn using the 'x' character.
|**R** x1 y1 x2 y2    |Should create a new rectangle, whose upper left corner is (x1,y1) and lower right corner is (x2,y2). Horizontal and vertical lines will be drawn using the 'x' character.
|**B** x y c          |Should fill the entire area connected to (x,y) with "colour" c. The behavior of this is the same as that of the "bucket fill" tool in paint programs.
|**Q**                |Should quit the program.

### Assumptions ###
- Program will exit if any erroneous commands are called, and will not restart at last correct command 
- Extra parameters provided by user will be ignored (e.g if **C** 20 4 5 is provided, only **C** 20 4 will be processed)
- Shapes must be contained entirely within the canvas borders
- Valid lines should be drawn in a left to right (horizontal) and up to down (vertical) manner
- Valid rectangles should be drawn from its bottom left point (a) to its top right point (b)
```
____b
|  /|
| / |
a/__|
```

### Directory and how to run ###
- Main application can be called by running `src/main/java/App.java`
- Test files can be found in `src/test/java`, containing the relevant functional and end-to-end test cases

### Sample I/O ###

Below is a sample run of the program. User input is prefixed with enter command:
```
enter command: C 20 4
----------------------
|                    |
|                    |
|                    |
|                    |
----------------------

enter command: L 1 2 6 2
----------------------
|                    |
|xxxxxx              |
|                    |
|                    |
----------------------

enter command: L 6 3 6 4
----------------------
|                    |
|xxxxxx              |
|     x              |
|     x              |
----------------------

enter command: R 14 1 18 3
----------------------
|             xxxxx  |
|xxxxxx       x   x  |
|     x       xxxxx  |
|     x              |
----------------------

enter command: B 10 3 o
----------------------
|oooooooooooooxxxxxoo|
|xxxxxxooooooox   xoo|
|     xoooooooxxxxxoo|
|     xoooooooooooooo|
----------------------

enter command: Q
```
