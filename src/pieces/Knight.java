package pieces;

import game.Board;
import game.Color;
import game.Player;
import game.Tile;

import static java.lang.StrictMath.abs;


/**
 * Created by Bogdan Darius on 12/10/2017.
 */
public class Knight extends Piece{

    public Knight(Color color, int x, int y){
        super(color, x, y, true);
    }

//    @Override
    public boolean isMoveValid(Board board, int toX, int toY) {
        if(board.getTile(toX, toY).getPiece() != null && board.getTile(toX, toY).getPiece().getColor() == this.getColor()){
            System.out.println("Cannot capture your own piece");
        }
        System.out.println(toX +  " " +  toY);
        System.out.println(this.getX() +  " " +  this.getY());
        super.isMoveValid(board, toX, toY);
        if (abs(this.getX() - toX) == 2 && abs(this.getY() - toY) == 1){
            return true;
        } else if(abs(this.getX() - toX) == 1 && abs(this.getY() - toY) == 2){
            return true;
        }
        System.out.println("false");
        return false;
    }

    public void move(Board board, Player player, int toX, int toY){

        System.out.println("here");
        if(player.getColor() != this.getColor()){
            System.out.println("Not your piece");
            return;
        }

        if(isMoveValid(board, toX, toY)){

            board.getTile(this.getX(), this.getY()).setPiece(null);
            board.getTile(toX, toY).setPiece(this);
            this.setX(toX);
            this.setY(toY);
            return ;
        }

        return ;
    }

    @Override
    public String toString() {
        return "Kn" + (this.getColor() == Color.BLACK ? "B " : "W ");
    }


}
