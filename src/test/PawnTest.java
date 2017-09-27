package test;

import main.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.StringWriter;

import org.junit.Test;
import sun.security.krb5.internal.PAData;

public class PawnTest {
    Board board;

    @Test
    public void testPosition() throws Exception {
        board = new Board();
        Pawn pawn = new Pawn(1, new Position(4, 4), board);
        board.addPiece(pawn);
        Piece boardPiece = board.getPiece(4, 4);
        assertEquals(boardPiece.getPosition(), pawn.getPosition());
    }

    @Test
    public void testValidMove() throws Exception {
        board = new Board();
        Pawn pawn = new Pawn(1, new Position(1, 1), board);
        board.addPiece(pawn);
        assertTrue(pawn.canMoveTo(3, 1)); // first move, flag switched
        assertFalse(pawn.canMoveTo(3, 1)); // not the first move
        assertTrue(pawn.canMoveTo(2, 1)); // straight move
    }

    @Test
    public void testInvalidMove() throws Exception {
        board = new Board();
        Pawn pawn = new Pawn(1, new Position(1, 1), board);
        board.addPiece(pawn);
        assertFalse(pawn.canMoveTo(2, 2)); // diagonal move
        assertFalse(pawn.canMoveTo(1, 2)); // moving along y
        assertFalse(pawn.canMoveTo(1, 1));
    }
}