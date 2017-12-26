package pieces;

import game.Color;
import game.Tile;

import static java.lang.StrictMath.abs;


/**
 * Created by Bogdan Darius on 12/10/2017.
 */
public class Knight extends Piece{

    public Knight(Color color){
        super(color, true);
    }

    @Override
    public boolean isMoveValid(Tile fromTile, Tile toTile) {

        super.isMoveValid(fromTile, toTile);
        if (abs(fromTile.getX() - toTile.getX()) == 2 && abs(fromTile.getY() - toTile.getY()) == 1){
            return true;
        } else if(abs(fromTile.getX() - toTile.getX()) == 1 && abs(fromTile.getY() - toTile.getY()) == 2){
            return true;
        }
        System.out.println("false");
        return false;
    }



    @Override
    public String toString() {
        return "Kn" + (this.getColor() == Color.BLACK ? "B " : "W ");
    }


}
