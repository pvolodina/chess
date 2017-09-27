package GUI;
import main.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;

public class Game {

    /**
     * Constructor for the Game class, which initializes the GUI and game board
     */
    public Game() {
        GridLayout layout = new GridLayout(8, 8);
        JFrame board = new JFrame();
        board.setVisible(true);
        board.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        board.setSize(700, 700);
        board.setLayout(layout);

        initGameBoard(board);
    }

    /**
     * Function that initializes the game board and grid buttons with their icons
     * @param gameBoard the JFrame object of the board
     */
    private void initGameBoard(JFrame gameBoard) {
        Board board = new Board();
        int rowSize = board.getRowSize();
        int colSize = board.getColSize();
        board.initPieces(board, false);
        JPanel grid[][] = new JPanel[rowSize][colSize];
        JButton button[][] = new JButton[rowSize][colSize];

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                button[i][j] = new JButton();
                JButton jButton = button[i][j];
                jButton.setPreferredSize(new Dimension(80, 80));
                grid[i][j] = new JPanel();
                grid[i][j].add(jButton);
                gameBoard.add(grid[i][j]);

                // places the icons of the game pieces at their positions on the board
                Piece piece = board.getPiece(i, j);
                if (piece != null) {
                    BufferedImage image = getImage(piece);
                    assert image != null;
                    jButton.setIcon(new ImageIcon(image));
                }
            }
        }
    }

    /**
     * Function that retrieves the icons of the chess pieces from the images folder
     * @param piece the piece for which icon is to be retrieved
     * @return a static image icon for the piece
     */
    private static BufferedImage getImage(Piece piece) {
        Map<String, BufferedImage> imageMap = new HashMap<>();
        String pieceName = piece.getClass().getSimpleName();
        String playerLabel;
        if (piece.getPlayer() == 1) {
            playerLabel = "_white";
        } else {
            playerLabel = "_black";
        }
        String fileName = pieceName + playerLabel;
        BufferedImage image = null;
        try {
            image = ImageIO.read(Game.class.getResourceAsStream("images/" + fileName + ".png"));
        } catch (IOException e) {
            System.out.println("Exception caught!");
        }

        imageMap.put(fileName, image);

        return imageMap.get(fileName);
    }
}
