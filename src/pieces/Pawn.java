package pieces;

import game.Board;
import game.Color;
import game.Tile;

import java.util.ArrayList;


/**
 * Created by Bogdan Darius on 12/10/2017.
 */
public class Pawn extends Piece{

    private boolean jumpOneSpace;

    public Pawn(Color color, int x, int y){
        super(color, x, y);
    }

    public boolean isMoveValid(Tile fromTile, Tile toTile) {
        // if color is black can only move downwards
        super.isMoveValid(fromTile, toTile);

        int fromY = fromTile.getY();
        int fromX = fromTile.getX();
        int toX = toTile.getX();
        int toY = toTile.getY();
        int offset;

        if(this.getColor() == Color.BLACK){
            offset = 1;
        } else {
            offset = -1;
        }

        if(fromY  == toY && fromX + offset == toX){
            this.jumpOneSpace = false;
            return true;
        } else if(fromX + 2 * offset == toX  && super.isFirstMove() && fromY == toY){
            this.jumpOneSpace = true;
            return true;
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
        return "P" + (this.getColor() == Color.BLACK ? "B" : "W");
    }

    @Override
    public ArrayList<Tile> calculatePossibleMoves(Board board) {
        int direction = this.getColor() == Color.WHITE ? -1 : 1;
        this.getPossibleMoves().clear();
        Tile tile = board.getTile(this.getX() + direction, this.getY());
        //can move in front
        if (tile.getPiece() == null){
            this.addPossibleMove(tile);
            //can move two spaces in first move
            if(this.isFirstMove()){
                tile = board.getTile(this.getX() + 2 * direction, this.getY());
                if (tile.getPiece() == null){
                    this.addPossibleMove(tile);
                }
            }
        }
        //can attack left
        tile = board.getTile(this.getX() + direction, this.getY() - 1);
        if(tile != null && tile.getPiece() != null && tile.getPiece().getColor() != this.getColor()){
            this.addPossibleMove(tile);
        }

        //can attack right
        tile = board.getTile(this.getX() + direction, this.getY() + 1);
        if(tile != null && tile.getPiece() != null && tile.getPiece().getColor() != this.getColor()){
            this.addPossibleMove(tile);
        }


        return this.getPossibleMoves();
    }

}
