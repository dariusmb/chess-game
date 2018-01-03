package pieces;

import game.Board;
import game.Color;
import game.Player;
import game.Tile;

import static java.lang.StrictMath.abs;

/**
 * Created by Bogdan Darius on 12/10/2017.
 */
public class Bishop  extends Piece{


    public Bishop(Color color){
        super(color, true);
    }

    @Override
    public boolean isMoveValid(Tile fromTile, Tile toTile) {
        super.isMoveValid(fromTile, toTile);

        if (!(abs(fromTile.getX() - toTile.getX()) == abs(fromTile.getY() - toTile.getY()))){
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "B" + (this.getColor() == Color.BLACK ? "B" : "W");
    }
}
