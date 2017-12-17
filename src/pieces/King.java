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

    public King(Color color, int x, int y){
        super(color, x, y, true);
        this.isFirstMove = true;
    }

    @Override
    public boolean isMoveValid(Tile toTile) {
        super.isMoveValid(toTile);

        int fromX = this.getX();
        int fromY = this.getY();

        if(toTile.getX() > fromX + 1 || toTile.getX() < fromX - 1 || toTile.getY() > fromY + 1 || fromY < fromY - 1){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "K" + (this.getColor() == Color.BLACK ? "B " : "W ");
    }
}
