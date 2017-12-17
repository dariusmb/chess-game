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
    public boolean isMoveValid(Tile toTile) {
        super.isMoveValid(toTile);

        int fromX = this.getX();
        int fromY = this.getY();

        if (!(fromX == toTile.getX() || fromY == toTile.getY())) {
            return false;
        }

        return true;
    }


    @Override
    public String toString() {
        return "R" + (this.getColor() == Color.BLACK ? "B " : "W ");
    }
}
