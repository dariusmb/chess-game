import game.Board;
import game.Color;
import game.Tile;
import org.junit.jupiter.api.Test;
import pieces.Bishop;
import pieces.Knight;
import pieces.Pawn;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Bogdan Darius on 1/4/2018.
 */
public class TestPiece {

    @Test
    public void testBlackPawn(){
        Pawn pawn = new Pawn(Color.BLACK, 1, 0);
        Tile fromTile = new Tile(1, 0);
        Tile toTile = new Tile(3, 0);
        assertTrue(pawn.isMoveValid(fromTile, toTile), "Can move 2 spaces if firstMove");
        pawn.setFirstMove(false);
        assertFalse(pawn.isMoveValid(fromTile, toTile), "Can't move 2 spaces if not firstMove");
        toTile = new Tile(5, 0);
        assertFalse(pawn.isMoveValid(fromTile, toTile), "Can't move more spaces");
        toTile = new Tile(2, 0);
        assertTrue(pawn.isMoveValid(fromTile, toTile), "Can move one space");

        fromTile = new Tile(3, 0);
        toTile = new Tile(1, 0);
        assertFalse(pawn.isMoveValid(fromTile, toTile), "Can't move up");
        fromTile = new Tile(2, 0);
        assertFalse(pawn.isMoveValid(fromTile, toTile), "Can't move up");
    }

    @Test
    public void testWhitePawn(){
        Pawn pawn = new Pawn(Color.WHITE, 3, 0);
        Tile fromTile = new Tile(3, 0);
        Tile toTile = new Tile(1, 0);
        assertTrue(pawn.isMoveValid(fromTile, toTile), "Can move 2 spaces if firstMove");
        pawn.setFirstMove(false);
        assertFalse(pawn.isMoveValid(fromTile, toTile), "Can't move 2 spaces if not firstMove");
        toTile = new Tile(0, 0);
        assertFalse(pawn.isMoveValid(fromTile, toTile), "Can't move more spaces");
        toTile = new Tile(2, 0);
        assertTrue(pawn.isMoveValid(fromTile, toTile), "Can move one space");

        fromTile = new Tile(1, 0);
        toTile = new Tile(3, 0);
        assertFalse(pawn.isMoveValid(fromTile, toTile), "Can't move up");
        fromTile = new Tile(2, 0);
        assertFalse(pawn.isMoveValid(fromTile, toTile), "Can't move up");
    }

    @Test
    public void testKnight(){
        Knight knight = new Knight(Color.BLACK, 4, 4);
        Tile fromTile = new Tile(4,4);
        Tile toTile = new Tile(5,2);
        assertTrue(knight.isMoveValid(fromTile, toTile), "Valid move");
        toTile = new Tile(3, 2);
        assertTrue(knight.isMoveValid(fromTile, toTile), "Valid move");
        toTile = new Tile(6, 3);
        assertTrue(knight.isMoveValid(fromTile, toTile), "Valid move");
        toTile = new Tile(2, 3);
        assertTrue(knight.isMoveValid(fromTile, toTile), "Valid move");
        toTile = new Tile(2, 5);
        assertTrue(knight.isMoveValid(fromTile, toTile), "Valid move");
        toTile = new Tile(3, 6);
        assertTrue(knight.isMoveValid(fromTile, toTile), "Valid move");
        toTile = new Tile(5, 6);
        assertTrue(knight.isMoveValid(fromTile, toTile), "Valid move");
        toTile = new Tile(6, 5);
        assertTrue(knight.isMoveValid(fromTile, toTile), "Valid move");
        toTile = new Tile(5, 1);
        assertFalse(knight.isMoveValid(fromTile, toTile));
    }

    @Test
    public void testBishop(){
        Bishop bishop = new Bishop(Color.BLACK, 0, 1);
        Tile fromTile = new Tile(0, 1);
        Tile toTile = new Tile(2,3);

        assertTrue(bishop.isMoveValid(fromTile, toTile), "Can move diagonal");
        toTile = new Tile(1, 0);
        assertTrue(bishop.isMoveValid(fromTile, toTile), "Can move diagonal");
        toTile = new Tile(1, 1);
        assertFalse(bishop.isMoveValid(fromTile, toTile), "Can't move on line");
    }
}
