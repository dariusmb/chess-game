package game;

import pieces.*;

import java.util.ArrayList;

/**
 * Created by Bogdan Darius on 12/10/2017.
 */
public class Board {

    private ArrayList<Tile> tiles;
    private ArrayList<Piece> removedWhitePieces;
    private ArrayList<Piece> removedBlackPieces;
    private Tile contenderPieceTile;
    private Tile lastMove;
    private Player blackPlayer;
    private Player whitePlayer;
    private Player currentPlayer;
    private boolean isCheck;
    private boolean isStaleMate;
    private boolean isCheckMate;

    public Board(){
        this.isCheck = false;
        this.isCheckMate = false;
        this.isStaleMate = false;
        blackPlayer = new Player(Color.BLACK, "Darius");
        whitePlayer = new Player(Color.WHITE, "Alex");
        currentPlayer = whitePlayer;
        tiles = new ArrayList<>();
        for(int i = 0; i < 8; i++){
            for(int j = 0; j< 8; j++){
                tiles.add(new Tile(i, j));
            }
        }
        removedWhitePieces = new ArrayList<>();
        removedBlackPieces = new ArrayList<>();
        lastMove = null;
    }

    public ArrayList<Tile> getTiles() {
        return tiles;
    }

    public ArrayList<Piece> getRemovedWhitePieces() {
        return removedWhitePieces;
    }

    public ArrayList<Piece> getRemovedBlackPieces() {
        return removedBlackPieces;
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

        Pawn pawn = new Pawn(Color.BLACK, 1, 0);
        Pawn pawn1 = new Pawn(Color.BLACK, 1, 1);
        Pawn pawn2 = new Pawn(Color.BLACK, 1, 2);
        Pawn pawn3 = new Pawn(Color.BLACK, 1, 3);
        Pawn pawn4 = new Pawn(Color.BLACK, 1, 4);
        Pawn pawn5 = new Pawn(Color.BLACK, 1, 5);
        Pawn pawn6 = new Pawn(Color.BLACK, 1, 6);
        Pawn pawn7 = new Pawn(Color.BLACK, 1, 7);
        Rook rook = new Rook(Color.BLACK, 0, 0);
        Rook rook1 = new Rook(Color.BLACK, 0, 7);
        Bishop bishop = new Bishop(Color.BLACK, 0, 5);
        Bishop bishop1 = new Bishop(Color.BLACK, 0, 2);
        Knight knight = new Knight(Color.BLACK, 0, 1);
        Knight knight1 = new Knight(Color.BLACK, 0, 6);
        Queen queen = new Queen(Color.BLACK, 0, 3);
        King king = new King(Color.BLACK, 0, 4);

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

        blackPlayer.addPiece(pawn);
        blackPlayer.addPiece(pawn1);
        blackPlayer.addPiece(pawn2);
        blackPlayer.addPiece(pawn3);
        blackPlayer.addPiece(pawn4);
        blackPlayer.addPiece(pawn5);
        blackPlayer.addPiece(pawn6);
        blackPlayer.addPiece(pawn7);
        blackPlayer.addPiece(rook);
        blackPlayer.addPiece(rook1);
        blackPlayer.addPiece(bishop);
        blackPlayer.addPiece(bishop1);
        blackPlayer.addPiece(knight);
        blackPlayer.addPiece(knight1);
        blackPlayer.addPiece(queen);
        blackPlayer.addPiece(king);
        blackPlayer.setKing(king);

        pawn = new Pawn(Color.WHITE, 6, 0);
        pawn1 = new Pawn(Color.WHITE, 6, 1);
        pawn2 = new Pawn(Color.WHITE, 6, 2);
        pawn3 = new Pawn(Color.WHITE, 6, 3);
        pawn4 = new Pawn(Color.WHITE, 6, 4);
        pawn5 = new Pawn(Color.WHITE, 6, 5);
        pawn6 = new Pawn(Color.WHITE, 6, 6);
        pawn7 = new Pawn(Color.WHITE, 6, 7);
        rook = new Rook(Color.WHITE, 7, 0);
        rook1 = new Rook(Color.WHITE, 7, 7);
        bishop = new Bishop(Color.WHITE, 7, 5);
        bishop1 = new Bishop(Color.WHITE, 7, 2);
        knight = new Knight(Color.WHITE, 7, 1);
        knight1 = new Knight(Color.WHITE, 7, 6);
        queen = new Queen(Color.WHITE, 7, 3);
        king = new King(Color.WHITE, 7, 4);

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
        this.getTile(7, 2).setPiece(bishop1);
        this.getTile(7, 5).setPiece(bishop);
        this.getTile(7, 1).setPiece(knight);
        this.getTile(7, 6).setPiece(knight1);
        this.getTile(7, 3).setPiece(queen);
        this.getTile(7, 4).setPiece(king);

        whitePlayer.addPiece(pawn);
        whitePlayer.addPiece(pawn1);
        whitePlayer.addPiece(pawn2);
        whitePlayer.addPiece(pawn3);
        whitePlayer.addPiece(pawn4);
        whitePlayer.addPiece(pawn5);
        whitePlayer.addPiece(pawn6);
        whitePlayer.addPiece(pawn7);
        whitePlayer.addPiece(rook);
        whitePlayer.addPiece(rook);
        whitePlayer.addPiece(rook1);
        whitePlayer.addPiece(bishop);
        whitePlayer.addPiece(bishop1);
        whitePlayer.addPiece(knight);
        whitePlayer.addPiece(knight1);
        whitePlayer.addPiece(queen);
        whitePlayer.setKing(king);
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

    public boolean move(Player player, Tile fromTile, Tile toTile) {

        boolean moveMade = false;

        Piece movedPiece = fromTile.getPiece();
        if(player.getColor() != fromTile.getPiece().getColor()){
            System.out.println("Not your piece");
            return moveMade;
        }

        if(toTile.getPiece() != null && toTile.getPiece().getColor() == fromTile.getPiece().getColor()){
            System.out.println("Cannot capture your own piece");
            return moveMade;
        }
        if((movedPiece instanceof Pawn && movePawn(player, fromTile, toTile))){
            moveMade = validateMove(player, fromTile, toTile);
        } else if (movedPiece instanceof King && movedPiece.isMoveValid(fromTile, toTile) &&
                !isThreatenTile(player.getColor(), toTile, false, true)){
            moveMade = validateMove(player, fromTile, toTile);
        } else if(movedPiece instanceof King && (fromTile.getY() - 3 == toTile.getY() || fromTile.getY() + 2 == toTile.getY())
                && fromTile.getX() == toTile.getX()) {
            tryToDoTheCastling(fromTile,toTile);
        } else if(movedPiece.isMoveValid(fromTile, toTile)
                && checkIfClearWay(fromTile, toTile) && !(movedPiece instanceof Pawn) && !(movedPiece instanceof King)){
            moveMade = validateMove(player, fromTile, toTile);
        }

        Tile kingTile = getTile(currentPlayer.getKing().getX(), currentPlayer.getKing().getY());
        if(isThreatenTile(currentPlayer.getColor(), kingTile, false, true)){
            this.isCheck = true;
            if(checkIfCheckMate(kingTile)){
                this.isCheckMate = true;
                System.out.println("checkMate");
            }
        }
        else if(kingTile.getPiece().calculatePossibleMoves(this).size() == 0){
            this.isStaleMate = true;
            for(Piece piece: currentPlayer.getPieces()){
                if(piece.calculatePossibleMoves(this).size() != 0){
                    this.isStaleMate = false;
                }
            }
            System.out.println("staleMate");
        }
        else {
            this.isCheck = false;
        }
        return moveMade;
    }

    //Make the move on the board
    private void makeMove(Player player, Tile fromTile, Tile toTile){
        if(fromTile.getPiece() instanceof King){
            player.setKingCoordinates(toTile.getX(), toTile.getY());
        }
        if(toTile.getPiece() != null){
            removePiece(toTile);
        }
        fromTile.getPiece().setX(toTile.getX());
        fromTile.getPiece().setY(toTile.getY());
        if(currentPlayer == whitePlayer){
            currentPlayer = blackPlayer;
        } else {
            currentPlayer = whitePlayer;
        }
        lastMove = toTile;
        fromTile.getPiece().setFirstMove(false);

        //pawn promotion to queen
        if(fromTile.getPiece() instanceof Pawn && (toTile.getX() == 0 || toTile.getX() == 7)){
            Queen queen = new Queen(player.getColor(), toTile.getX(), toTile.getY());
            toTile.setPiece(queen);
        } else {
            toTile.setPiece(fromTile.getPiece());
        }


        fromTile.setPiece(null);
    }

    private boolean validateMove(Player player, Tile fromTile, Tile toTile){
        boolean moveMade = false;
        Tile tile = new Tile(toTile.getX(), toTile.getY());
        tile.setPiece(toTile.getPiece());

        toTile.setPiece(fromTile.getPiece());
        if(fromTile.getPiece() instanceof King){
            player.setKingCoordinates(toTile.getX(), toTile.getY());
        }
        Tile kingTile = getTile(player.getKing().getX(), player.getKing().getY());
        fromTile.setPiece(null);
        if(!isThreatenTile(player.getColor(), kingTile, false, true)){
            //the move made the check disappear so it's a valid move
            fromTile.setPiece(toTile.getPiece());
            toTile.setPiece(tile.getPiece());
            makeMove(player, fromTile, toTile);
            moveMade = true;
        } else {
            //not a valid move, still in check, so move the pieces back
            fromTile.setPiece(toTile.getPiece());
            toTile.setPiece(tile.getPiece());
            if (fromTile.getPiece() instanceof King) {
                player.setKingCoordinates(fromTile.getX(), fromTile.getY());
            }
        }

        return moveMade;
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
            } else if (lastMove != null && lastMove.getX() == toX - rowOffset && lastMove.getY() == toY && ((Pawn)lastMove.getPiece()).isJumpOneSpace()){
                System.out.println("en passant");
                removePiece(lastMove);
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

    private void removePiece(Tile tile){

        Piece piece = tile.getPiece();
        if(tile.getPiece().getColor() == Color.BLACK){
            removedBlackPieces.add(piece);
            blackPlayer.removePiece(piece);
//            System.out.println(blackPlayer.getPieces());
        } else {
            removedWhitePieces.add(piece);
            whitePlayer.removePiece(piece);
        }
    }

    public boolean isThreatenTile(Color threatenedColor, Tile threatenedTile, boolean inCheck, boolean canPawnAttack){

        int rowDirections[] = {-1, -1, -1, 0, 0, 1, 1, 1};
        int colDirections[] = {-1, 0, 1, -1, 1, -1, 0, 1};
        boolean bishopThreats[] = {true, false, true, false, false, true, false, true};
        boolean rookThreats[] = {false, true, false, true, true, false, true, false};
        boolean queenThreats[] = {true, true, true, true, true, true, true, true};
        boolean kingThreats[] = {true, true, true, true, true, true, true, true};
        boolean kill = threatenedColor == Color.BLACK;
        boolean pawnThreats[] = {!kill, false, !kill, false, false, kill, false, kill};

        boolean threatDetected;
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
                                if(threatenedTile.getPiece() instanceof King){
                                    contenderPieceTile = tile;
                                }
                                threatDetected = true;
                            } else if (piece instanceof Rook && rookThreats[direction]){
                                if(threatenedTile.getPiece() instanceof King){
                                    contenderPieceTile = tile;
                                }
                                threatDetected = true;
                            } else if (piece instanceof Queen && queenThreats[direction]){
                                if(threatenedTile.getPiece() instanceof King){
                                    contenderPieceTile = tile;
                                }
                                threatDetected = true;
                            } else {
                                if(step == 0){
                                    if (piece instanceof Pawn && pawnThreats[direction] && canPawnAttack) {
                                        if(threatenedTile.getPiece() instanceof King){
                                            contenderPieceTile = tile;
                                        }
                                        threatDetected = true;
                                    }
                                    if(piece instanceof  King && kingThreats[direction] && !inCheck)
                                        threatDetected = true;
                                }
                            }
                        }
                        if(!(piece instanceof King && isCheck)){
                            break;
                        }
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

    private void tryToDoTheCastling(Tile fromTile, Tile toTile){
        int colOffset;
        Tile rookTile;
        Tile newRookTile;
        int rookRow;

        if(currentPlayer.getColor() == Color.WHITE){
            rookRow = 7;
        } else {
            rookRow = 0;
        }
        if (toTile.getY() < fromTile.getY()) {
            colOffset = -1;
            rookTile = getTile(rookRow, 0);
            newRookTile = getTile(rookRow, 2);
        } else {
            colOffset = 1;
            rookTile = getTile(rookRow, 7);
            newRookTile = getTile(rookRow, 5);
        }

        if (fromTile.getPiece().isFirstMove() && rookTile.getPiece().isFirstMove()
                && checkIfClearWayOnLine(fromTile, rookTile)) {
            for (int i = fromTile.getY() + colOffset; i != rookTile.getY(); i += colOffset) {
                if (isThreatenTile(fromTile.getPiece().getColor(), getTile(toTile.getX(), i), false, true)) {
                    return ;
                }
            }
        } else {
            return ;
        }

        makeMove(currentPlayer, fromTile, toTile);
        rookTile.getPiece().setX(newRookTile.getX());
        rookTile.getPiece().setY(newRookTile.getY());
        newRookTile.setPiece(rookTile.getPiece());
        rookTile.setPiece(null);
        newRookTile.getPiece().setFirstMove(false);
    }

    private boolean checkIfCheckMate(Tile kingTile){

        boolean canInterceptPiece = true;
        Color color = kingTile.getPiece().getColor();
        Color contenderColor;

        if(color == Color.BLACK){
            contenderColor = Color.WHITE;
        } else {
            contenderColor = Color.BLACK;
        }

        if(contenderPieceTile != null && !isThreatenTile(contenderColor, contenderPieceTile, true, true)){
            canInterceptPiece = false;
            if(!(contenderPieceTile.getPiece() instanceof  Knight)){
                if(!checkIfNoThreat(contenderColor, contenderPieceTile, kingTile)){
                    canInterceptPiece = true;
                }
            }
        }


        if(kingTile.getPiece().calculatePossibleMoves(this).size() == 0 && !canInterceptPiece){
            System.out.println("Check mate");
            return true;
        }

        return false;
    }

    private boolean checkIfNoThreatOnDiagonal(Color contenderColor, Tile fromTile, Tile toTile){

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

            if(isThreatenTile(contenderColor, getTile(i,j), true, false)){
                return false;
            }
            j += columnOffset;
        }

        return true;
    }

    private boolean checkIfNoThreatOnLine(Color contenderColor, Tile fromTile, Tile toTile){

        int rowOffset;
        int columnOffset;

        if(toTile.getX() != fromTile.getX()){
            if(toTile.getX() < fromTile.getX()) {
                rowOffset = -1;
            } else {
                rowOffset = 1;
            }
            for(int i = fromTile.getX() + rowOffset;  i != toTile.getX(); i+= rowOffset){
                if(isThreatenTile(contenderColor, getTile(i, toTile.getY()), true, false)){
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
                if (isThreatenTile(contenderColor, getTile(toTile.getX(), i), true, false)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean checkIfNoThreat(Color contenderColor, Tile fromTile, Tile toTile) {

        if((toTile.getX() != fromTile.getX() && toTile.getY() == fromTile.getY()) ||
                (toTile.getX() == fromTile.getX() && toTile.getY() != fromTile.getY())){
            return checkIfNoThreatOnLine(contenderColor, fromTile, toTile);
        } else {
            return checkIfNoThreatOnDiagonal(contenderColor, fromTile, toTile);
        }
    }
    public boolean isCheck() {
        return isCheck;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Player getBlackPlayer() {
        return blackPlayer;
    }

    public Player getWhitePlayer() {
        return whitePlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public boolean isCheckMate() {
        return isCheckMate;
    }

    public boolean isStaleMate() {
        return isStaleMate;
    }

    public Tile getLastMove() {
        return lastMove;
    }

    public void setLastMove(Tile lastMove) {
        this.lastMove = lastMove;
    }
}