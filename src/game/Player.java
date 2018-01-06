package game;

import pieces.Piece;

import java.util.ArrayList;

/**
 * Created by Bogdan Darius on 12/13/2017.
 */
public class Player {

    private Color color;
    private String name;
    private ArrayList<Tile> piecesPositions;
    private Tile kingTile;

    public Player(){
       this(null, null);
    }

    public Player(Color color, String name){
        this.color = color;
        this.name = name;
        this.piecesPositions = new ArrayList<>();
    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public void setPiecesPositions(ArrayList<Tile> pieces) {
        this.piecesPositions = piecesPositions;
    }

    public void addPiecePosition(Tile tile){
        this.piecesPositions.add(tile);
    }

    public void removePiecePosition(Tile tile) {
        this.piecesPositions.remove(tile);
    }

    public void changePiecePosition(Tile fromTile, Tile toTile) {
        this.piecesPositions.remove(fromTile);
        this.piecesPositions.add(toTile);
    }
    public ArrayList<Tile> getPiecesPositions() {
        return piecesPositions;
    }

    public Tile getKingTile() {
        return kingTile;
    }

    public void setKingTile(Tile kingTile) {
        this.kingTile = kingTile;
    }

    @Override
    public String toString() {
        return "Player{" +
                "color=" + color +
                ", name='" + name + '\'' +
                ", piecesPositions=" + piecesPositions +
                ", kingTile=" + kingTile +
                '}';
    }
}
