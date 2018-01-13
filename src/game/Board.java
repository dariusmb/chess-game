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

        arrangePieces(whitePlayer);
        arrangePieces(blackPlayer);
    }

    private void arrangePieces(Player player){

        int position;
        int offset;
        Color color = player.getColor();

        if(player.getColor() == Color.BLACK){
            offset = -1;
            position = 1;

        } else {
            offset = 1;
            position = 6;
        }

        Pawn pawn = new Pawn(color, position, 0);
        Pawn pawn1 = new Pawn(color, position, 1);
        Pawn pawn2 = new Pawn(color, position, 2);
        Pawn pawn3 = new Pawn(color, position, 3);
        Pawn pawn4 = new Pawn(color, position, 4);
        Pawn pawn5 = new Pawn(color, position, 5);
        Pawn pawn6 = new Pawn(color, position, 6);
        Pawn pawn7 = new Pawn(color, position, 7);
        Rook rook = new Rook(color, position + offset, 0);
        Rook rook1 = new Rook(color, position + offset, 7);
        Bishop bishop = new Bishop(color, position + offset, 5);
        Bishop bishop1 = new Bishop(color, position + offset, 2);
        Knight knight = new Knight(color, position + offset, 1);
        Knight knight1 = new Knight(color, position + offset, 6);
        Queen queen = new Queen(color, position + offset, 3);
        King king = new King(color, position + offset, 4);

        this.getTile(position, 0).setPiece(pawn);
        this.getTile(position, 1).setPiece(pawn1);
        this.getTile(position, 2).setPiece(pawn2);
        this.getTile(position, 3).setPiece(pawn3);
        this.getTile(position, 4).setPiece(pawn4);
        this.getTile(position, 5).setPiece(pawn5);
        this.getTile(position, 6).setPiece(pawn6);
        this.getTile(position, 7).setPiece(pawn7);
        this.getTile(position + offset, 0).setPiece(rook);
        this.getTile(position + offset, 7).setPiece(rook1);
        this.getTile(position + offset, 2).setPiece(bishop);
        this.getTile(position + offset, 5).setPiece(bishop1);
        this.getTile(position + offset, 1).setPiece(knight);
        this.getTile(position + offset, 6).setPiece(knight1);
        this.getTile(position + offset, 3).setPiece(queen);
        this.getTile(position + offset, 4).setPiece(king);

        player.addPiece(pawn);
        player.addPiece(pawn1);
        player.addPiece(pawn2);
        player.addPiece(pawn3);
        player.addPiece(pawn4);
        player.addPiece(pawn5);
        player.addPiece(pawn6);
        player.addPiece(pawn7);
        player.addPiece(rook);
        player.addPiece(rook1);
        player.addPiece(bishop);
        player.addPiece(bishop1);
        player.addPiece(knight);
        player.addPiece(knight1);
        player.addPiece(queen);
        player.addPiece(king);
        player.setKing(king);
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

    /**
     * Checks if there is no piece between tiles fromTile and toTile
     * If the piece from tile fromTile is a Knight the function returns true because
     * the Knight can jump
     * @param fromTile the starting point
     * @param toTile the ending point
     * @return true if the way is clear and false otherwise
     */
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

    /**
     * Checks if the requested move cand be made
     * @param player the player that makes the move
     * @param fromTile from
     * @param toTile to
     * @return true if the move was made and false otherwise
     */
    public boolean move(Player player, Tile fromTile, Tile toTile) {

        boolean moveMade = false;

        Piece movedPiece = fromTile.getPiece();
        if(player.getColor() != fromTile.getPiece().getColor()){
            //not your piece
            return false;
        }

        if(toTile.getPiece() != null && toTile.getPiece().getColor() == fromTile.getPiece().getColor()){
            //cannot capture your own piece
            return false;
        }

        if((movedPiece instanceof Pawn && movePawn(player, fromTile, toTile))){
            moveMade = validateMove(player, fromTile, toTile);
        } else if (movedPiece instanceof King && movedPiece.isMoveValid(fromTile, toTile) &&
                !isThreatenTile(player.getColor(), toTile, true)){
            moveMade = validateMove(player, fromTile, toTile);
        } else if(movedPiece instanceof King && (fromTile.getY() - 3 == toTile.getY() || fromTile.getY() + 2 == toTile.getY())
                && fromTile.getX() == toTile.getX()) {
            moveMade = tryToDoTheCastling(fromTile,toTile);
        } else if(movedPiece.isMoveValid(fromTile, toTile)
                && checkIfClearWay(fromTile, toTile) && !(movedPiece instanceof Pawn) && !(movedPiece instanceof King)){
            moveMade = validateMove(player, fromTile, toTile);
        }

        Tile kingTile = getTile(currentPlayer.getKing().getX(), currentPlayer.getKing().getY());
        if(isThreatenTile(currentPlayer.getColor(), kingTile, true)){
            this.isCheck = true;
            if(checkIfCheckMate(kingTile)){
                this.isCheckMate = true;
            }
        } else if(kingTile.getPiece().calculatePossibleMoves(this).size() == 0){
            this.isStaleMate = true;
            for(Piece piece: currentPlayer.getPieces()){
                if(piece.calculatePossibleMoves(this).size() != 0){
                    this.isStaleMate = false;
                }
            }
        } else {
            this.isCheck = false;
        }
        return moveMade;
    }

    //Make the move on the board
    /**
     * Moves the piece fromTile to toTile on the board
     * @param player the player who wants to move
     * @param fromTile from spot
     * @param toTile to spot
     */
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

        //If the pawn reached the end of the board it is promoted to Queen
        if(fromTile.getPiece() instanceof Pawn && (toTile.getX() == 0 || toTile.getX() == 7)){
            Queen queen = new Queen(player.getColor(), toTile.getX(), toTile.getY());
            toTile.setPiece(queen);
        } else {
            toTile.setPiece(fromTile.getPiece());
        }


        fromTile.setPiece(null);
    }

    /**
     * Makes the move on the board than checks if after the move the player is
     * in check. If the player is in check then the move is undone else it
     * calls the function makeMove to make the move on the board
     * @param player the player who wants to move
     * @param fromTile from spot
     * @param toTile to spot
     * @return true if the move could be made and false otherwise
     */
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
        if(!isThreatenTile(player.getColor(), kingTile, true)){
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

    /**
     * Checks if the pawn move is valid, if it can attack or if it can do the move En Passant
     * returns true
     * @param player
     * @param fromTile
     * @param toTile
     * @return true if move valid and false otherwise
     */
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

        if ((fromY + 1 == toY || fromY - 1 == toY) && fromX + rowOffset == toX){
            //if there is a piece on diagonal you can capture it
            if(!getTile(toX, toY).isEmptyTile()){
                return true;
            //checks if the move en passant is valid and takes the piece from lastMove and captures it
            } else if (lastMove != null && lastMove.getX() == toX - rowOffset &&
                    lastMove.getY() == toY && ((Pawn)lastMove.getPiece()).isJumpOneSpace()){
                removePiece(lastMove);
                lastMove.setPiece(null);
                return true;
            }
            return false;
        } else if(fromTile.getPiece().isMoveValid(fromTile, toTile) &&
                checkIfClearWay(fromTile, toTile) && getTile(toX, toY).isEmptyTile()){
            return true;
        }
        return false;
    }

    /**
     * Remove the piece from the board
     * @param tile the tile of the piece to be removed
     */
    private void removePiece(Tile tile){

        Piece piece = tile.getPiece();
        if(tile.getPiece().getColor() == Color.BLACK){
            removedBlackPieces.add(piece);
            blackPlayer.removePiece(piece);
        } else {
            removedWhitePieces.add(piece);
            whitePlayer.removePiece(piece);
        }
    }

    /**
     * Checks if the tile is threa
     * @param threatenedColor the color that is threatened
     * @param threatenedTile the Tile you want to see if it is threatened
     * @param canPawnAttack
     * @return
     */
    public boolean isThreatenTile(Color threatenedColor, Tile threatenedTile, boolean canPawnAttack){

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
                                    if(piece instanceof  King && kingThreats[direction])
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

    private boolean tryToDoTheCastling(Tile fromTile, Tile toTile){
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
                && checkIfClearWayOnLine(fromTile, rookTile ) && !isCheck) {
            for (int i = fromTile.getY() + colOffset; i != rookTile.getY(); i += colOffset) {
                if (isThreatenTile(fromTile.getPiece().getColor(), getTile(toTile.getX(), i), true)) {
                    return false;
                }
            }
        } else {
            return false;
        }

        makeMove(currentPlayer, fromTile, toTile);
        rookTile.getPiece().setX(newRookTile.getX());
        rookTile.getPiece().setY(newRookTile.getY());
        newRookTile.setPiece(rookTile.getPiece());
        rookTile.setPiece(null);
        newRookTile.getPiece().setFirstMove(false);
        return true;
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
        King king = currentPlayer.getKing();
        kingTile.setPiece(null);
        if(contenderPieceTile != null && !isThreatenTile(contenderColor, contenderPieceTile, true)){
            canInterceptPiece = false;
            if(!(contenderPieceTile.getPiece() instanceof  Knight)){
                if(!checkIfNoThreat(contenderColor, contenderPieceTile, kingTile)){
                    canInterceptPiece = true;
                }
            }
        }
        kingTile.setPiece(king);

        if(kingTile.getPiece().calculatePossibleMoves(this).size() == 0 && !canInterceptPiece){
            //check mate
            return true;
        }

        return false;
    }

    /**
     * Checks if there is no threat on the diagonal from the Tile fromTile to toTile
     * @param contenderColor color of the oponent's pieces
     * @param fromTile
     * @param toTile
     * @return true if there is no threat and false if there is a threat
     */
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

            if(isThreatenTile(contenderColor, getTile(i,j), false)){
                return false;
            }
            j += columnOffset;
        }

        return true;
    }

    /**
     * Checks if there is no threat on the line from the Tile fromTile to toTile
     * @param contenderColor color of the oponent's pieces
     * @param fromTile
     * @param toTile
     * @return true if there is no threat and false if there is a threat
     */
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
                if(isThreatenTile(contenderColor, getTile(i, toTile.getY()), false)){
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
                if (isThreatenTile(contenderColor, getTile(toTile.getX(), i), false)) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Checks if there is no threat from the Tile fromTile to toTile
     * @param contenderColor
     * @param fromTile
     * @param toTile
     * @return true if there is no threat and false if there is a threat
     */
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

}