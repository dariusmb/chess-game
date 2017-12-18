package pieces;

import game.Board;
import game.Color;
import game.Player;
import game.Tile;

import static java.lang.StrictMath.abs;

/**
 * Created by Bogdan Darius on 12/10/2017.
 */
public class Queen extends Piece{

    public Queen(Color color){
        super(color, true);
    }

    @Override
    public boolean isMoveValid(Tile fromTile, Tile toTile) {
        super.isMoveValid(fromTile, toTile);

        int fromX = fromTile.getX();
        int fromY = fromTile.getY();

        if(!(fromX == toTile.getX() || fromY == toTile.getY() || (abs(fromX - toTile.getX())) == abs(fromY - toTile.getY()))){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Q" + (this.getColor() == Color.BLACK ? "B " : "W ");
    }
}
