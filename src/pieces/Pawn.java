package pieces;

import game.Board;
import game.Color;
import game.Player;
import game.Tile;

import static java.lang.Math.abs;

/**
 * Created by Bogdan Darius on 12/10/2017.
 */
public class Pawn extends Piece{

//    private boolean isFirstMove;
    private boolean jumpOneSpace;

    public Pawn(Color color){
        super(color, true);
//        this.isFirstMove = true;
    }

    public boolean isMoveValid(Tile fromTile, Tile toTile) {
        // if color is black can only move downwards
        super.isMoveValid(fromTile, toTile);

        int fromY = fromTile.getY();
        int fromX = fromTile.getX();
        int toX = toTile.getX();
        int toY = toTile.getY();

        if(this.getColor() == Color.BLACK){
            if(fromY  == toY && fromX + 1 == toX){
                this.jumpOneSpace = false;
                return true;
            } else if(fromX + 2 == toX  && isFirstMove && fromY == toY/* && board.getTile(toX + 1, toY).isEmptyTile() */){
                this.jumpOneSpace = true;
                return true;
            }
        }

        // if color is black can only move upwards
        if(this.getColor() == Color.WHITE){
            if(fromX - 1 == toX && fromY  == toY){
                this.jumpOneSpace = false;
                return true;
            } else if (fromY == toY && fromX - 2 == toX && isFirstMove /* && board.getTile(toX  - 1, toY).isEmptyTile()*/){
                this.jumpOneSpace = true;
                return true;
           }
        }

        return false;
    }

    public boolean isJumpOneSpace() {
        return jumpOneSpace;
    }

    public void setJumpOneSpace(boolean jumpOneSpace) {
        this.jumpOneSpace = jumpOneSpace;
    }

    @Override
    public String toString() {
        return "P" + (this.getColor() == Color.BLACK ? "B " : "W ");
    }
}
