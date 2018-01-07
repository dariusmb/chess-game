package pieces;

import game.Board;
import game.Color;
import game.Player;
import game.Tile;

import java.util.ArrayList;

/**
 * Created by Bogdan Darius on 12/10/2017.
 */
public class King extends Piece{

    private boolean isFirstMove;

    public King(Color color, int x, int y){
        super(color, x, y);
        this.isFirstMove = true;
    }

    @Override
    public boolean isMoveValid(Tile fromTile, Tile toTile) {
        super.isMoveValid(fromTile, toTile);

        if(toTile.getX() > fromTile.getX() + 1 || toTile.getX() < fromTile.getX() - 1
                || toTile.getY() > fromTile.getY() + 1 || toTile.getY() < fromTile.getY() - 1){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "K" + (this.getColor() == Color.BLACK ? "B" : "W");
    }

    @Override
    public ArrayList<Tile> calculatePossibleMoves(Board board) {

        this.getPossibleMoves().clear();
        int rowDirections[] = {-1, -1, -1, 0, 0, 1, 1, 1};
        int colDirections[] = {-1, 0, 1, -1, 1, -1, 0, 1};

        int kingRow = this.getX();
        int kingCol =  this.getY();
        Color color = this.getColor();

        for(int direction = 0; direction < 8; direction++){

            int row = kingRow + rowDirections[direction];
            int col = kingCol + colDirections[direction];

            if(row >= 0 && row < 8 && col >= 0 && col < 8) {
                Tile tile = board.getTile(row, col);

                if (!board.isThreatenTile(color, tile, false, true) && (tile.getPiece() == null || tile.getPiece().getColor() != color)) {
                    this.addPossibleMove(tile);
                }
            }
        }

        System.out.println(this.getPossibleMoves());
        return this.getPossibleMoves();
    }

}
