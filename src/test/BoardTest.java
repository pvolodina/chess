package test;

import main.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {
    Board board;

    @Test
    // tests if pieces are initiated on board
    public void testInitBoard() throws Exception {
        board = new Board();
        board.initPieces(board, false);
        Piece p = board.getPiece(0, 0);
        assertTrue(p instanceof Rook);
        p = board.getPiece(7, 3);
        assertTrue(p instanceof King);
    }

    @Test
    public void testBadBoard() throws Exception {
        board = new Board();
        board.initPieces(board, false);
        Piece p = board.getPiece(5, 5);
        assertNull(p); // should be no piece initiated here
    }
}
