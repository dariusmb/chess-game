package pieces;

import game.Color;
import game.Tile;

/**
 * Created by Bogdan Darius on 12/10/2017.
 */
public abstract class Piece {

    private Color color;
    private Tile tile;
    private boolean isAlive;

    public Piece(Color color, Tile tile, boolean isAlive){
        this.color = color;
        this.tile  = tile;
        this.isAlive = isAlive;

    }

    public Tile getTile() {
        return tile;
    }

    public Color getColor() {
        return color;
    }


    public boolean isAlive() {
        return isAlive;
    }

    public boolean isMoveValid(Tile toTile) {

        //same coordinates
        if(this.tile.getX() == toTile.getX() && this.tile.getY() == toTile.getY()){
            return false;
        }

        if((toTile.getX() > 7 || toTile.getX() < 0) || (toTile.getY() > 7 || toTile.getY() < 0)) {
            return false;
        }

        return true;
    }

}
