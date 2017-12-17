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

    public Queen(Color color, int x, int y){
        super(color, x, y, true);
    }

    @Override
    public boolean isMoveValid(Tile toTile) {
        super.isMoveValid(toTile);

        int fromX = this.getX();
        int fromY = this.getY();

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
