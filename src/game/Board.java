package game;

import pieces.*;

import java.util.ArrayList;

/**
 * Created by Bogdan Darius on 12/10/2017.
 */
public class Board {

    private ArrayList<Tile> tiles;
    private ArrayList<Piece> removedPieces;
    private Tile lastMove;

    public Board(){
        tiles = new ArrayList<>();
        for(int i = 0; i < 8; i++){
            for(int j = 0; j< 8; j++){
                tiles.add(new Tile(i, j));
            }
        }
        removedPieces = new ArrayList<>();
        lastMove = null;
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
        Rook rook = new Rook(Color.BLACK);
        Bishop bishop = new Bishop(Color.BLACK);
        Knight knight = new Knight(Color.BLACK);
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
        black.setKingTile(this.getTile(0, 4));

        pawn = new Pawn(Color.WHITE);
        rook = new Rook(Color.WHITE);
        bishop = new Bishop(Color.WHITE);
        knight = new Knight(Color.WHITE);
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
        white.setKingTile(this.getTile(7, 4));
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

    private boolean checkIfClearWay(Tile fromTile, Tile toTile) {

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
            return;
        }

        if((movedPiece instanceof Pawn && movePawn(player, fromTile, toTile)) || (movedPiece.isMoveValid(fromTile, toTile)
                && checkIfClearWay(fromTile, toTile) && !(movedPiece instanceof Pawn))){
            if(toTile.getPiece() != null){
                removedPieces.add(toTile.getPiece());
            }
            if(movedPiece instanceof King){
                player.setKingTile(toTile);
            }
            lastMove = toTile;
            movedPiece.setFirstMove(false);
            toTile.setPiece(fromTile.getPiece());
            fromTile.setPiece(null);
        }

        System.out.println(removedPieces);
    }

    private boolean movePawn(Player player, Tile fromTile, Tile toTile){

        int fromX = fromTile.getX();
        int fromY = fromTile.getY();
        int toX = toTile.getX();
        int toY = toTile.getY();
        int rowOffset;

        if(player.getColor() == Color.BLACK){
            rowOffset = 1;
        } else {
            rowOffset = -1;
        }

        // if there is a piece you can capture it
        if ((fromY + 1 == toY || fromY - 1 == toY) && fromX + rowOffset == toX){
            if(!getTile(toX, toY).isEmptyTile()){
                return true;
            } else if (lastMove.getX() == toX - rowOffset && lastMove.getY() == toY && ((Pawn)lastMove.getPiece()).isJumpOneSpace()){
                System.out.println("en passant");
                removedPieces.add(lastMove.getPiece());
                lastMove.setPiece(null);
                return true;
            }
            System.out.println("cant en passant");
            return false;
        } else if(fromTile.getPiece().isMoveValid(fromTile, toTile) &&
                checkIfClearWay(fromTile, toTile) && getTile(toX, toY).isEmptyTile()){
            return true;
        }
        return false;
    }

    public  final boolean isThreatenTile(Color threatenedColor, Tile threatenedTile){

        int rowDirections[] = {-1, -1, -1, 0, 0, 1, 1, 1};
        int colDirections[] = {-1, 0, 1, -1, 1, -1, 0, 1};
        boolean bishopThreats[] = {true, false, true, false, false, true, false, true};
        boolean rookThreats[] = {false, true, false, true, true, false, true, false};
        boolean queenThreats[] = {true, true, true, true, true, true, true, true};
        boolean kingThreats[] = {true, true, true, true, true, true, true, true};
        boolean kill = threatenedColor == Color.BLACK;
        boolean pawnThreats[] = {kill, false, kill, false, false, !kill, false, !kill};

        boolean threatDetected = false;
        int threatenedRow = threatenedTile.getX();
        int threatenedCol = threatenedTile.getY();

        threatDetected = knightThreat(threatenedColor, threatenedTile);

        for (int direction = 0; direction < 8 && !threatDetected; direction++){
            // reset our coordinates to process current line of attack
            // increment values are same as direction array values

            int row = threatenedRow;
            int col = threatenedCol;
            int rowIncrement = rowDirections[direction];
            int colIncrement = colDirections[direction];

            //radiate outwards starting from origin until we hit a piece or we are out of bounds
            for (int step = 0; step < 8; step++){
                row = row + rowIncrement;
                col = col + colIncrement;

                //if we are out of bounds we stop radiating outwards for this ray and try with next one
                if (row < 0 || row > 7 || col < 0 || col > 7){
                    break;
                } else {
                    //look at current tile and see if it is occupied by a piece
                    Tile tile = getTile(row, col);
                    Piece piece = tile.getPiece();

                    if (piece != null){
                        if (!(piece.getColor() == threatenedColor)){
                            //opponents piece, must check if the piece can attack us
                            if (piece instanceof Bishop && bishopThreats[direction]){
                                threatDetected = true;
                            } else if (piece instanceof Rook && rookThreats[direction]){
                                threatDetected = true;
                            } else if (piece instanceof Queen && queenThreats[direction]){
                                threatDetected = true;
                            } else {
                                if(step == 0){
                                    if (piece instanceof Pawn && pawnThreats[direction])
                                        threatDetected = true;
                                    if(piece instanceof  King && kingThreats[direction])
                                        threatDetected = true;
                                }
                            }
                        }
                        break;
                    }
                }
            }
        }

        return threatDetected;
    }

    private  boolean knightThreat(Color threatenedColor, Tile threatenedTile){

        boolean threatDetected = false;
        int threatenedRow = threatenedTile.getX();
        int threatenedCol = threatenedTile.getY();

        int rowDirection[] = {-2, -1, 1, 2, 2, 1, -1, -2};
        int colDirection[] = {-1, -2, -2, -1, 1, 2, 2, 1};

        for(int direction = 0; direction < 8 && !threatDetected; direction++){

            int row = threatenedRow + rowDirection[direction];
            int col = threatenedCol + colDirection[direction];

            if (!(row < 0 || row > 7 || col < 0 || col > 7)){

                Tile tile = getTile(row, col);
                Piece piece = tile.getPiece();

                if(piece != null && !(piece.getColor() == threatenedColor) && piece instanceof Knight){
                   threatDetected = true;
                }
            }
        }

        return threatDetected;
    }
}