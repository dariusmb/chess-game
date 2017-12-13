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

    public Knight(Color color, Tile tile){
        super(color, tile, true);
    }

    @Override
    public boolean isMoveValid(Tile toTile) {

        if(toTile.getPiece() != null && toTile.getPiece().getColor() == this.getTile().getPiece().getColor()){
            System.out.println("Cannot capture your own piece");
        }

        super.isMoveValid(toTile);
        if (abs(this.getTile().getX() - toTile.getX()) == 2 && abs(this.getTile().getY() - toTile.getY()) == 1){
            return true;
        } else if(abs(this.getTile().getX() - toTile.getX()) == 1 && abs(this.getTile().getY() - toTile.getY()) == 2){
            return true;
        }
        return false;
    }

    public boolean move(Board board, Player player, Tile fromTile, Tile toTile){

        if(player.getColor() != this.getColor()){
            System.out.println("Not your piece");
            return false;
        }

        if(isMoveValid(toTile)){
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Kn" + (this.getColor() == Color.BLACK ? "B " : "W ");
    }


}
