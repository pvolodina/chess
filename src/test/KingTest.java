package test;

import main.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.StringWriter;

import org.junit.Test;

public class KingTest {
    Board board;

    @Test
    public void testPosition() throws Exception {
        board = new Board();
        King king = new King(1, new Position(4, 4), board);
        board.addPiece(king);
        Piece boardPiece = board.getPiece(4, 4);
        assertEquals(boardPiece.getPosition(), king.getPosition());
    }

    @Test
    public void testValidMove() throws Exception {
        board = new Board();
        King king = new King(1, new Position(1, 1), board);
        board.addPiece(king);
        assertTrue(king.canMoveTo(1, 2));
        assertTrue(king.canMoveTo(2, 2));
        assertTrue(king.canMoveTo(0, 1));
    }

    @Test
    public void testInvalidMove() throws Exception {
        board = new Board();
        King king = new King(1, new Position(1, 1), board);
        board.addPiece(king);
        assertFalse(king.canMoveTo(3, 3)); // diagonal multiple steps
        assertFalse(king.canMoveTo(6, 2));
        assertFalse(king.canMoveTo(10, 10));
    }
}