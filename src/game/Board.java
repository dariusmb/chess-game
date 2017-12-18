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
        Pawn pawn = new Pawn(Color.BLACK);
//        Pawn pawn2 = new Pawn(Color.BLACK, 1, 1);
//        Pawn pawn3 = new Pawn(Color.BLACK, 1, 2);
//        Pawn pawn4 = new Pawn(Color.BLACK, 1, 3);
//        Pawn pawn5 = new Pawn(Color.BLACK, 1, 4);
//        Pawn pawn6 = new Pawn(Color.BLACK, 1, 5);
//        Pawn pawn7 = new Pawn(Color.BLACK, 1, 6);
//        Pawn pawn8 = new Pawn(Color.BLACK, 1, 7);
        Rook rook = new Rook(Color.BLACK);
//        Rook rook2 = new Rook(Color.BLACK, 0, 7);
        Bishop bishop = new Bishop(Color.BLACK);
//        Bishop bishop2 = new Bishop(Color.BLACK, 0, 6);
        Knight knight = new Knight(Color.BLACK);
//        Knight knight2 = new Knight(Color.BLACK, 0, 5);
        Queen queen = new Queen(Color.BLACK);
        King king = new King(Color.BLACK);

        this.getTile(1, 0).setPiece(pawn);
        this.getTile(1, 1).setPiece(pawn);
        this.getTile(1, 2).setPiece(pawn);
        this.getTile(1, 3).setPiece(pawn);
        this.getTile(1, 4).setPiece(pawn);
        this.getTile(1, 5).setPiece(pawn);
        this.getTile(1, 6).setPiece(pawn);
        this.getTile(1, 7).setPiece(pawn);
        this.getTile(0, 0).setPiece(rook);
        this.getTile(0, 7).setPiece(rook);
        this.getTile(0, 1).setPiece(bishop);
        this.getTile(0, 6).setPiece(bishop);
        this.getTile(0, 2).setPiece(knight);
        this.getTile(0, 5).setPiece(knight);
        this.getTile(0, 3).setPiece(queen);
        this.getTile(0, 4).setPiece(king);

        black.getPieces().add(pawn);
        black.getPieces().add(pawn);
        black.getPieces().add(pawn);
        black.getPieces().add(pawn);
        black.getPieces().add(pawn);
        black.getPieces().add(pawn);
        black.getPieces().add(pawn);
        black.getPieces().add(pawn);
        black.getPieces().add(rook);
        black.getPieces().add(rook);
        black.getPieces().add(bishop);
        black.getPieces().add(bishop);
        black.getPieces().add(knight);
        black.getPieces().add(knight);
        black.getPieces().add(queen);
        black.getPieces().add(king);

        pawn = new Pawn(Color.WHITE);
//        pawn2 = new Pawn(Color.WHITE, 6, 1);
//        pawn3 = new Pawn(Color.WHITE, 6, 2);
//        pawn4 = new Pawn(Color.WHITE, 6, 3);
//        pawn5 = new Pawn(Color.WHITE, 6, 4);
//        pawn6 = new Pawn(Color.WHITE, 6, 5);
//        pawn7 = new Pawn(Color.WHITE, 6, 6);
//        pawn8 = new Pawn(Color.WHITE,6, 7);
//        rook1 = new Rook(Color.WHITE, 7, 0);
        rook = new Rook(Color.WHITE);
        bishop = new Bishop(Color.WHITE);
//        bishop2 = new Bishop(Color.WHITE,7, 6);
        knight = new Knight(Color.WHITE);
//        knight2 = new Knight(Color.WHITE, 7, 5);
        queen = new Queen(Color.WHITE);
        king = new King(Color.WHITE);

        this.getTile(6, 0).setPiece(pawn);
        this.getTile(6, 1).setPiece(pawn);
        this.getTile(6, 2).setPiece(pawn);
        this.getTile(6, 3).setPiece(pawn);
        this.getTile(6, 4).setPiece(pawn);
        this.getTile(6, 5).setPiece(pawn);
        this.getTile(6, 6).setPiece(pawn);
        this.getTile(6, 7).setPiece(pawn);
        this.getTile(7, 0).setPiece(rook);
        this.getTile(7, 7).setPiece(rook);
        this.getTile(7, 1).setPiece(bishop);
        this.getTile(7, 6).setPiece(bishop);
        this.getTile(7, 2).setPiece(knight);
        this.getTile(7, 5).setPiece(knight);
        this.getTile(7, 3).setPiece(queen);
        this.getTile(7, 4).setPiece(king);

        white.getPieces().add(pawn);
        white.getPieces().add(pawn);
        white.getPieces().add(pawn);
        white.getPieces().add(pawn);
        white.getPieces().add(pawn);
        white.getPieces().add(pawn);
        white.getPieces().add(pawn);
        white.getPieces().add(pawn);
        white.getPieces().add(rook);
        white.getPieces().add(rook);
        white.getPieces().add(bishop);
        white.getPieces().add(bishop);
        white.getPieces().add(knight);
        white.getPieces().add(knight);
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


    private boolean checkIfClearWayDiagonal(Tile fromTile, Tile toTile){

        int rowOffset;
        int columnOffset;

        if(fromTile.getX() < toTile.getX()){
            rowOffset = 1;
        } else {
            rowOffset = -1;
        }

        if(fromTile.getY() < toTile.getY()){
            columnOffset = 1;
        } else {
            columnOffset = -1;
        }

        int j = fromTile.getY() + columnOffset;
        for(int i = fromTile.getX() + rowOffset; i != toTile.getX(); i += rowOffset){

            if(getTile(i,j).getPiece() != null){
                return false;
            }
            j += columnOffset;
        }

        return true;
    }

    private boolean checkIfClearWayOnLine(Tile fromTile, Tile toTile){

        int rowOffset;
        int columnOffset;

        if(toTile.getX() != fromTile.getX()){
            if(toTile.getX() < fromTile.getX()) {
                rowOffset = -1;
            } else {
                rowOffset = 1;
            }
            for(int i = fromTile.getX() + rowOffset;  i != toTile.getX(); i++){
                if(getTile(i, toTile.getY()).getPiece() != null){
                    return false;
                }
            }
        } else if (toTile.getY() != fromTile.getY()) {
            if (toTile.getY() < fromTile.getY()) {
                columnOffset = -1;
            } else {
                columnOffset = 1;
            }
            for (int i = fromTile.getY() + columnOffset; i != toTile.getY(); i++) {
                if (getTile(toTile.getX(), i).getPiece() != null) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean checkIfClearWay(Tile fromTile, Tile toTile) {

        if((toTile.getX() != fromTile.getX() && toTile.getY() == fromTile.getY()) ||
                (toTile.getX() == fromTile.getX() && toTile.getY() != fromTile.getY())){
            return checkIfClearWayOnLine(fromTile, toTile);
        } else {
            return checkIfClearWayDiagonal(fromTile, toTile);
        }
    }

    public void move(Player player, Tile fromTile, Tile toTile) {

        Piece movedPiece = fromTile.getPiece();
        if(player.getColor() != fromTile.getPiece().getColor()){
            System.out.println("Not your piece");
            return;
        }

        if(toTile.getPiece() != null && toTile.getPiece().getColor() == fromTile.getPiece().getColor()){
            System.out.println("Cannot capture your own piece");
        }

        if(movedPiece.isMoveValid(fromTile, toTile)){
            movedPiece.setFirstMove(false);
            if (checkIfClearWay(fromTile, toTile)){
                toTile.setPiece(fromTile.getPiece());
//                fromTile.getPiece().setX(toTile.getX());
//                fromTile.getPiece().setY(toTile.getY());
                fromTile.setPiece(null);
            } else{
                System.out.println("not a clear way");
            }
//            board.getTile(this.getX(), this.getY()).setPiece(null);
//            board.getTile(toX, toY).setPiece(this);
//            this.setX(toX);
//            this.setY(toY);
//            this.isFirstMove = false;
        }
    }
}
