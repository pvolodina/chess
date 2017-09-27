package main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class Piece {

    // private variables that identify a chess piece
    private int player;
    private Position position;
    private Board board;

    /**
     * Constructor for the Piece class
     * @param player
     * @param position
     * @param board
     */
    public Piece(int player, Position position, Board board) {
        this.player   = player;
        this.position = position;
        this.board    = board;
    }

    // get functions
    public int getPlayer() {
        return player;
    }

    public Position getPosition() {
        return position;
    }

    public int getRow() {
        return position.getRow();
    }

    public int getCol() {
        return position.getCol();
    }

    public Board getBoard() {
        return board;
    }

    // set functions
    public void setPlayer(int player) {
        this.player = player;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    /*
    Helper function for the validMove function below
     */
    public boolean outOfBounds(int x, int y) {
        // check if position inputs are negative numbers
        if (x < 0 || y < 0) {
            return true;
        }

        // check if position inputs go out of scope of board size
        if (x > 7 || y > 7) {
            return true;
        }

        return false;
    }

    /**
     * Function that checks whether a specified position on the board is a valid position to move to
     * @param x position along the x axis of the desired position
     * @param y position along the y axis of the desired position
     * @param xi position along the x axis of the initial position
     * @param yi position along the y axis of the initial position
     * @return true/false boolean whether the move is valid
     */
    public boolean validMove(int x, int y, int xi, int yi) {
        // check if desired move is out of bounds
        if (outOfBounds(x, y)) {
            return false;
        }

        // check if desired move changed position
        if (x == xi && y == yi) {
            return false;
        }

        return true;
    }


}
