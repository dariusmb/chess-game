package pieces;

import game.Board;
import game.Color;
import game.Tile;

import java.util.ArrayList;

import static java.lang.StrictMath.abs;


/**
 * Created by Bogdan Darius on 12/10/2017.
 */
public class Knight extends Piece{

    public Knight(Color color, int x, int y){
        super(color, x, y);
    }

    @Override
    public boolean isMoveValid(Tile fromTile, Tile toTile) {

        super.isMoveValid(fromTile, toTile);
        if (abs(fromTile.getX() - toTile.getX()) == 2 && abs(fromTile.getY() - toTile.getY()) == 1){
            return true;
        } else if(abs(fromTile.getX() - toTile.getX()) == 1 && abs(fromTile.getY() - toTile.getY()) == 2){
            return true;
        }
        return false;
    }



    @Override
    public String toString() {
        return "Kn" + (this.getColor() == Color.BLACK ? "B" : "W");
    }

    @Override
    public ArrayList<Tile> calculatePossibleMoves(Board board) {

        this.getPossibleMoves().clear();
        int rowDirections[] = {-2, -1, 1, 2, 2, 1, -1, -2};
        int colDirections[] = {1, 2, 2, 1, -1, -2, -2, -1};

        for(int direction = 0; direction < 8; direction++){

            int row = this.getX() + rowDirections[direction];
            int col = this.getY() + colDirections[direction];

            if(row >= 0 && row < 8 && col >= 0 && col < 8) {
                Tile tile = board.getTile(row, col);

                if(tile != null && (tile.getPiece() == null || tile.getPiece().getColor() != this.getColor())){
                    this.addPossibleMove(tile);
                }
            }
        }

        System.out.println(this.getPossibleMoves());
        return this.getPossibleMoves();
    }


}
