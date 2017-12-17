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


    public Bishop(Color color, int x, int y){
        super(color, x, y, true);
    }

    @Override
    public boolean isMoveValid(Tile toTile) {
        super.isMoveValid(toTile);

        int fromX = this.getX();
        int fromY = this.getY();

        if (!(abs(fromX - toTile.getX()) == abs(fromY - toTile.getY()))){
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "B" + (this.getColor() == Color.BLACK ? "B " : "W ");
    }
}
