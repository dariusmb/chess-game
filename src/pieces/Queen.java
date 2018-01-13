package pieces;

import game.Board;
import game.Color;
import game.Tile;

import java.util.ArrayList;

import static java.lang.StrictMath.abs;

/**
 * Created by Bogdan Darius on 12/10/2017.
 */
public class Queen extends Piece{

    public Queen(Color color, int x, int y){
        super(color, x, y);
    }

    @Override
    public boolean isMoveValid(Tile fromTile, Tile toTile) {
        super.isMoveValid(fromTile, toTile);
        int fromX = fromTile.getX();
        int fromY = fromTile.getY();

        if(!(fromX == toTile.getX() || fromY == toTile.getY() || (abs(fromX - toTile.getX())) == abs(fromY - toTile.getY()))){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Q" + (this.getColor() == Color.BLACK ? "B" : "W");
    }

    @Override
    public ArrayList<Tile> calculatePossibleMoves(Board board) {

        this.getPossibleMoves().clear();

        Piece[] pieces = {
                new Rook(this.getColor(), this.getX(), this.getY()),
                new Bishop(this.getColor(), this.getX(), this.getY())
        };
        for(Piece piece: pieces){
            this.getPossibleMoves().addAll(piece.calculatePossibleMoves(board));
        }
        return this.getPossibleMoves();
    }
}
