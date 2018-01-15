import game.Board;
import game.Color;
import game.State;
import org.junit.jupiter.api.Test;
import pieces.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Bogdan Darius on 1/7/2018.
 */
public class TestCastling {

    @Test
    public void testWhiteKingSideCastling(){
        Board board = new Board();

        board.initializeBoard();
        assertTrue(board.move(board.getTile(6, 4), board.getTile(4, 4)));
        assertTrue(board.move(board.getTile(1, 4), board.getTile(3, 4)));
        assertTrue(board.move(board.getTile(7, 5), board.getTile(2, 0)));
        assertTrue(board.move(board.getTile(1, 1), board.getTile(2, 0)));
        assertTrue(board.move(board.getTile(7, 6), board.getTile(5, 7)));
        assertTrue(board.move(board.getTile(1, 7), board.getTile(2, 7)));

        //the castling move
        assertTrue(board.move(board.getTile(7, 4), board.getTile(7, 6)));
        assertTrue(board.getTile(7, 6).getPiece() instanceof King);
        assertTrue(board.getTile(7, 5).getPiece() instanceof Rook);
    }

    @Test
    public void testWhiteQueenSideCastling(){
        Board board = new Board();

        board.initializeBoard();
        assertTrue(board.move(board.getTile(6, 4), board.getTile(4, 4)));
        assertTrue(board.move(board.getTile(1, 4), board.getTile(3, 4)));
        assertTrue(board.move(board.getTile(6, 3), board.getTile(4, 3)));
        assertTrue(board.move(board.getTile(1, 0), board.getTile(3, 0)));
        assertTrue(board.move(board.getTile(7, 3), board.getTile(6, 4)));
        assertTrue(board.move(board.getTile(0, 1), board.getTile(2, 0)));
        assertTrue(board.move(board.getTile(7, 2), board.getTile(6, 3)));
        assertTrue(board.move(board.getTile(0, 6), board.getTile(2, 7)));
        assertTrue(board.move(board.getTile(7, 1), board.getTile(5, 0)));
        assertTrue(board.move(board.getTile(0, 5), board.getTile(1, 4)));

        //the castling move
        assertTrue(board.move(board.getTile(7, 4), board.getTile(7, 1)));
        assertTrue(board.getTile(7, 1).getPiece() instanceof King);
        assertTrue(board.getTile(7, 2).getPiece() instanceof Rook);
    }

    @Test
    public void testBlackKingSideCastling(){
        Board board = new Board();

        board.initializeBoard();

        assertTrue(board.move(board.getTile(6, 4), board.getTile(4, 4)));
        assertTrue(board.move(board.getTile(1, 4), board.getTile(3, 4)));
        assertTrue(board.move(board.getTile(7, 5), board.getTile(2, 0)));
        assertTrue(board.move(board.getTile(0, 5), board.getTile(1, 4)));
        assertTrue(board.move(board.getTile(7, 6), board.getTile(5, 7)));
        assertTrue(board.move(board.getTile(0, 6), board.getTile(2, 7)));
        assertTrue(board.move(board.getTile(6, 0), board.getTile(4, 0)));

        //the castling move
        assertTrue(board.move(board.getTile(0, 4), board.getTile(0, 6)));
        assertTrue(board.getTile(0, 6).getPiece() instanceof King);
        assertTrue(board.getTile(0, 5).getPiece() instanceof Rook);
    }

    @Test
    public void testBlackQueenSideCastling(){
        Board board = new Board();

        board.initializeBoard();
        assertTrue(board.move(board.getTile(6, 4), board.getTile(4, 4)));
        assertTrue(board.move(board.getTile(1, 3), board.getTile(3, 3)));
        assertTrue(board.move(board.getTile(6, 3), board.getTile(5, 3)));
        assertTrue(board.move(board.getTile(0, 2), board.getTile(2, 4)));
        assertTrue(board.move(board.getTile(6, 7), board.getTile(4, 7)));
        assertTrue(board.move(board.getTile(0, 3), board.getTile(2, 3)));
        assertTrue(board.move(board.getTile(7, 6), board.getTile(5, 5)));
        assertTrue(board.move(board.getTile(0, 1), board.getTile(2, 0)));
        assertTrue(board.move(board.getTile(6, 0), board.getTile(5, 0)));

        //the castling move
        assertTrue(board.move(board.getTile(0, 4), board.getTile(0, 1)));
        assertTrue(board.getTile(0, 1).getPiece() instanceof King);
        assertTrue(board.getTile(0, 2).getPiece() instanceof Rook);
    }

    @Test
    public void testBishopThreatTile(){
        Board board = new Board();

        King blackKing = new King(Color.BLACK, 0, 4);
        King whiteKing = new King(Color.WHITE, 7, 4);

        board.getTile(7, 4).setPiece(whiteKing);
        board.getTile(0, 4).setPiece(blackKing);
        board.getTile(7, 7).setPiece(new Rook(Color.WHITE, 7, 7));
        board.getTile(5, 4).setPiece(new Bishop(Color.BLACK, 5, 4));
        board.getBlackPlayer().setKing(blackKing);
        board.getWhitePlayer().setKing(whiteKing);

        //Can't castle because a tile between the king and the rook is threatened by a Bishop
        assertFalse(board.move(board.getTile(7, 4), board.getTile(7, 6)));
    }

    @Test
    public void testPawnThreatTile(){
        Board board = new Board();

        King blackKing = new King(Color.BLACK, 0, 4);
        King whiteKing = new King(Color.WHITE, 7, 4);

        board.getTile(7, 4).setPiece(whiteKing);
        board.getTile(0, 4).setPiece(blackKing);
        board.getTile(7, 7).setPiece(new Rook(Color.WHITE, 7, 7));
        board.getTile(6, 6).setPiece(new Pawn(Color.BLACK, 6, 6));
        board.getBlackPlayer().setKing(blackKing);
        board.getWhitePlayer().setKing(whiteKing);

        //Can't castle because a tile between the king and the rook is threatened by a Pawn
        assertFalse(board.move(board.getTile(7, 4), board.getTile(7, 6)));
    }

    @Test
    public void testCheck(){
        Board board = new Board();

        King blackKing = new King(Color.BLACK, 0, 4);
        King whiteKing = new King(Color.WHITE, 7, 4);

        board.getTile(7, 4).setPiece(whiteKing);
        board.getTile(0, 4).setPiece(blackKing);
        board.getTile(7, 7).setPiece(new Rook(Color.WHITE, 7, 7));
        board.getTile(4, 3).setPiece(new Bishop(Color.BLACK, 4, 3));
        board.getBlackPlayer().setKing(blackKing);
        board.getWhitePlayer().setKing(whiteKing);
        board.setCurrentPlayer(board.getBlackPlayer());
        assertTrue(board.move(board.getTile(4, 3), board.getTile(5, 2)));
        assertTrue(board.getState() == State.CHECK);
        //Can't castle because a tile between the king and the rook is threatened by a Pawn
        assertFalse(board.move(board.getTile(7, 4), board.getTile(7, 6)));
    }
}
