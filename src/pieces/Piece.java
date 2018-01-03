package pieces;

import game.Board;
import game.Color;
import game.Player;
import game.Tile;

/**
 * Created by Bogdan Darius on 12/10/2017.
 */
public abstract class Piece {
//TODO remove isfirstmove from other pieces
    private Color color;
    private boolean isAlive;
    private boolean isFirstMove;

    public Piece(Color color, boolean isAlive){
        this.color = color;
        this.isAlive = isAlive;
        this.isFirstMove = true;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public boolean isFirstMove() {
        return isFirstMove;
    }

    public void setFirstMove(boolean firstMove) {
        isFirstMove = firstMove;
    }

    public Color getColor() {
        return color;
    }

    public boolean isAlive() {
        return isAlive;
    }


    public boolean isMoveValid(Tile fromTile, Tile toTile) {

        //same coordinates
        if(fromTile.getX() == toTile.getX() && fromTile.getY() == toTile.getY()){
            return false;
        }

        if((toTile.getX() > 7 || toTile.getX() < 0) || (toTile.getY() > 7 || toTile.getY() < 0)) {
            return false;
        }

        return true;
    }

//    public abstract void move(Board board, Player player, int toX, int toY);

}
