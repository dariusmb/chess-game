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

    private boolean isFirstMove;

    public Pawn(Color color){
        super(color, true);
        this.isFirstMove = true;
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
                return true;
            } else if(fromX + 2 == toX  && isFirstMove && fromY == toY/* && board.getTile(toX + 1, toY).isEmptyTile() */){
                return true;
            }
        }

        // if color is black can only move upwards
        if(this.getColor() == Color.WHITE){
            if(fromX - 1 == toX && fromY  == toY){
                return true;
            } else if (fromY == toY && fromX - 2 == toX && isFirstMove /* && board.getTile(toX  - 1, toY).isEmptyTile()*/){
                return true;
           }
        }

        return false;
    }


    @Override
    public String toString() {
        return "P" + (this.getColor() == Color.BLACK ? "B " : "W ");
    }
}
