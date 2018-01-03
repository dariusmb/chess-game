package pieces;

import game.Board;
import game.Color;
import game.Player;
import game.Tile;

/**
 * Created by Bogdan Darius on 12/10/2017.
 */
public class King extends Piece{

    private boolean isFirstMove;

    public King(Color color){
        super(color, true);
        this.isFirstMove = true;
    }

    @Override
    public boolean isMoveValid(Tile fromTile, Tile toTile) {
        super.isMoveValid(fromTile, toTile);

        if(toTile.getX() > fromTile.getX() + 1 || toTile.getX() < fromTile.getX() - 1
                || toTile.getY() > fromTile.getY() + 1 || toTile.getY() < fromTile.getY() - 1){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "K" + (this.getColor() == Color.BLACK ? "B" : "W");
    }
}
