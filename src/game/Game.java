package game;

/**
 * Created by Bogdan Darius on 12/13/2017.
 */
public class Game {

    Player player1;
    Player player2;
    Player currentPlayer;
    Board board;

    Game(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
        this.board = new Board();
    }
}
