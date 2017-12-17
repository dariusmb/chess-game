package pieces;

import game.Board;
import game.Color;
import game.Player;
import game.Tile;

/**
 * Created by Bogdan Darius on 12/10/2017.
 */
public abstract class Piece {

    private Color color;
    private int x;
    private int y;
    private boolean isAlive;
    private boolean isFirstMove;

    public Piece(Color color, int x, int y, boolean isAlive){
        this.color = color;
        this.x = x;
        this.y = y;
        this.isAlive = isAlive;
        this.isFirstMove = true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
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

    public boolean isMoveValid(Tile toTile) {

        //same coordinates
        if(this.x == toTile.getX() && this.y== toTile.getY()){
            return false;
        }

        if((toTile.getX() > 7 || toTile.getX() < 0) || (toTile.getY() > 7 || toTile.getY() < 0)) {
            return false;
        }

        return true;
    }

//    public abstract void move(Board board, Player player, int toX, int toY);

}
