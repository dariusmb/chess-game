package pieces;

import game.Board;
import game.Color;
import game.Tile;

import java.util.ArrayList;

/**
 * Created by Bogdan Darius on 12/10/2017.
 */
public abstract class Piece {
    private Color color;
    private boolean isFirstMove;
    private int x;
    private int y;
    private ArrayList<Tile> possibleMoves;

    public Piece(Color color, int x, int y){
        this.color = color;
        this.isFirstMove = true;
        this.x = x;
        this.y = y;
        this.possibleMoves = new ArrayList<>();
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


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ArrayList<Tile> getPossibleMoves() {
        return possibleMoves;
    }

    public void addPossibleMove(Tile tile) {
        this.possibleMoves.add(tile);
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

    @Override
    public String toString() {
        return "Piece{" +
                "color=" + color +
                ", isFirstMove=" + isFirstMove +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    public abstract ArrayList<Tile> calculatePossibleMoves(Board board);
}
