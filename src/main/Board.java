package main;
import main.*;

public class Board {

    private Piece [] [] cboard;
    private int rowSize = 8;
    private int colSize = 8;

    /**
     * Constructor for the game board, initializes all position on the board to null
     */
    public Board() {
        cboard = new Piece [rowSize][colSize];

        for(int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                cboard[i][j] = null;
            }
        }
    }

    /**
     * The amount of positions per row
     * @return row size
     */
    public int getRowSize() {
        return rowSize;
    }

    /**
     * The amount of positions per column
     * @return column size
     */
    public int getColSize() {
        return colSize;
    }

    /**
     * Function for getting a piece at a specified position on the board
     * @param x position on the x axis
     * @param y position on the y axis
     * @return the piece at the position, or null if there isn't a piece there
     */
    public Piece getPiece(int x, int y) {
        // check out of bound
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            return null;
        }
        return cboard[x][y];
    }

    public Piece [][] getBoard() {
        return cboard;
    }

    /**
     * Function that initializes a piece in its position
     * @param piece the desired piece to position
     */
    public void addPiece(Piece piece) {
        int px = piece.getRow();
        int py = piece.getCol();
        cboard[px][py] = piece;
    }

    /**
     * Function that moves the desired piece to a specified position
     * @param piece the piece to move
     * @param p the desired position
     */
    public void movePiece(Piece piece, Position p) {
        int x = piece.getRow();
        int y = piece.getCol();
        int px = p.getRow();
        int py = p.getCol();

        // check if the piece can move
        if (piece.validMove(x, y, px, py)) {
            // pick up the piece you want to move
            removePiece(piece);

            // if there is another piece in the destination, remove it
            if (cboard[px][py] != null) {
                removePiece(cboard[px][py]);
            }
            addPiece(piece);
            piece.setPosition(p);
        }
    }

    /**
     * Function that removes the piece from the board
     * @param piece the piece to remove
     */
    public void removePiece(Piece piece) {
        int px = piece.getRow();
        int py = piece.getCol();
        if (cboard[px][py] != null) {
            piece.setPosition(null);
            cboard[px][py] = null;
        }
    }

    /**
     * Function that checks if a diagonal move of a position is valid by
     * checking all positions along the diagonal and seeing if there is
     * any other pieces on the board
     * @param piece the piece to check the diagonal from
     * @param x the position on the x axis of the desired new position
     * @param y the position on the y axis of the desired new position
     * @return true/false boolean whether the move is valid
     */
    public boolean checkDiagonalMove(Piece piece, int x, int y) {
        int currx = piece.getRow();
        int curry = piece.getCol();

        // check if the move is actually diagonal
        int diffx = Math.abs(currx - x);
        int diffy = Math.abs(curry - y);

        if ((diffx != diffy) || diffx == 0) {
            // should not get here
            return false;
        }

        // get direction of diagonal
        int dirx = (currx - x)/diffx;
        int diry = (curry - y)/diffy;
        int steps = diffx;

        // check for pieces along diagonal
        for (int i = 1; i < steps; i++) {
            int nextx = (dirx * i) + x;
            int nexty = (diry * i) + y;
            if (cboard[nextx][nexty] != null) {
                return false;
            }
        }

        return true;
    }

    /*
    Helper function for the checkInLineMove function below
     */
    public boolean checkInLineMoveHelper(int curra, int currb, int a, int b) {
        int diffa = Math.abs(curra - a);
        int diffb = Math.abs(currb - b);

        if (diffa == 0) {
            int diry = (currb - b)/diffb;
            for (int i = 1; i < diffb; i++) {
                int nextb = (diry * i) + b;
                if (cboard[a][nextb] != null) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Function that checks if an inline move of a piece is valid by
     * checking all positions along the line and seeing if there is
     * any other pieces on the board
     * @param piece the piece to check the in-line from
     * @param x the position on the x axis of the desired new position
     * @param y the position on the y axis of the desired new position
     * @return true/false boolean whether the move is valid
     */
    public boolean checkInLineMove(Piece piece, int x, int y) {
        int currx = piece.getRow();
        int curry = piece.getCol();

        // check if the move is actually in line
        int diffx = Math.abs(currx - x);
        int diffy = Math.abs(curry - y);

        if (diffx == 0 && diffy == 0) { return false; }

        if (checkInLineMoveHelper(currx, curry, x, y)) { return false; }
        
        if (checkInLineMoveHelper(curry, currx, y, x)) { return false; }

        return true;
    }

    /*
    The next several functions below are helper functions to initialize all the pieces
    on the board at the beginning of a new game
     */


    public void setPawns(Board board, boolean custom) {
        for (int i = 0; i < getRowSize(); i++) {
            Pawn pawn1 = new Pawn(1, new Position(1, i), board);
            Pawn pawn2 = new Pawn(2, new Position(6, i), board);
            board.addPiece(pawn1);
            board.addPiece(pawn2);
        }
        if (custom) {
            board.removePiece(board.getPiece(1, 0));
            board.removePiece(board.getPiece(6, 0));
            board.removePiece(board.getPiece(1, 7));
            board.removePiece(board.getPiece(6, 7));
            SpecialBeep beep1 = new SpecialBeep(1, new Position(1, 0), board);
            SpecialBoop boop1 = new SpecialBoop(1, new Position(1, 7), board);
            SpecialBeep beep2 = new SpecialBeep(2, new Position(6, 0), board);
            SpecialBoop boop2 = new SpecialBoop(2, new Position(6, 7), board);
            board.addPiece(beep1);
            board.addPiece(beep2);
            board.addPiece(boop1);
            board.addPiece(boop2);
        }
    }

    public void setBishops(Board board) {
        Bishop bishop1 = new Bishop(1, new Position(0, 2), board);
        Bishop bishop2 = new Bishop(1, new Position(0, 5), board);
        Bishop bishop3 = new Bishop(2, new Position(7, 2), board);
        Bishop bishop4 = new Bishop(2, new Position(7, 5), board);
        board.addPiece(bishop1);
        board.addPiece(bishop2);
        board.addPiece(bishop3);
        board.addPiece(bishop4);
    }

    public void setKings(Board board) {
        King king1 = new King(1, new Position(0, 4), board);
        King king2 = new King(2, new Position(7, 3), board);
        board.addPiece(king1);
        board.addPiece(king2);
    }

    public void setKnights(Board board) {
        Knight knight1 = new Knight(1, new Position(0, 1), board);
        Knight knight2 = new Knight(1, new Position(0, 6), board);
        Knight knight3 = new Knight(2, new Position(7, 1), board);
        Knight knight4 = new Knight(2, new Position(7, 6), board);
        board.addPiece(knight1);
        board.addPiece(knight2);
        board.addPiece(knight3);
        board.addPiece(knight4);
    }

    public void setQueens(Board board) {
        Queen queen1 = new Queen(1, new Position(0, 3), board);
        Queen queen2 = new Queen(2, new Position(7, 4), board);
        board.addPiece(queen1);
        board.addPiece(queen2);
    }

    public void setRooks(Board board) {
        Rook rook1 = new Rook(1, new Position(0, 0), board);
        Rook rook2 = new Rook(1, new Position(0, 7), board);
        Rook rook3 = new Rook(2, new Position(7, 0), board);
        Rook rook4 = new Rook(2, new Position(7, 7), board);
        board.addPiece(rook1);
        board.addPiece(rook2);
        board.addPiece(rook3);
        board.addPiece(rook4);
    }


    /**
     * Initializer function that sets up the chess game board with all the pieces
     * @param board the game board to initialize
     */
    public void initPieces(Board board, boolean custom) {
        setBishops(board);
        setKings(board);
        setKnights(board);
        setPawns(board, custom);
        setQueens(board);
        setRooks(board);
    }

}