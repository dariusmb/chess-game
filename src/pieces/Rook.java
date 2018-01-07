package pieces;

import game.Board;
import game.Color;
import game.Tile;

import java.util.ArrayList;

/**
 * Created by Bogdan Darius on 12/10/2017.
 */
public class Rook extends Piece{

    public Rook(Color color, int x, int y){
        super(color, x, y);
    }

    @Override
    public boolean isMoveValid(Tile fromTile, Tile toTile) {
        super.isMoveValid(fromTile, toTile);

        if (!(fromTile.getX() == toTile.getX() || fromTile.getY() == toTile.getY())) {
            return false;
        }

        return true;
    }


    @Override
    public String toString() {
        return "R" + (this.getColor() == Color.BLACK ? "B" : "W");
    }

    @Override
    public ArrayList<Tile> calculatePossibleMoves(Board board) {
        int row = this.getX();
        int col = this.getY();
        Tile tile;

        this.getPossibleMoves().clear();
        for(int i = row + 1; i < 8; i++){
            tile = board.getTile(i, col);
            if (tile.getPiece() == null){
                this.addPossibleMove(tile);
            } else if (tile.getPiece().getColor() != this.getColor()){
                this.addPossibleMove(tile);
                break;
            } else {
                break;
            }
        }

        for(int i = row - 1; i > -1; i--){
            tile = board.getTile(i, col);
            if (tile.getPiece() == null){
                this.addPossibleMove(tile);
            } else if (tile.getPiece().getColor() != this.getColor()){
                this.addPossibleMove(tile);
                break;
            } else {
                break;
            }
        }

        for(int i = col - 1; i > -1; i--){
            tile = board.getTile(row, i);
            if (tile.getPiece() == null){
                this.addPossibleMove(tile);
            } else if (tile.getPiece().getColor() != this.getColor()){
                this.addPossibleMove(tile);
                break;
            } else {
                break;
            }
        }

        for(int i = col + 1; i < 8; i++){
            tile = board.getTile(row, i);
            if (tile.getPiece() == null){
                this.addPossibleMove(tile);
            } else if (tile.getPiece().getColor() != this.getColor()){
                this.addPossibleMove(tile);
                break;
            } else {
                break;
            }
        }

        System.out.println(this.getPossibleMoves());
        return this.getPossibleMoves();
    }
}
