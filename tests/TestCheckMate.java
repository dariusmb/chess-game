import game.Board;
import game.Color;
import game.Tile;
import org.junit.jupiter.api.Test;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Rook;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Bogdan Darius on 1/4/2018.
 */
public class TestCheckMate {

    @Test
    public void testFoolsMate(){

        final Board board = new Board();

        board.initializeBoard();
        assertTrue(board.move(board.getCurrentPlayer(), board.getTile(6, 5), board.getTile(5, 5)));
        assertTrue(board.move(board.getCurrentPlayer(), board.getTile(1, 4), board.getTile(3, 4)));
        assertTrue(board.move(board.getCurrentPlayer(), board.getTile(6, 6), board.getTile(4, 6)));
        assertTrue(board.move(board.getCurrentPlayer(), board.getTile(0, 3), board.getTile(4, 7)));
        assertTrue(board.isCheckMate());
    }

    @Test
    public void testScholarsMate(){
        final Board board = new Board();

        board.initializeBoard();
        assertTrue(board.move(board.getCurrentPlayer(), board.getTile(6, 4), board.getTile(4, 4)));
        assertTrue(board.move(board.getCurrentPlayer(), board.getTile(1, 4), board.getTile(3, 4)));
        assertTrue(board.move(board.getCurrentPlayer(), board.getTile(7, 5), board.getTile(4, 2)));
        assertTrue(board.move(board.getCurrentPlayer(), board.getTile(0, 1), board.getTile(2, 2)));
        assertTrue(board.move(board.getCurrentPlayer(), board.getTile(7, 3), board.getTile(3, 7)));
        assertTrue(board.move(board.getCurrentPlayer(), board.getTile(0, 6), board.getTile(2, 5)));
        assertTrue(board.move(board.getCurrentPlayer(), board.getTile(3, 7), board.getTile(1, 5)));
        assertTrue(board.isCheckMate());
    }

    @Test
    public void testLegalsMate(){
        final Board board = new Board();

        board.initializeBoard();
        assertTrue(board.move(board.getCurrentPlayer(), board.getTile(6, 4), board.getTile(4, 4)));
        assertTrue(board.move(board.getCurrentPlayer(), board.getTile(1, 4), board.getTile(3, 4)));
        assertTrue(board.move(board.getCurrentPlayer(), board.getTile(7, 6), board.getTile(5, 5)));
        assertTrue(board.move(board.getCurrentPlayer(), board.getTile(0, 1), board.getTile(2, 2)));
        assertTrue(board.move(board.getCurrentPlayer(), board.getTile(7, 5), board.getTile(4, 2)));
        assertTrue(board.move(board.getCurrentPlayer(), board.getTile(1, 3), board.getTile(2, 3)));
        assertTrue(board.move(board.getCurrentPlayer(), board.getTile(7, 1), board.getTile(5, 2)));
        assertTrue(board.move(board.getCurrentPlayer(), board.getTile(0, 2), board.getTile(4, 6)));
        assertTrue(board.move(board.getCurrentPlayer(), board.getTile(5, 5), board.getTile(3, 4)));
        assertTrue(board.move(board.getCurrentPlayer(), board.getTile(4, 6), board.getTile(7, 3)));
        assertTrue(board.move(board.getCurrentPlayer(), board.getTile(4, 2), board.getTile(1, 5)));
        assertTrue(board.isCheck());
        assertTrue(board.move(board.getCurrentPlayer(), board.getTile(0, 4), board.getTile(1, 4)));
        assertTrue(board.move(board.getCurrentPlayer(), board.getTile(5, 2), board.getTile(3, 3)));
        assertTrue(board.isCheckMate());
    }

    @Test
    public void testAnastasiaMate(){

        final Board board = new Board();

        board.getTile(1, 7).setPiece(new King(Color.BLACK));
        board.getTile(1, 6).setPiece(new Pawn(Color.BLACK));
        board.getTile(1, 4).setPiece(new Knight(Color.WHITE));
        board.getTile(5, 0).setPiece(new Rook(Color.WHITE));
        board.getTile(7, 1).setPiece(new King(Color.WHITE));
        board.getWhitePlayer().setKingTile(board.getTile(7, 0));
        board.getBlackPlayer().setKingTile(board.getTile(1, 7));
        assertTrue(board.move(board.getWhitePlayer(), board.getTile(5, 0), board.getTile(5, 7)));
        assertTrue(board.isCheckMate());
    }

    @Test
    public void testAnderssenMate(){

        final Board board = new Board();

        board.getTile(7, 7).setPiece(new Rook(Color.WHITE));
        board.getTile(1, 6).setPiece(new Pawn(Color.WHITE));
        board.getTile(2, 5).setPiece(new King(Color.WHITE));
        board.getTile(0, 6).setPiece(new King(Color.BLACK));
        board.getWhitePlayer().setKingTile(board.getTile(2, 5));
        board.getBlackPlayer().setKingTile(board.getTile(0, 6));
        assertTrue(board.move(board.getWhitePlayer(), board.getTile(7, 7), board.getTile(0, 7)));
        assertTrue(board.isCheckMate());
    }
}
