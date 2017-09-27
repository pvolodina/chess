package main;

public class Pawn extends Piece {

    private boolean firstMove = true;

    /**
     * Constructor for the Pawn class
     * @param player piece player/owner
     * @param position location of the piece on the board
     * @param board game board
     */
    public Pawn(int player, Position position, Board board) {
        super(player, position, board);
    }

    /**
     * Function for checking if the piece can move to a specified (x,y) position on the board
     * @param x position along the x axis
     * @param y position along the y axis
     * @return true/false boolean whether it's a valid move
     */
    public boolean canMoveTo(int x, int y) {
        // get current position
        int currx = this.getPosition().getRow();
        int curry = this.getPosition().getCol();

        // check if desired position is out of bounds or
        if (!validMove(x, y, currx, curry)) {
            return false;
        }

        // valid move for a pawn
        int diffx = Math.abs(currx - x);
        int diffy = Math.abs(curry - y);

        // if they are attacking
        Board board = getBoard();
        if (board.getPiece(x, y) != null) {
            return (diffx == 1 && diffy == 1);
        }

        // if they are moving along y axis
        if (diffy != 0) {
            return false;
        }
        if (diffx > 2) {
            return false;
        }

        // check if it's the first move
        if (firstMove) {
            firstMove = false;
            return ((diffx == 2) || (diffx == 1));
        }
        return (diffx == 1);
    }
}