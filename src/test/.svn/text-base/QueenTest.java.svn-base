package test;

import main.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.StringWriter;

import org.junit.Test;

public class QueenTest {
    Board board;

    @Test
    public void testPosition() throws Exception {
        board = new Board();
        Queen queen = new Queen(1, new Position(4, 4), board);
        board.addPiece(queen);
        Piece boardPiece = board.getPiece(4, 4);
        assertEquals(boardPiece.getPosition(), queen.getPosition());
    }

    @Test
    public void testValidMove() throws Exception {
        board = new Board();
        Queen queen = new Queen(1, new Position(1, 1), board);
        board.addPiece(queen);
        assertTrue(queen.canMoveTo(1, 3));
        assertTrue(queen.canMoveTo(2, 2));
    }

    @Test
    public void testInvalidMove() throws Exception {
        board = new Board();
        Queen queen = new Queen(1, new Position(1, 1), board);
        board.addPiece(queen);
        assertFalse(queen.canMoveTo(4, 3));
        assertFalse(queen.canMoveTo(10, 10));
    }
}