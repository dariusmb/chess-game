import game.Board;
import game.Color;
import game.Player;
import pieces.Knight;
import pieces.Pawn;

/**
 * Created by Bogdan Darius on 12/13/2017.
 */
public class Main {
    public static Board board = new Board();

    public static void main(String[] args) {
        Player player1 = new Player(Color.BLACK, "Darius");
        Player player2 = new Player(Color.WHITE, "Vlad");

        board.initializeBoard(player1, player2);
        board.showPieces();
        System.out.println(board.getTile(0, 2));
        System.out.println(board.getTile(0, 2).getPiece().isMoveValid(board,2, 3));
        //TODO add a try catch to treat null if tile has no piece
        board.getTile(0, 0).getPiece().move(board, player1, 7, 0);
        board.showPieces();

    }
}
