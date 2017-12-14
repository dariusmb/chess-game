package pieces;

import game.Board;
import game.Color;
import game.Player;
import game.Tile;

/**
 * Created by Bogdan Darius on 12/10/2017.
 */
public class Rook extends Piece{

    private boolean isFirstMove;

    public Rook(Color color, int x, int y){
        super(color, x, y, true);
        this.isFirstMove = true;
    }


    public boolean checkIfClearWay(Board board, int toX, int toY){
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
    public boolean isMoveValid(Board board, int toX, int toY) {
        super.isMoveValid(board, toX, toY);

        int fromX = this.getX();
        int fromY = this.getY();

        if (!(fromX == toX || fromY == toY)) {
            return false;
        } else if (!this.checkIfClearWay(board, toX, toY)){
            System.out.println("way not clear");
            return false;
        }
        return true;
    }

    @Override
    public void move(Board board, Player player, int toX, int toY) {

        if(player.getColor() != this.getColor()){
            System.out.println("Not your piece");
            return;
        }

        if(isMoveValid(board, toX, toY)){
            this.isFirstMove = false;
            board.getTile(this.getX(), this.getY()).setPiece(null);
            board.getTile(toX, toY).setPiece(this);
            this.setX(toX);
            this.setY(toY);
            this.isFirstMove = false;
        }
    }

    @Override
    public String toString() {
        return "R" + (this.getColor() == Color.BLACK ? "B " : "W ");
    }
}
