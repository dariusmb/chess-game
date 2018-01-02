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
        System.out.println(player1);
        System.out.println(player2);
        board.showPieces();
//        System.out.println(board.getTile(0, 2));
        //TODO add a try catch to treat null if tile has no piece when you want to move!!!
//        board.move(player1, board.getTile(1, 4), board.getTile(3, 4));
//        board.move(player1, board.getTile(0, 4), board.getTile(1,4));
        System.out.println(player1);
        board.showPieces();
        System.out.println();
        System.out.println(board.isThreatenTile(Color.BLACK, board.getTile(0, 4)));
//        board.move(player1, board.getTile(1, 7), board.getTile(3, 7));
//        board.move(player1, board.getTile(3, 0), board.getTile(4, 0));
//        board.move(player1, board.getTile(4, 0), board.getTile(5, 0));
//        board.move(player1, board.getTile(5, 0), board.getTile(6, 1));
//        board.move(player2, board.getTile(3, 2), board.getTile(2, 1));
//        board.showPieces();

    }
}
