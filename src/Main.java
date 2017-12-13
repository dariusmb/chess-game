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

//        System.out.println(((Knight)board.getTile(0, 2).getPiece()).isMoveValid(2, 4));
    }
}
