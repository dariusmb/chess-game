package pieces;

import game.Color;
import game.Tile;

import static java.lang.StrictMath.abs;

/**
 * Created by Bogdan Darius on 12/10/2017.
 */
public class Queen extends Piece{

    public Queen(Color color, Tile tile){
        super(color, tile, true);
    }

    @Override
    public boolean isMoveValid(Tile toTile) {
        super.isMoveValid(toTile);

        int fromX = this.getTile().getX();
        int fromY = this.getTile().getY();
        int toX = toTile.getX();
        int toY = toTile.getY();

        if(!(fromX == toX || fromY == toY || (abs(fromX - toX)) == abs(fromY - toY))){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Q" + (this.getColor() == Color.BLACK ? "B " : "W ");
    }
}
