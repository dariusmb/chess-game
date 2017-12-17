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
    public boolean isMoveValid(Tile toTile) {
//        if(board.getTile(toX, toY).getPiece() != null && board.getTile(toX, toY).getPiece().getColor() == this.getColor()){
//            System.out.println("Cannot capture your own piece");
//    }
        super.isMoveValid(toTile);
        if (abs(this.getX() - toTile.getX()) == 2 && abs(this.getY() - toTile.getY()) == 1){
            return true;
        } else if(abs(this.getX() - toTile.getX()) == 1 && abs(this.getY() - toTile.getY()) == 2){
            return true;
        }
        System.out.println("false");
        return false;
    }



    @Override
    public String toString() {
        return "Kn" + (this.getColor() == Color.BLACK ? "B " : "W ");
    }


}
