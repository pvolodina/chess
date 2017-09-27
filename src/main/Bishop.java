package main;

public class Bishop extends Piece {

    /**
     * Constructor for the Bishop class
     * @param player piece player/owner
     * @param position location of the piece on the board
     * @param board game board
     */
    public Bishop(int player, Position position, Board board) {
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

        // valid move for a bishop
        int diffx = Math.abs(currx - x);
        int diffy = Math.abs(curry - y);

        return (diffx == diffy && diffx != 0);
    }
}