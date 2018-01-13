package pieces;

import game.Board;
import game.Color;
import game.Tile;

import java.util.ArrayList;

import static java.lang.StrictMath.abs;

/**
 * Created by Bogdan Darius on 12/10/2017.
 */
public class Bishop  extends Piece{


    public Bishop(Color color, int x, int y){
        super(color, x, y);
    }

    @Override
    public boolean isMoveValid(Tile fromTile, Tile toTile) {
        super.isMoveValid(fromTile, toTile);

        if (!(abs(fromTile.getX() - toTile.getX()) == abs(fromTile.getY() - toTile.getY()))){
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "B" + (this.getColor() == Color.BLACK ? "B" : "W");
    }

    @Override
    public ArrayList<Tile> calculatePossibleMoves(Board board) {

        this.getPossibleMoves().clear();
        int row = this.getX();
        int col = this.getY();
        Tile tile;

        for(int j = col + 1,  i = row + 1; j < 8 && i < 8; j++, i++){
            tile = board.getTile(i, j);
            if (tile.getPiece() == null){
                this.addPossibleMove(tile);
            } else if (tile.getPiece().getColor() != this.getColor()){
                this.addPossibleMove(tile);
                break;
            } else {
                break;
            }
        }

        for(int j = col - 1, i = row + 1; j > -1 && i < 8; j--, i++){
            tile = board.getTile(i, j);
            if (tile.getPiece() == null){
                this.addPossibleMove(tile);
            } else if (tile.getPiece().getColor() != this.getColor()){
                this.addPossibleMove(tile);
                break;
            } else {
                break;
            }
        }

        for(int j = col + 1, i = row - 1; j < 8 && i > -1; j++, i--){
            tile = board.getTile(i, j);
            if (tile.getPiece() == null){
                this.addPossibleMove(tile);
            } else if (tile.getPiece().getColor() != this.getColor()){
                this.addPossibleMove(tile);
                break;
            } else {
                break;
            }
        }

        for(int j = col - 1, i = row - 1; j > -1 && i > -1; j--, i--){
            tile = board.getTile(i, j);
            if (tile.getPiece() == null){
                this.addPossibleMove(tile);
            } else if (tile.getPiece().getColor() != this.getColor()){
                this.addPossibleMove(tile);
                break;
            } else {
                break;
            }
        }

        return this.getPossibleMoves();
    }
}
