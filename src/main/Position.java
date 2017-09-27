package main;

public class Position {

    // private variables - the row/column position of a piece
    private int row;
    private int col;

    public Position() {
        // initialize the row/col positions
        row = 0;
        col = 0;
    }

    public Position(int x, int y) {
        row = x;
        col = y;
    }

    // get the x axis position
    public int getRow() {
        return row;
    }

    // get the y axis position
    public int getCol() {
        return col;
    }
}