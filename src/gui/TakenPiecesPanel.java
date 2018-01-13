package gui;

import game.*;
import pieces.Piece;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bogdan Darius on 1/3/2018.
 */
class TakenPiecesPanel extends JPanel {

    private final JPanel upPanel;
    private final JPanel downPanel;
    private static final Color PANEL_COLOR = Color.decode("#f4f4f4");
    private static final Dimension TAKEN_PIECES_DIMENSION = new Dimension(120, 80);
    TakenPiecesPanel() {
        super(new BorderLayout());
        setBackground(PANEL_COLOR);
        this.upPanel = new JPanel();
        upPanel.setLayout(new GridLayout(8, 2));
        this.downPanel = new JPanel();
        downPanel.setLayout(new GridLayout(8, 2));
        this.upPanel.setBackground(PANEL_COLOR);
        this.downPanel.setBackground(PANEL_COLOR);
        this.add(this.upPanel, BorderLayout.NORTH);
        this.add(this.downPanel, BorderLayout.SOUTH);
        setPreferredSize(TAKEN_PIECES_DIMENSION);
    }

    void redo(final Board board){

        this.downPanel.removeAll();
        this.upPanel.removeAll();

        final List<Piece> whiteTakenPieces = new ArrayList<>();
        final List<Piece> blackTakenPieces = new ArrayList<>();

        for(final Piece piece: board.getRemovedPieces()){
            if(piece.getColor() == game.Color.BLACK){
                blackTakenPieces.add(piece);
            } else if (piece.getColor() == game.Color.WHITE){
                whiteTakenPieces.add(piece);
            } else {
                throw new RuntimeException("should not reach here");
            }
        }
        for(final Piece takenPiece: whiteTakenPieces){
            try{
                final BufferedImage image = ImageIO.read(new File("src/resources/" + takenPiece.toString() + ".png"));
                final ImageIcon icon = new ImageIcon(image);
                final JLabel imageLabel = new JLabel(new ImageIcon(icon.getImage().getScaledInstance(
                        icon.getIconWidth() - 40, icon.getIconHeight() - 40, Image.SCALE_SMOOTH)));
                this.downPanel.add(imageLabel);
            } catch(final IOException e){
                e.printStackTrace();
            }
        }

        for(final Piece takenPiece: blackTakenPieces){
            try{
                final BufferedImage image = ImageIO.read(new File("src/resources/" + takenPiece.toString() + ".png"));
                final ImageIcon icon = new ImageIcon(image);
                final JLabel imageLabel = new JLabel(new ImageIcon(icon.getImage().getScaledInstance(
                        icon.getIconWidth() - 40, icon.getIconHeight() - 40, Image.SCALE_SMOOTH)));
                this.upPanel.add(imageLabel);
            } catch(final IOException e){
                e.printStackTrace();
            }
        }
        downPanel.repaint();
        upPanel.repaint();
        validate();
    }


}
