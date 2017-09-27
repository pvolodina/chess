package test;

import main.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.StringWriter;

import org.junit.Test;

public class RookTest {
    Board board;

    @Test
    public void testPosition() throws Exception {
        board = new Board();
        Rook rook = new Rook(1, new Position(4, 4), board);
        board.addPiece(rook);
        Piece boardPiece = board.getPiece(4, 4);
        assertEquals(boardPiece.getPosition(), rook.getPosition());
    }

    @Test
    public void testValidMove() throws Exception {
        board = new Board();
        Rook rook = new Rook(1, new Position(1, 1), board);
        board.addPiece(rook);
        assertTrue(rook.canMoveTo(1, 6));
        assertTrue(rook.canMoveTo(4, 1));
    }

    @Test
    public void testInvalidMove() throws Exception {
        board = new Board();
        Rook rook = new Rook(1, new Position(1, 1), board);
        board.addPiece(rook);
        assertFalse(rook.canMoveTo(1, 1));
        assertFalse(rook.canMoveTo(10, 10));
    }
}