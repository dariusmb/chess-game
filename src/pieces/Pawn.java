package pieces;

import game.Board;
import game.Color;
import game.Tile;

import static java.lang.Math.abs;

/**
 * Created by Bogdan Darius on 12/10/2017.
 */
public class Pawn extends Piece{

    private boolean isFirstMove;

    public Pawn(Color color, Tile tile){
        super(color, tile, true);
        this.isFirstMove = true;
    }

    public boolean isMoveValid(Tile toTile, Board board) {
        // if color is black can only move downwards
        super.isMoveValid(toTile);

        int toY = toTile.getY();
        int toX = toTile.getX();
        int fromY = this.getTile().getY();
        int fromX = this.getTile().getX();

        if(this.getColor() == Color.BLACK){
            if(fromY  == toY && fromX + 1 == toX){
                return true;
            } else if(fromX + 2 == toX  && isFirstMove && fromY == toY && board.getTile(toX + 1, toY).isEmptyTile()){
                return true;
            } else if((fromY + 1 == toY || fromY - 1 == toY) && fromX + 1 == toX && !board.getTile(toX, toY).isEmptyTile()){
                //if there is a pawn that you can capture
                return true;
            }
        }

        // if color is black can only move upwards
        if(this.getColor() == Color.WHITE){
            if(fromX - 1 == toX && fromY  == toY){
                return true;
            } else if(fromY == toY && fromX - 2 == toX && isFirstMove && board.getTile(toX  - 1, toY).isEmptyTile()){
                return true;
            } else if((fromY + 1 == toY || fromY- 1 == toY) && fromX - 1 == toX && !board.getTile(toX, toY).isEmptyTile()){
                //if there is a pawn that you can capture
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
