package game;

import pieces.King;
import pieces.Piece;

import java.util.ArrayList;

/**
 * Created by Bogdan Darius on 12/13/2017.
 */
public class Player {

    private Color color;
    private String name;
    private ArrayList<Piece> pieces;
    private King king;

    public Player(Color color, String name){
        this.color = color;
        this.name = name;
        this.pieces = new ArrayList<>();
    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

    public void addPiece(Piece piece){
        this.pieces.add(piece);
    }

    public void removePiece(Piece piece) {
        this.pieces.remove(piece);
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public King getKing() {
        return king;
    }

    public void setKing(King king) {
        this.king = king;
    }

    public void setKingCoordinates(int x, int y) {
        king.setX(x);
        king.setY(y);
    }

    @Override
    public String toString() {
        return "Player{" +
                "color=" + color +
                ", name='" + name + '\'' +
                ", pieces=" + pieces +
                ", kingTile=" + king +
                '}';
    }
}
