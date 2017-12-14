package pieces;

import game.Board;
import game.Color;
import game.Player;
import game.Tile;

/**
 * Created by Bogdan Darius on 12/10/2017.
 */
public class Rook extends Piece{

    private boolean isFirstMove;

    public Rook(Color color, int x, int y){
        super(color, x, y, true);
        this.isFirstMove = true;
    }

    @Override
    public boolean isMoveValid(Board board, int toX, int toY) {
        super.isMoveValid(board, toX, toY);

        int fromX = this.getX();
        int fromY = this.getY();

        if (!(fromX == toX || fromY == toY)) {
            return false;
        }
        return true;
    }

    @Override
    public void move(Board board, Player player, int toX, int toY) {
    }

    @Override
    public String toString() {
        return "R" + (this.getColor() == Color.BLACK ? "B " : "W ");
    }
}
