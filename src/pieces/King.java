package pieces;

import game.Color;
import game.Tile;

/**
 * Created by Bogdan Darius on 12/10/2017.
 */
public class King extends Piece{

    private boolean isFirstMove;

    public King(Color color, Tile tile){
        super(color, tile, true);
        this.isFirstMove = true;
    }

    @Override
    public boolean isMoveValid(Tile toTile) {
        super.isMoveValid(toTile);

        int fromX = this.getTile().getX();
        int fromY = this.getTile().getY();
        int toX = toTile.getX();
        int toY = toTile.getY();

        if(toX > fromX + 1 || toX < fromX - 1 || toY > fromY + 1 || fromY < fromY - 1){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "K" + (this.getColor() == Color.BLACK ? "B " : "W ");
    }
}
