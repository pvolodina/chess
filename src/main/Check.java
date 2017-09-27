package main;

public class Check extends Board {
    private Board board;

    /**
     * Constructor for the Check class
     */
    public Check(boolean custom) {
        board = new Board();
        board.initPieces(board, custom);
    }

    /**
     * Function that returns the player's King piece, and removes the piece from the board
     * @param player the player/owner of the King piece
     * @return the King piece, determines the end of the game
     */
    public Piece getKing(int player) {
        for (int i = 0; i < board.getRowSize(); i++) {
            for (int j = 0; j < board.getColSize(); j++) {
                Piece p = board.getPiece(i, j);
                if ((p != null) && (p instanceof King) && (p.getPlayer() == player)) {
                    return p;
                }
            }
        }
        return null;
    }

    /**
     * Function that checks whether the King piece is in check diagonally
     * @param piece the King piece
     * @return true/false boolean whether the King is in check
     */
    public boolean kingCheckedDiagonally(Piece piece) {
        // TODO: implement
        return false;
    }

    /**
     * Function that checks whether the King piece is in check linearly
     * @param piece the King piece
     * @return true/false boolean whether the King is in check
     */
    public boolean kingCheckedLinearly(Piece piece) {
        // TODO: implement
        return false;
    }

    /*
    Helper function for the kingCheckedByKnight function below
     */
    public boolean knightPositionCheck(int x, int y, int player) {
        Piece piece = board.getPiece(x, y);
        return (piece instanceof Knight) && (piece.getPlayer() == player);
    }

    /**
     * Function that checks whether the King piece is in check by a Knight piece
     * @param piece the Knight piece of the other player
     * @param player the other player that isn't the owner of the King piece
     * @return true/false boolean whether the King is in check
     */
    public boolean kingCheckedByKnight(Piece piece, int player) {
        int x = piece.getRow();
        int y = piece.getCol();
        if (knightPositionCheck(x + 1, y + 2, player)) { return true; }
        if (knightPositionCheck(x + 2, y + 1, player)) { return true; }
        if (knightPositionCheck(x - 1, y + 2, player)) { return true; }
        if (knightPositionCheck(x - 2, y + 1, player)) { return true; }
        if (knightPositionCheck(x + 1, y - 2, player)) { return true; }
        if (knightPositionCheck(x + 2, y - 1, player)) { return true; }
        if (knightPositionCheck(x - 1, y - 2, player)) { return true; }
        if (knightPositionCheck(x - 2, y - 1, player)) { return true; }
        return false;
    }

    /**
     * Function that checks whether the King is checked
     * @param player the player/owner of the King piece
     * @return
     */
    public boolean isChecked(int player) {
        Piece k = getKing(player);
        return kingCheckedByKnight(k, player) || kingCheckedDiagonally(k) || kingCheckedLinearly(k);
    }

    /**
     * Function that checks if there is a checkmate within the game
     * @return end of the game, other player wins
     */
    public boolean checkmate() {
        // TODO: implement
        return true;
    }

    /**
     * Function that checks if there is a stalemate within the game
     * @return end of the game, draw
     */
    public boolean stalemate() {
        // TODO: implement
        return true;
    }
}
