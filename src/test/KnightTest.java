package test;

import main.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.StringWriter;

import org.junit.Test;

public class KnightTest {
    Board board;

    @Test
    public void testPosition() throws Exception {
        board = new Board();
        Knight knight = new Knight(1, new Position(4, 4), board);
        board.addPiece(knight);
        Piece boardPiece = board.getPiece(4, 4);
        assertEquals(boardPiece.getPosition(), knight.getPosition());
    }

    @Test
    public void testValidMove() throws Exception {
        board = new Board();
        Knight knight = new Knight(1, new Position(1, 1), board);
        board.addPiece(knight);
        assertTrue(knight.canMoveTo(2, 3)); // L shape
        assertTrue(knight.canMoveTo(3, 2));
    }

    @Test
    public void testInvalidMove() throws Exception {
        board = new Board();
        Knight knight = new Knight(1, new Position(1, 1), board);
        board.addPiece(knight);
        assertFalse(knight.canMoveTo(2, 2)); // diagonal move
        assertFalse(knight.canMoveTo(3, 3));
        assertFalse(knight.canMoveTo(1, 1)); // stay in place
    }
}