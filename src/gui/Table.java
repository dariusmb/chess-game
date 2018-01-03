package gui;

import game.*;
import pieces.Piece;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

import static java.awt.Color.BLACK;
import static javax.swing.SwingUtilities.invokeLater;
import static javax.swing.SwingUtilities.isLeftMouseButton;
import static javax.swing.SwingUtilities.isRightMouseButton;

/**
 * Created by Bogdan Darius on 1/2/2018.
 */
public class Table {

    private final JFrame gameFrame;
    private final TakenPiecesPanel takenPiecesPanel;
    private final BoardPanel boardPanel;
    private final Board chessBoard;
    private Tile fromTile;
    private Tile toTile;
    private Piece movedPiece;

    private final static Dimension OUTER_FRAME_DIMENSION = new Dimension(700, 700);
    private final static Dimension BOARD_PANEL_DIMENSION = new Dimension(600, 600);
    private final static Dimension TILE_PANEL_DIMENSION = new Dimension(10, 10);
    private static String pieceIconPath = "src/resources/";
    private Color lightTileColor = Color.decode("#FFFFFF");
    private Color darkTileColor = Color.decode("#000000");

    public Table(){
        this.gameFrame = new JFrame("Chess");
        this.gameFrame.setLayout(new BorderLayout());
        this.gameFrame.setSize(OUTER_FRAME_DIMENSION);
        this.chessBoard = new Board();
        chessBoard.initializeBoard();
        this.takenPiecesPanel = new TakenPiecesPanel();
        this.boardPanel = new BoardPanel();
        this.gameFrame.add(this.boardPanel, BorderLayout.CENTER);
        this.gameFrame.add(this.takenPiecesPanel, BorderLayout.EAST);
        this.gameFrame.setVisible(true);
        this.gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private class BoardPanel extends JPanel {
        final List<TilePanel> boardTiles;

        BoardPanel() {
            super(new GridLayout(8, 8));
            this.boardTiles = new ArrayList<>();
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){
                    final TilePanel tilePanel = new TilePanel(this, i, j);
                    this.boardTiles.add(tilePanel);
                    add(tilePanel);
                }
            }
            setPreferredSize(BOARD_PANEL_DIMENSION);
            validate();
        }

        public void drawBoard(final Board board){
            removeAll();
            for(final TilePanel tilePanel: boardTiles){
                tilePanel.drawTile(board);
                add(tilePanel);
            }
            validate();
            repaint();
        }
    }



    private class TilePanel extends JPanel {

        private final int tileRow;
        private final int tileCol;

        TilePanel(final BoardPanel boardPanel, final int tileRow, final int tileCol){
//            super(new GridBagLayout());
            this.tileRow = tileRow;
            this.tileCol = tileCol;
            setPreferredSize(TILE_PANEL_DIMENSION);
            assignTileColor(tileRow, tileCol);
            assignTilePieceIcon(chessBoard);
            addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(final MouseEvent e) {

                    if(isRightMouseButton(e)) {
                        fromTile = null;
                        toTile = null;
                        movedPiece = null;
                    } else if(isLeftMouseButton(e)) {
                        //first click on a tile
                        System.out.println(fromTile + " " + toTile);
                        if(fromTile == null){
                            if(chessBoard.getTile(tileRow, tileCol).getPiece() != null &&
                                    chessBoard.getTile(tileRow, tileCol).getPiece().getColor() == chessBoard.getCurrentPlayer().getColor()){
                                fromTile = chessBoard.getTile(tileRow, tileCol);
                                movedPiece = fromTile.getPiece();
                            }
                            if(movedPiece == null){
                                fromTile = null;
                            }
                        } else {
                            //if another tile is clicked before
                            toTile = chessBoard.getTile(tileRow, tileCol);
                            if(chessBoard.getCurrentPlayer().getColor() == fromTile.getPiece().getColor()){
                                chessBoard.move(chessBoard.getCurrentPlayer(), fromTile, toTile);
                                fromTile = null;
                                toTile = null;
                                movedPiece = null;
                            }
                            invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    takenPiecesPanel.redo(chessBoard);
                                    boardPanel.drawBoard(chessBoard);
                                }
                            });
                        }
                    }
                }

                @Override
                public void mousePressed(final MouseEvent e) {

                }

                @Override
                public void mouseReleased(final MouseEvent e) {

                }

                @Override
                public void mouseEntered(final MouseEvent e) {

                }

                @Override
                public void mouseExited(final MouseEvent e) {

                }
            });
            validate();
        }

        public void drawTile(final Board board){
            assignTileColor(this.tileRow, this.tileCol);
            assignTilePieceIcon(board);
            validate();
            repaint();
        }

        private void assignTilePieceIcon(final Board board) {
            this.removeAll();
            if(board.getTile(this.tileRow, this.tileCol).getPiece() != null) {
                try {
                    final BufferedImage image = ImageIO.read(new File(pieceIconPath + board.getTile(this.tileRow, this.tileCol).getPiece() + ".png"));
                    add(new JLabel(new ImageIcon(image)));
                } catch(IOException e){
                    e.printStackTrace();
                }
            }
        }

        private void assignTileColor(int tileRow, int tileCol) {

            if(tileRow == 0 || tileRow == 2 || tileRow == 4 || tileRow == 6){
                setBackground(tileCol % 2 == 0 ? lightTileColor : darkTileColor);
            } else if (tileRow == 1 || tileRow == 3 || tileRow == 5 || tileRow == 7){
                setBackground(tileCol % 2 != 0 ? lightTileColor : darkTileColor);
            }
        }
    }
}
