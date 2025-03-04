package game;

import pieces.Piece;

/**
 * Created by Bogdan Darius on 12/10/2017.
 */
public class Tile {

    private int x;
    private int y;
    private Piece piece;

    public Tile(int x, int y){
        this.x = x;
        this.y = y;
        this.piece = null;
    }

    public boolean isEmptyTile(){
        return this.piece == null;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    @Override
    public String toString() {
        return "Tile{" +
                "x=" + x +
                ", y=" + y +
                ", piece=" + piece +
                '}';
    }
}
