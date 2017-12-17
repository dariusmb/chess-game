package pieces;

import game.Board;
import game.Color;
import game.Player;
import game.Tile;

import static java.lang.StrictMath.abs;

/**
 * Created by Bogdan Darius on 12/10/2017.
 */
public class Bishop  extends Piece{


    public Bishop(Color color, int x, int y){
        super(color, x, y, true);
    }

    @Override
    public boolean isMoveValid(Board board, int toX, int toY) {
        super.isMoveValid(board, toX, toY);

        int fromX = this.getX();
        int fromY = this.getY();

        if (!(abs(fromX - toX) == abs(fromY - toY))){
            return false;
        }
        return true;
    }

    private boolean checkIfClearWay(Board board, int toX, int toY){
        int from;
        int to;

        if(toX != this.getX()){
            if(toX < this.getX()) {
                from = toX;
                to = this.getX();
            } else {
                to = toX;
                from = this.getX();
            }
            for(int i = from + 1; i < to; i++){
                if(board.getTile(i, toY).getPiece() != null){
                    return false;
                }
            }
        } else {
            if(toY < this.getY()) {
                from = toY;
                to = this.getY();
            } else {
                to = toY;
                from = this.getY();
            }
            for(int i = from + 1; i < to; i++){
                if(board.getTile(toX, i).getPiece() != null){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void move(Board board, Player player, int toX, int toY) {
    }

    @Override
    public String toString() {
        return "B" + (this.getColor() == Color.BLACK ? "B " : "W ");
    }
}
