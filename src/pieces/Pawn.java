package pieces;

import game.Board;
import game.Color;
import game.Player;
import game.Tile;

import java.util.ArrayList;

import static java.lang.Math.abs;

/**
 * Created by Bogdan Darius on 12/10/2017.
 */
public class Pawn extends Piece{

//    private boolean isFirstMove;
    private boolean jumpOneSpace;

    public Pawn(Color color, int x, int y){
        super(color, x, y);
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
            } else if(fromX + 2 == toX  && super.isFirstMove() && fromY == toY/* && board.getTile(toX + 1, toY).isEmptyTile() */){
                this.jumpOneSpace = true;
                return true;
            }
        }

        // if color is black can only move upwards
        if(this.getColor() == Color.WHITE){
            if(fromX - 1 == toX && fromY  == toY){
                this.jumpOneSpace = false;
                return true;
            } else if (fromY == toY && fromX - 2 == toX && super.isFirstMove() /* && board.getTile(toX  - 1, toY).isEmptyTile()*/){
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
//        else{
//            tryEnPassant(board,tile, direction);
//        }

        //can attack right
        tile = board.getTile(this.getX() + direction, this.getY() + 1);
        if(tile != null && tile.getPiece() != null && tile.getPiece().getColor() != this.getColor()){
            this.addPossibleMove(tile);
        }
//        else {
//            tryEnPassant(board,tile, direction);
//        }

        System.out.println(this.getPossibleMoves());
        return this.getPossibleMoves();
    }

//    public void tryEnPassant(Board board, Tile tile, int direction){
//        if(tile != null && board.getLastMove() != null && board.getLastMove().getX() == tile.getX() - direction &&
//                board.getLastMove().getY() == tile.getY() && ((Pawn)board.getLastMove().getPiece()).isJumpOneSpace()){
//            this.addPossibleMove(tile);
//        }
//    }
}
