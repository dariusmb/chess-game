package game;

import pieces.*;

import java.util.ArrayList;

/**
 * Created by Bogdan Darius on 12/10/2017.
 */
public class Board {

    private ArrayList<Tile> tiles;
    private ArrayList<Piece> removedPieces;


    public Board(){
        tiles = new ArrayList<>();
        for(int i = 0; i < 8; i++){
            for(int j = 0; j< 8; j++){
                tiles.add(new Tile(i, j));
            }
        }
        removedPieces = new ArrayList<>();
    }

    public ArrayList<Tile> getTiles() {
        return tiles;
    }

    public ArrayList<Piece> getRemovedPieces() {
        return removedPieces;
    }

    public Tile getTile(int x, int y){
        
        for(Tile tile: tiles){
            
            if(tile.getX() == x && tile.getY() == y){
                return tile;
            }
        }
        return null;
    }
    public void initializeBoard(Player player1, Player player2) {
        
        Player black;
        Player white;

        if(player1.getColor() == Color.BLACK && player2.getColor() == Color.WHITE){
            white = player2;
            black = player1;
        } else {
            white = player1;
            black = player2;
        }
        
        Pawn pawn1 = new Pawn(Color.BLACK, new Tile(1, 0));
        Pawn pawn2 = new Pawn(Color.BLACK, new Tile(1, 1));
        Pawn pawn3 = new Pawn(Color.BLACK, new Tile(1, 2));
        Pawn pawn4 = new Pawn(Color.BLACK, new Tile(1, 3));
        Pawn pawn5 = new Pawn(Color.BLACK, new Tile(1, 4));
        Pawn pawn6 = new Pawn(Color.BLACK, new Tile(1, 5));
        Pawn pawn7 = new Pawn(Color.BLACK, new Tile(1, 6));
        Pawn pawn8 = new Pawn(Color.BLACK, new Tile(1, 7));
        Rook rook1 = new Rook(Color.BLACK, new Tile(0, 0));
        Rook rook2 = new Rook(Color.BLACK, new Tile(0, 7));
        Bishop bishop1 = new Bishop(Color.BLACK, new Tile(0, 1));
        Bishop bishop2 = new Bishop(Color.BLACK, new Tile(0, 6));
        Knight knight1 = new Knight(Color.BLACK, new Tile(0, 2));
        Knight knight2 = new Knight(Color.BLACK, new Tile(0, 5));
        Queen queen = new Queen(Color.BLACK, new Tile(0, 3));
        King king = new King(Color.BLACK, new Tile(0, 4));
        
        this.getTile(1, 0).setPiece(pawn1);
        this.getTile(1, 1).setPiece(pawn2);
        this.getTile(1, 2).setPiece(pawn3);
        this.getTile(1, 3).setPiece(pawn4);
        this.getTile(1, 4).setPiece(pawn5);
        this.getTile(1, 5).setPiece(pawn6);
        this.getTile(1, 6).setPiece(pawn7);
        this.getTile(1, 7).setPiece(pawn8);
        this.getTile(0, 0).setPiece(rook1);
        this.getTile(0, 7).setPiece(rook2);
        this.getTile(0, 1).setPiece(bishop1);
        this.getTile(0, 6).setPiece(bishop2);
        this.getTile(0, 2).setPiece(knight1);
        this.getTile(0, 5).setPiece(knight2);
        this.getTile(0, 3).setPiece(queen);
        this.getTile(0, 4).setPiece(king);
        
        black.getPieces().add(pawn1);
        black.getPieces().add(pawn2);
        black.getPieces().add(pawn3);
        black.getPieces().add(pawn4);
        black.getPieces().add(pawn5);
        black.getPieces().add(pawn6);
        black.getPieces().add(pawn7);
        black.getPieces().add(pawn8);
        black.getPieces().add(rook1);
        black.getPieces().add(rook2);
        black.getPieces().add(bishop1);
        black.getPieces().add(bishop2);
        black.getPieces().add(knight1);
        black.getPieces().add(knight2);
        black.getPieces().add(queen);
        black.getPieces().add(king);

        pawn1 = new Pawn(Color.WHITE, new Tile(6, 0));
        pawn2 = new Pawn(Color.WHITE, new Tile(6, 1));
        pawn3 = new Pawn(Color.WHITE, new Tile(6, 2));
        pawn4 = new Pawn(Color.WHITE, new Tile(6, 3));
        pawn5 = new Pawn(Color.WHITE, new Tile(6, 4));
        pawn6 = new Pawn(Color.WHITE, new Tile(6, 5));
        pawn7 = new Pawn(Color.WHITE, new Tile(6, 6));
        pawn8 = new Pawn(Color.WHITE, new Tile(6, 7));
        rook1 = new Rook(Color.WHITE, new Tile(7, 0));
        rook2 = new Rook(Color.WHITE, new Tile(7, 7));
        bishop1 = new Bishop(Color.WHITE, new Tile(7, 1));
        bishop2 = new Bishop(Color.WHITE, new Tile(7, 6));
        knight1 = new Knight(Color.WHITE, new Tile(7, 2));
        knight2 = new Knight(Color.WHITE, new Tile(7, 5));
        queen = new Queen(Color.WHITE, new Tile(7, 3));
        king = new King(Color.WHITE, new Tile(7, 4));

        this.getTile(6, 0).setPiece(pawn1);
        this.getTile(6, 1).setPiece(pawn2);
        this.getTile(6, 2).setPiece(pawn3);
        this.getTile(6, 3).setPiece(pawn4);
        this.getTile(6, 4).setPiece(pawn5);
        this.getTile(6, 5).setPiece(pawn6);
        this.getTile(6, 6).setPiece(pawn7);
        this.getTile(6, 7).setPiece(pawn8);
        this.getTile(7, 0).setPiece(rook1);
        this.getTile(7, 7).setPiece(rook2);
        this.getTile(7, 1).setPiece(bishop1);
        this.getTile(7, 6).setPiece(bishop2);
        this.getTile(7, 2).setPiece(knight1);
        this.getTile(7, 5).setPiece(knight2);
        this.getTile(7, 3).setPiece(queen);
        this.getTile(7, 4).setPiece(king);

        white.getPieces().add(pawn1);
        white.getPieces().add(pawn2);
        white.getPieces().add(pawn3);
        white.getPieces().add(pawn4);
        white.getPieces().add(pawn5);
        white.getPieces().add(pawn6);
        white.getPieces().add(pawn7);
        white.getPieces().add(pawn8);
        white.getPieces().add(rook1);
        white.getPieces().add(rook2);
        white.getPieces().add(bishop1);
        white.getPieces().add(bishop2);
        white.getPieces().add(knight1);
        white.getPieces().add(knight2);
        white.getPieces().add(queen);
        white.getPieces().add(king);
    }

    public void showPieces(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                System.out.print(this.getTile(i, j).getPiece() != null ? this.getTile(i, j).getPiece() : "ET ");
            }
            System.out.println();
        }
    }
}
