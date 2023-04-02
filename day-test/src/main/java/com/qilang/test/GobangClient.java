package com.qilang.test;

/**
 * @Author huql
 * @Description $
 * @Date $ $
 **/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GobangClient extends JFrame implements ActionListener {
    private static final int ROWS = 15;
    private static final int COLS = 15;
    private static final int CELL_SIZE = 30;
    private static final int CANVAS_WIDTH = CELL_SIZE * COLS;
    private static final int CANVAS_HEIGHT = CELL_SIZE * ROWS;
    private static final int GRID_WIDTH = 2;
    private static final int GRID_HALF_WIDTH = GRID_WIDTH / 2;
    private static final Color COLOR_GRID = Color.BLACK;
    private static final Color COLOR_PLAYER1 = Color.WHITE;
    private static final Color COLOR_PLAYER2 = Color.BLACK;

    private JPanel board;
    private JLabel statusBar;
    private int[][] boardState;
    private int currentPlayer;

    public GobangClient() {
        board = new JPanel(new GridLayout(ROWS, COLS));
        board.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
        board.setBackground(Color.ORANGE);
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                board.add(new Cell(row, col));
            }
        }
        board.setBorder(BorderFactory.createLineBorder(COLOR_GRID, GRID_HALF_WIDTH));

        statusBar = new JLabel("Player 1's turn");
        statusBar.setBorder(BorderFactory.createEmptyBorder(2, 5, 4, 5));

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(board, BorderLayout.CENTER);
        cp.add(statusBar, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setTitle("Gobang");
        setVisible(true);

        boardState = new int[ROWS][COLS];
        currentPlayer = 1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Cell cell = (Cell) e.getSource();
        int row = cell.getRow();
        int col = cell.getCol();
        if (boardState[row][col] != 0) {
            return;
        }
        boardState[row][col] = currentPlayer;
        cell.setPlayer(currentPlayer);
        if (isWin(row, col)) {
            statusBar.setText("Player " + currentPlayer + " wins!");
            JOptionPane.showMessageDialog(this, "Player " + currentPlayer + " wins!");
            reset();
        } else if (isDraw()) {
            statusBar.setText("Game is draw");
            JOptionPane.showMessageDialog(this, "Game is draw");
            reset();
        } else {
            currentPlayer = 3 - currentPlayer;
            statusBar.setText("Player " + currentPlayer + "'s turn");
        }
    }

    private boolean isWin(int row, int col) {
        int player = boardState[row][col];
        int count = 0;
        for (int i = row - 4; i <= row + 4; i++) {
            if (i < 0 || i >= ROWS) {
                continue;
            }
            if (boardState[i][col] == player) {
                count++;
                if (count == 5) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        count = 0;
        for (int j = col - 4; j <= col + 4; j++) {
            if (j < 0 || j >= COLS) {
                continue;
            }
            if (boardState[row][j] == player) {
                count++;
                if (count == 5) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        count = 0;
        for (int i = row - 4, j = col - 4; i <= row + 4; i++, j++) {
            if (i < 0 || i >= ROWS || j < 0 || j >= COLS) {
                continue;
            }
            if (boardState[i][j] == player) {
                count++;
                if (count == 5) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        count = 0;
        for (int i = row - 4, j = col + 4; i <= row + 4; i++, j--) {
            if (i < 0 || i >= ROWS || j < 0 || j >= COLS) {
                continue;
            }
            if (boardState[i][j] == player) {
                count++;
                if (count == 5) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }

    private boolean isDraw() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (boardState[row][col] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private void reset() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                boardState[row][col] = 0;
                Cell cell = (Cell) board.getComponent(row * COLS + col);
                cell.setPlayer(0);
            }
        }
        currentPlayer = 1;
        statusBar.setText("Player 1's turn");
    }

    private class Cell extends JPanel {
        private int row;
        private int col;
        private int player;

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
            this.player = 0;
            setPreferredSize(new Dimension(CELL_SIZE, CELL_SIZE));
            setBorder(BorderFactory.createLineBorder(COLOR_GRID, GRID_WIDTH));
            setBackground(Color.LIGHT_GRAY);
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    actionPerformed(new ActionEvent(Cell.this, ActionEvent.ACTION_PERFORMED, null));
                }
            });
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

        public int getPlayer() {
            return player;
        }

        public void setPlayer(int player) {
            this.player = player;
            setBackground(player == 1 ? COLOR_PLAYER1 : player == 2 ? COLOR_PLAYER2 : Color.LIGHT_GRAY);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GobangClient::new);
    }
}
