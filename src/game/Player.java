package game;

import pieces.Piece;

import java.util.ArrayList;

/**
 * Created by Bogdan Darius on 12/13/2017.
 */
public class Player {

    private Color color;
    private String name;
    private ArrayList<Piece> pieces;
    public Player(){
       this(null, null);
    }

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

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    @Override
    public String toString() {
        return "Player{" +
                "color=" + color +
                ", name='" + name + '\'' +
                ", pieces=" + pieces +
                '}';
    }
}
