package test;

import main.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.StringWriter;

import org.junit.Test;

public class BishopTest {
    Board board;

    @Test
    public void testPosition() throws Exception {
        board = new Board();
        Bishop bishop = new Bishop(1, new Position(4, 4), board);
        board.addPiece(bishop);
        Piece boardPiece = board.getPiece(4, 4);
        assertEquals(boardPiece.getPosition(), bishop.getPosition());
    }

    @Test
    public void testValidMove() throws Exception {
        board = new Board();
        Bishop bishop = new Bishop(1, new Position(1, 1), board);
        board.addPiece(bishop);
        assertTrue(bishop.canMoveTo(2, 2)); // diagonal move
        assertTrue(bishop.canMoveTo(5, 5));
    }

    @Test
    public void testInvalidMove() throws Exception {
        board = new Board();
        Bishop bishop = new Bishop(1, new Position(1, 1), board);
        board.addPiece(bishop);
        assertFalse(bishop.canMoveTo(1, 2)); // not a diagonal move
        assertFalse(bishop.canMoveTo(6, 2));
        assertFalse(bishop.canMoveTo(10, 10)); // out of bounds
    }
}