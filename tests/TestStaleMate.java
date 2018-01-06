import game.Board;
import game.Color;
import org.junit.jupiter.api.Test;
import pieces.King;
import pieces.Pawn;
import pieces.Queen;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Bogdan Darius on 1/6/2018.
 */
public class TestStaleMate {

    @Test
    public void testPolgarTruongStaleMate(){
        Board board = new Board();

        board.getTile(0, 7).setPiece(new King(Color.BLACK));
        board.getTile(2, 6).setPiece(new Queen(Color.WHITE));
        board.getTile(1, 4).setPiece(new King(Color.WHITE));
        board.getBlackPlayer().setKingTile(board.getTile(0, 7));
        board.getWhitePlayer().setKingTile(board.getTile(1, 4));
        assertTrue(board.move(board.getCurrentPlayer(), board.getTile(1, 4), board.getTile(1, 5)));
        assertTrue(board.isStaleMate());
    }

    @Test
    public void testAnandKramnikStaleMate(){
        Board board = new Board();

        board.getTile(1, 6).setPiece(new Pawn(Color.BLACK));
        board.getTile(2, 5).setPiece(new Pawn(Color.BLACK));
        board.getTile(3, 5).setPiece(new Pawn(Color.WHITE));
        board.getTile(4, 7).setPiece(new Pawn(Color.WHITE));
        board.getTile(4, 4).setPiece(new King(Color.BLACK));
        board.getTile(3, 7).setPiece(new King(Color.WHITE));
        board.getWhitePlayer().setKingTile(board.getTile(3, 7));
        board.getBlackPlayer().setKingTile(board.getTile(4, 4));
        board.setCurrentPlayer(board.getBlackPlayer());
        board.move(board.getCurrentPlayer(), board.getTile(4, 4), board.getTile(3, 5));
        board.showPieces();
        assertTrue(board.isStaleMate());
    }
}
