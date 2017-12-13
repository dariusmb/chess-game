package pieces;

import game.Color;
import game.Tile;

/**
 * Created by Bogdan Darius on 12/10/2017.
 */
public class Rook extends Piece{

    private boolean isFirstMove;

    public Rook(Color color, Tile tile){
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

        if (!(fromX == toX || fromY == toY)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "R" + (this.getColor() == Color.BLACK ? "B " : "W ");
    }
}
