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
    private Player blackPlayer;
    private Player whitePlayer;
    private Player currentPlayer;

    public Board(){
        blackPlayer = new Player(Color.BLACK, "Darius");
        whitePlayer = new Player(Color.WHITE, "Alex");
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
    public void initializeBoard() {

        Pawn pawn = new Pawn(Color.BLACK);
        Pawn pawn1 = new Pawn(Color.BLACK);
        Pawn pawn2 = new Pawn(Color.BLACK);
        Pawn pawn3 = new Pawn(Color.BLACK);
        Pawn pawn4 = new Pawn(Color.BLACK);
        Pawn pawn5 = new Pawn(Color.BLACK);
        Pawn pawn6 = new Pawn(Color.BLACK);
        Pawn pawn7 = new Pawn(Color.BLACK);
        Rook rook = new Rook(Color.BLACK);
        Rook rook1 = new Rook(Color.BLACK);
        Bishop bishop = new Bishop(Color.BLACK);
        Bishop bishop1 = new Bishop(Color.BLACK);
        Knight knight = new Knight(Color.BLACK);
        Knight knight1 = new Knight(Color.BLACK);
        Queen queen = new Queen(Color.BLACK);
        King king = new King(Color.BLACK);

        this.getTile(1, 0).setPiece(pawn);
        this.getTile(1, 1).setPiece(pawn1);
        this.getTile(1, 2).setPiece(pawn2);
        this.getTile(1, 3).setPiece(pawn3);
        this.getTile(1, 4).setPiece(pawn4);
        this.getTile(1, 5).setPiece(pawn5);
        this.getTile(1, 6).setPiece(pawn6);
        this.getTile(1, 7).setPiece(pawn7);
        this.getTile(0, 0).setPiece(rook);
        this.getTile(0, 7).setPiece(rook1);
        this.getTile(0, 2).setPiece(bishop);
        this.getTile(0, 5).setPiece(bishop1);
        this.getTile(0, 1).setPiece(knight);
        this.getTile(0, 6).setPiece(knight1);
        this.getTile(0, 3).setPiece(queen);
        this.getTile(0, 4).setPiece(king);

        blackPlayer.getPieces().add(pawn);
        blackPlayer.getPieces().add(pawn1);
        blackPlayer.getPieces().add(pawn2);
        blackPlayer.getPieces().add(pawn3);
        blackPlayer.getPieces().add(pawn4);
        blackPlayer.getPieces().add(pawn5);
        blackPlayer.getPieces().add(pawn6);
        blackPlayer.getPieces().add(pawn7);
        blackPlayer.getPieces().add(rook);
        blackPlayer.getPieces().add(rook1);
        blackPlayer.getPieces().add(bishop);
        blackPlayer.getPieces().add(bishop1);
        blackPlayer.getPieces().add(knight);
        blackPlayer.getPieces().add(knight1);
        blackPlayer.getPieces().add(queen);
        blackPlayer.getPieces().add(king);
        blackPlayer.setKingTile(this.getTile(0, 4));

        pawn = new Pawn(Color.WHITE);
        pawn1 = new Pawn(Color.WHITE);
        pawn2 = new Pawn(Color.WHITE);
        pawn3 = new Pawn(Color.WHITE);
        pawn4 = new Pawn(Color.WHITE);
        pawn5 = new Pawn(Color.WHITE);
        pawn6 = new Pawn(Color.WHITE);
        pawn7 = new Pawn(Color.WHITE);
        rook = new Rook(Color.WHITE);
        rook1 = new Rook(Color.WHITE);
        bishop = new Bishop(Color.WHITE);
        bishop1 = new Bishop(Color.WHITE);
        knight = new Knight(Color.WHITE);
        knight1 = new Knight(Color.WHITE);
        queen = new Queen(Color.WHITE);
        king = new King(Color.WHITE);

        this.getTile(6, 0).setPiece(pawn);
        this.getTile(6, 1).setPiece(pawn1);
        this.getTile(6, 2).setPiece(pawn2);
        this.getTile(6, 3).setPiece(pawn3);
        this.getTile(6, 4).setPiece(pawn4);
        this.getTile(6, 5).setPiece(pawn5);
        this.getTile(6, 6).setPiece(pawn6);
        this.getTile(6, 7).setPiece(pawn7);
        this.getTile(7, 0).setPiece(rook);
        this.getTile(7, 7).setPiece(rook1);
        this.getTile(7, 2).setPiece(bishop);
        this.getTile(7, 5).setPiece(bishop1);
        this.getTile(7, 1).setPiece(knight);
        this.getTile(7, 6).setPiece(knight1);
        this.getTile(7, 3).setPiece(queen);
        this.getTile(7, 4).setPiece(king);
        //testing
//        this.getTile(2,4).setPiece(queen);

        whitePlayer.getPieces().add(pawn);
        whitePlayer.getPieces().add(pawn1);
        whitePlayer.getPieces().add(pawn2);
        whitePlayer.getPieces().add(pawn3);
        whitePlayer.getPieces().add(pawn4);
        whitePlayer.getPieces().add(pawn5);
        whitePlayer.getPieces().add(pawn6);
        whitePlayer.getPieces().add(pawn7);
        whitePlayer.getPieces().add(rook);
        whitePlayer.getPieces().add(rook1);
        whitePlayer.getPieces().add(bishop);
        whitePlayer.getPieces().add(bishop1);
        whitePlayer.getPieces().add(knight);
        whitePlayer.getPieces().add(knight1);
        whitePlayer.getPieces().add(queen);
        whitePlayer.getPieces().add(king);
        whitePlayer.setKingTile(this.getTile(7, 4));

        currentPlayer = whitePlayer;
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
            for(int i = fromTile.getX() + rowOffset;  i != toTile.getX(); i+= rowOffset){
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
            for (int i = fromTile.getY() + columnOffset; i != toTile.getY(); i+= columnOffset) {
                if (getTile(toTile.getX(), i).getPiece() != null) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean checkIfClearWay(Tile fromTile, Tile toTile) {

        if(fromTile.getPiece() instanceof Knight){
            return true;
        }

        if((toTile.getX() != fromTile.getX() && toTile.getY() == fromTile.getY()) ||
                (toTile.getX() == fromTile.getX() && toTile.getY() != fromTile.getY())){
            return checkIfClearWayOnLine(fromTile, toTile);
        } else {
            return checkIfClearWayDiagonal(fromTile, toTile);
        }
    }

    public void move(Player player, Tile fromTile, Tile toTile) {

        System.out.println(fromTile + " " + toTile);
        Piece movedPiece = fromTile.getPiece();
        if(player.getColor() != fromTile.getPiece().getColor()){
            System.out.println("Not your piece");
            return ;
        }

        if(toTile.getPiece() != null && toTile.getPiece().getColor() == fromTile.getPiece().getColor()){
            System.out.println("Cannot capture your own piece");
            return ;
        }

        if(isThreatenTile(player.getColor(), player.getKingTile())){
            // the player is in check

            if(checkIfCheckMate(player.getKingTile())){
                //TODO check mate
            } else {
                if (movedPiece.isMoveValid(fromTile, toTile) || (movedPiece instanceof Pawn && movePawn(player, fromTile, toTile))){
                    //if the move is valid, simulate the move
                    Tile tile = new Tile(toTile.getX(), toTile.getY());
                    tile.setPiece(toTile.getPiece());

                    toTile.setPiece(fromTile.getPiece());
                    if(fromTile.getPiece() instanceof King){
                        player.setKingTile(toTile);
                    }
                    fromTile.setPiece(null);
                    if(!isThreatenTile(player.getColor(), player.getKingTile())){
                        //the move made the check disappear so it's a valid move
                        fromTile.setPiece(toTile.getPiece());
                        toTile.setPiece(tile.getPiece());
                        makeMove(player, fromTile, toTile);
                    } else {
                        //not a valid move, still in check, so move the pieces back
                        if(fromTile.getPiece() instanceof King){
                            player.setKingTile(fromTile);
                        }
                        fromTile.setPiece(toTile.getPiece());
                        toTile.setPiece(tile.getPiece());
                        return ;
                    }
                }
            }
            return ;
        }

        if((movedPiece instanceof Pawn && movePawn(player, fromTile, toTile))){
            makeMove(player, fromTile, toTile);
        } else  if (movedPiece instanceof King && movedPiece.isMoveValid(fromTile, toTile) &&
                !isThreatenTile(player.getColor(), toTile)){
            makeMove(player, fromTile, toTile);
        } else if(movedPiece.isMoveValid(fromTile, toTile)
                && checkIfClearWay(fromTile, toTile) && !(movedPiece instanceof Pawn) && !(movedPiece instanceof King)){
            System.out.println("here");
            makeMove(player, fromTile, toTile);
        }

        System.out.println(removedPieces);
    }

    //Make the move on the board
    private void makeMove(Player player, Tile fromTile, Tile toTile){
        if(toTile.getPiece() != null){
            removedPieces.add(toTile.getPiece());
        }
        if(fromTile.getPiece() instanceof King){
            player.setKingTile(toTile);
        }
        if(currentPlayer == whitePlayer){
            currentPlayer = blackPlayer;
        } else {
            currentPlayer = whitePlayer;
        }
        lastMove = toTile;
        fromTile.getPiece().setFirstMove(false);
        toTile.setPiece(fromTile.getPiece());
        fromTile.setPiece(null);
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
        boolean pawnThreats[] = {!kill, false, !kill, false, false, kill, false, kill};

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

    public boolean checkIfCheckMate(Tile kingTile){

//        ArrayList<Tile> possibleMoves = new ArrayList<>();
//
//
//        int rowDirections[] = {-1, -1, -1, 0, 0, 1, 1, 1};
//        int colDirections[] = {-1, 0, 1, -1, 1, -1, 0, 1};
//
//        int kingRow = kingTile.getX();
//        int kingCol = kingTile.getY();
//        Color color = kingTile.getPiece().getColor();
//
//        for(int direction = 0; direction < 8; direction++){
//
//            int row = kingRow + rowDirections[direction];
//            int col = kingCol + colDirections[direction];
//            Tile tile = getTile(row, col);
//
//            if (!isThreatenTile(color, tile)){
//                possibleMoves.add(tile);
//            }
//        }
//
//        if(possibleMoves.size() == 0){
//            System.out.println("Check mate");
//            return true;
//        }
//
        return false;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}