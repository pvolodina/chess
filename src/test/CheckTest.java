package test;

import main.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.StringWriter;

import org.junit.Test;

public class CheckTest {
    Board board;

    @Test
    // checks checkmate scenario when two pawns surround a king
    public void testCheckmate() throws Exception {
        board = new Board();
        Check check = new Check(false);
        Pawn pawn1 = new Pawn(1, new Position(4, 6), board);
        Pawn pawn2 = new Pawn(1, new Position(3, 5), board);
        King king1 = new King(1, new Position(4, 5), board);
        King king2 = new King(2, new Position(4, 7), board);
        board.addPiece(pawn1);
        board.addPiece(pawn2);
        board.addPiece(king1);
        board.addPiece(king2);
        assertFalse(check.isChecked(1));
        assertTrue("Checkmate!",check.checkmate());
    }

    @Test
    // checks stalemate condition where there's no way for either player to win
    public void testStalemate() throws Exception {
        board = new Board();
        Check check = new Check(false);
        Bishop bishop = new Bishop(1, new Position(6, 3), board);
        King king1 = new King(1, new Position(5, 6), board);
        King king2 = new King(2, new Position(3, 3), board);
        board.addPiece(bishop);
        board.addPiece(king1);
        board.addPiece(king2);
        assertTrue("Stalemate!", check.stalemate());
    }
}