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

    public Rook(Color color){
        super(color, true);
        this.isFirstMove = true;
    }

    @Override
    public boolean isMoveValid(Tile fromTile, Tile toTile) {
        super.isMoveValid(fromTile, toTile);

        if (!(fromTile.getX() == toTile.getX() || fromTile.getY() == toTile.getY())) {
            return false;
        }

        return true;
    }


    @Override
    public String toString() {
        return "R" + (this.getColor() == Color.BLACK ? "B " : "W ");
    }
}
