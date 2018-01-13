import game.Board;
import game.Color;
import game.State;
import org.junit.jupiter.api.Test;
import pieces.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Bogdan Darius on 1/6/2018.
 */
public class TestStaleMate {

    @Test
    public void testPolgarTruongStaleMate(){
        Board board = new Board();
        King blackKing = new King(Color.BLACK, 0, 7);
        King whiteKing = new King(Color.WHITE, 1, 4);

        board.getTile(0, 7).setPiece(blackKing);
        board.getTile(2, 6).setPiece(new Queen(Color.WHITE,2, 6));
        board.getTile(1, 4).setPiece(whiteKing);
        board.getBlackPlayer().setKing(blackKing);
        board.getWhitePlayer().setKing(whiteKing);
        assertTrue(board.move(board.getCurrentPlayer(), board.getTile(1, 4), board.getTile(1, 5)));
        assertTrue(board.getState() == State.STALEMATE);
    }

    @Test
    public void testAnandKramnikStaleMate(){
        Board board = new Board();
        King blackKing = new King(Color.BLACK, 4, 4);
        King whiteKing = new King(Color.WHITE, 3, 7);

        board.getTile(1, 6).setPiece(new Pawn(Color.BLACK, 1, 6));
        board.getTile(2, 5).setPiece(new Pawn(Color.BLACK, 2, 5));
        board.getTile(3, 5).setPiece(new Pawn(Color.WHITE, 3, 5));
        board.getTile(4, 7).setPiece(new Pawn(Color.WHITE, 4, 7));
        board.getTile(4, 4).setPiece(blackKing);
        board.getTile(3, 7).setPiece(whiteKing);
        board.getWhitePlayer().setKing(whiteKing);
        board.getBlackPlayer().setKing(blackKing);
        board.setCurrentPlayer(board.getBlackPlayer());
        assertTrue(board.move(board.getCurrentPlayer(), board.getTile(4, 4), board.getTile(3, 5)));
        assertTrue(board.getState() == State.STALEMATE);
    }

    @Test
    public void testKorchnoiKarpovStaleMate(){
        Board board = new Board();
        King blackKing = new King(Color.BLACK, 1, 7);
        King whiteKing = new King(Color.WHITE, 1, 5);

        board.getTile(1, 7).setPiece(blackKing);
        board.getTile(1, 5).setPiece(whiteKing);
        board.getTile(4, 0).setPiece(new Pawn(Color.BLACK, 4, 0));
        board.getTile(5, 0).setPiece(new Pawn(Color.WHITE, 5, 0));
        board.getTile(5, 2).setPiece(new Bishop(Color.WHITE, 5, 2));
        board.getBlackPlayer().setKing(blackKing);
        board.getWhitePlayer().setKing(whiteKing);
        board.setCurrentPlayer(board.getWhitePlayer());
        assertTrue(board.move(board.getCurrentPlayer(), board.getTile(5, 2), board.getTile(1, 6)));
        assertTrue(board.getState() == State.STALEMATE);
    }

    @Test
    public void testBernsteinSmyslovStaleMate(){
        Board board = new Board();
        King blackKing = new King(Color.BLACK, 3, 5);
        King whiteKing = new King(Color.WHITE, 6, 4);

        board.getTile(3, 5).setPiece(blackKing);
        board.getTile(6, 4).setPiece(whiteKing);
        board.getTile(5, 1).setPiece(new Pawn(Color.BLACK, 5, 1));
        board.getTile(4, 5).setPiece(new Pawn(Color.BLACK, 4, 5));
        board.getTile(0, 1).setPiece(new Rook(Color.WHITE, 0, 1));
        board.getTile(5, 7).setPiece(new Rook(Color.BLACK, 5, 7));
        board.getWhitePlayer().setKing(whiteKing);
        board.getBlackPlayer().setKing(blackKing);
        board.setCurrentPlayer(board.getBlackPlayer());
        assertTrue(board.move(board.getCurrentPlayer(), board.getTile(5, 1), board.getTile(6, 1)));
        assertTrue(board.move(board.getCurrentPlayer(), board.getTile(0 ,1), board.getTile(6, 1)));
        assertTrue(board.move(board.getCurrentPlayer(), board.getTile(5, 7), board.getTile(6, 7)));
        assertTrue(board.getState() == State.CHECK);
        assertTrue(board.move(board.getCurrentPlayer(), board.getTile(6, 4), board.getTile(5, 5)));
        assertTrue(board.move(board.getCurrentPlayer(), board.getTile(6, 7), board.getTile(6, 1)));
        assertTrue(board.getState() == State.STALEMATE);
    }

    @Test
    public void testMatulovicMinevStaleMate(){
        Board board = new Board();
        King whiteKing = new King(Color.WHITE, 5, 6);
        King blackKing = new King(Color.BLACK, 3, 5);

        board.getTile(5, 6).setPiece(whiteKing);
        board.getTile(3, 5).setPiece(blackKing);
        board.getTile(2, 0).setPiece(new Pawn(Color.WHITE, 2, 0));
        board.getTile(2, 1).setPiece(new Rook(Color.WHITE, 2, 1));
        board.getTile(5, 5).setPiece(new Pawn(Color.WHITE, 5, 5));
        board.getTile(6, 0).setPiece(new Rook(Color.BLACK, 6, 0));
        board.getWhitePlayer().setKing(whiteKing);
        board.getBlackPlayer().setKing(blackKing);
        board.setCurrentPlayer(board.getWhitePlayer());
        assertTrue(board.move(board.getCurrentPlayer(), board.getTile(2, 1), board.getTile(2, 2)));
        assertTrue(board.move(board.getCurrentPlayer(), board.getTile(3, 5), board.getTile(3, 6)));
        assertTrue(board.move(board.getCurrentPlayer(), board.getTile(5, 6), board.getTile(5, 7)));
        assertTrue(board.move(board.getCurrentPlayer(), board.getTile(3, 6), board.getTile(3, 7)));
        assertTrue(board.move(board.getCurrentPlayer(), board.getTile(5, 5), board.getTile(4, 5)));
        assertTrue(board.move(board.getCurrentPlayer(), board.getTile(6, 0), board.getTile(2, 0)));
        board.move(board.getCurrentPlayer(), board.getTile(2, 2), board.getTile(2, 0));
        assertTrue(board.getState() == State.STALEMATE);
    }
}
