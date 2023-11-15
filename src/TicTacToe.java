import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import java.util.Random;

public class TicTacToe extends JFrame {
    private char whoseTurn = 'X';
    private Cell[][] cells;
    private JLabel jlblStatus = new JLabel("\nEnter player names and click Start");
    private JTextField jtfPlayer1 = new JTextField();
    private JTextField jtfPlayer2 = new JTextField();
    private JButton btnStart = new JButton("Start");
    private JButton btnReset = new JButton("Reset");
    private JButton btnEndPage1 = new JButton("End");
    private JButton btnEndPage2 = new JButton("End");
    private JButton btnInstructions = new JButton("Instructions");
    private JLabel jlblPlayer1Score = new JLabel(jtfPlayer1.getText() + "'s Score: 0");
    private JLabel jlblPlayer2Score = new JLabel(jtfPlayer2.getText() + "'s Score: 0");
    private int player1Score = 0;
    private int player2Score = 0;
    private boolean gameStarted = false;

    private JPanel mainPanel;
    private JPanel gamePanel;
    private JPanel controlPanel;
    private JPanel scorePanel;
    private JComboBox<Integer> gridSizeComboBox;

    public TicTacToe() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mainPanel = new JPanel(new CardLayout());

        // First Page
        JPanel firstPagePanel = createFirstPagePanel();
        mainPanel.add(firstPagePanel, "firstPage");

        // Second Page
        JPanel secondPagePanel = createSecondPagePanel();
        mainPanel.add(secondPagePanel, "secondPage");

        add(mainPanel);

        setTitle("Tic Tac Toe");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    private JPanel createFirstPagePanel() {
        JPanel firstPagePanel = new JPanel(new BorderLayout());
        firstPagePanel.setBackground(new Color(255, 255, 255));

        JPanel inputPanel = new JPanel(new GridLayout(5, 1, 5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        inputPanel.setBackground(new Color(230, 230, 230));

        JLabel lblPlayer1 = new JLabel("'X' player name :");
        lblPlayer1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        inputPanel.add(lblPlayer1);
        jtfPlayer1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        inputPanel.add(jtfPlayer1);

        JLabel lblPlayer2 = new JLabel("'O' player name :");
        lblPlayer2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        inputPanel.add(lblPlayer2);
        jtfPlayer2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        inputPanel.add(jtfPlayer2);

        gridSizeComboBox = new JComboBox<>(new Integer[]{3, 4, 5});
        gridSizeComboBox.setSelectedIndex(0);
        gridSizeComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        inputPanel.add(new JLabel("Grid Size:"));
        inputPanel.add(gridSizeComboBox);

        btnStart.setBackground(new Color(92, 184, 92));
        btnStart.setForeground(Color.black);
        btnStart.setPreferredSize(new Dimension(80, 50));
        btnStart.addActionListener(e -> {
            String player1Name = jtfPlayer1.getText();
            String player2Name = jtfPlayer2.getText();

            if (player1Name.isEmpty() && player2Name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter valid names in both boxes");
            } else if (player1Name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a valid name in the first box");
            } else if (player2Name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a valid name in the second box");
            } else if (player1Name.equals(player2Name)) {
                JOptionPane.showMessageDialog(this, "Please enter different names in the boxes");
            } else {
                int selectedGridSize = (int) gridSizeComboBox.getSelectedItem();
                initializeGame(selectedGridSize);
            }
        });

        btnInstructions.setBackground(new Color(255, 255, 0));
        btnInstructions.setForeground(Color.black);
        btnInstructions.setPreferredSize(new Dimension(105, 50));
        btnInstructions.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Instructions:\n\n" +
                    "- The game is played on a grid of cells.\n" +
                    "- Each player takes turns marking a cell with their symbol ('X' or 'O').\n" +
                    "- The goal is to get three of their symbols in a row (horizontally, vertically, or diagonally).\n" +
                    "- The game ends when a player wins, or there are no more empty cells (a draw).\n\n" +
                    "Enter the names of the players and click 'Start' to begin playing.");
        });
        
        btnEndPage1.setBackground(new Color(217, 83, 79));
        btnEndPage1.setForeground(Color.black);
        btnEndPage1.setPreferredSize(new Dimension(100,50));
        btnEndPage1.addActionListener(e -> {
            int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to end the game?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(this, "Thank you for playing!");
                System.exit(0);
            }
        });

        JPanel controlPanel = new JPanel(new FlowLayout());
        controlPanel.setBackground(new Color(255, 255, 255));
        controlPanel.add(btnStart);
        controlPanel.add(btnInstructions);
        controlPanel.add(btnEndPage1);
        
        JPanel btnPanel = new JPanel(new BorderLayout());
        btnPanel.add(controlPanel, BorderLayout.CENTER);

        JLabel lblWelcome = new JLabel("Welcome to Tic Tac Toe");
        lblWelcome.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
        lblWelcome.setVerticalAlignment(SwingConstants.CENTER);
        lblWelcome.setPreferredSize(new Dimension(400, 80));
        firstPagePanel.add(lblWelcome, BorderLayout.NORTH);
        firstPagePanel.add(inputPanel, BorderLayout.CENTER);
        firstPagePanel.add(controlPanel, BorderLayout.SOUTH);

        return firstPagePanel;
    }

    private JPanel createSecondPagePanel() {
        JPanel secondPagePanel = new JPanel(new BorderLayout());
        secondPagePanel.setBackground(new Color(255, 255, 255));

        gamePanel = new JPanel();
        gamePanel.setBackground(new Color(0, 128, 0));
        gamePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        jlblStatus.setFont(new Font("Times New Roman", Font.BOLD, 16));
        jlblStatus.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        jlblStatus.setHorizontalAlignment(SwingConstants.CENTER);
        
        btnEndPage2.setBackground(new Color(217, 83, 79));
        btnEndPage2.setForeground(Color.white);
        btnEndPage2.setPreferredSize(new Dimension(80, 30));
        btnEndPage2.addActionListener(e -> {
            int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to end the game?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(this, "Thank you for playing!");
                System.exit(0);
            }
        });

        btnReset.setBackground(new Color(217, 83, 79));
        btnReset.setForeground(Color.white);
        btnReset.setPreferredSize(new Dimension(80, 30));
        btnReset.addActionListener(e -> {
            resetGame();
            jtfPlayer1.setEnabled(true);
            jtfPlayer2.setEnabled(true);
            btnStart.setEnabled(true);
            player1Score = 0;
            player2Score = 0;
            jlblPlayer1Score.setText(jtfPlayer1.getText() + "'s Score: 0");
            jlblPlayer2Score.setText(jtfPlayer2.getText() + "'s Score: 0");
            gameStarted = false;
            CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
            cardLayout.show(mainPanel, "firstPage");
        });

        controlPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        controlPanel.setBackground(new Color(230, 230, 230));
        controlPanel.add(btnReset);
        controlPanel.add(btnEndPage2);

        scorePanel = new JPanel(new GridLayout(3, 1, 5, 5));
        scorePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        scorePanel.setBackground(new Color(230, 230, 230));
        scorePanel.add(jlblPlayer1Score);
        scorePanel.add(jlblPlayer2Score);
        scorePanel.add(jlblStatus);

        secondPagePanel.add(gamePanel, BorderLayout.CENTER);
        secondPagePanel.add(Box.createVerticalStrut(10), BorderLayout.SOUTH);
        secondPagePanel.add(controlPanel, BorderLayout.NORTH);
        secondPagePanel.add(scorePanel, BorderLayout.EAST);

        return secondPagePanel;
    }

    private void initializeGame(int gridSize) {
        cells = new Cell[gridSize][gridSize];
        gamePanel.removeAll();
        gamePanel.setLayout(new GridLayout(gridSize, gridSize));

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                cells[i][j] = new Cell();
                gamePanel.add(cells[i][j]);
            }
        }

        Random random = new Random();
        whoseTurn = random.nextBoolean() ? 'X' : 'O';

        jlblStatus.setText(getCurrentPlayerName() + "'s turn");
        enableGame();
        gameStarted = true;
        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
        cardLayout.show(mainPanel, "secondPage");

        revalidate();
        repaint();
        
        jlblPlayer1Score.setText(jtfPlayer1.getText() + "'s Score: 0");
        jlblPlayer2Score.setText(jtfPlayer2.getText() + "'s Score: 0");
    }

    private void enableGame() {
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                cell.setEnabled(true);
            }
        }
        jtfPlayer1.setEnabled(false);
        jtfPlayer2.setEnabled(false);
        btnStart.setEnabled(false);
    }

    private void disableGame() {
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                cell.setEnabled(false);
            }
        }

        // Reset the game after 1.3 seconds
        Timer timer = new Timer(1300, e -> resetGame());
        timer.setRepeats(false); // Run the timer only once
        timer.start();
    }

    private void resetGame() {
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                cell.setToken(' ');
            }
        }
        whoseTurn = 'X';
        jlblStatus.setText(getCurrentPlayerName() + "'s turn");
        enableGame();
    }

    public boolean isFull() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (cells[i][j].getToken() == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isWon(char token) {
        int gridSize = cells.length;

        for (int i = 0; i < gridSize; i++) {
            boolean rowWin = true;
            boolean columnWin = true;
            for (int j = 0; j < gridSize; j++) {
                if (cells[i][j].getToken() != token) {
                    rowWin = false;
                }
                if (cells[j][i].getToken() != token) {
                    columnWin = false;
                }
            }
            if (rowWin || columnWin) {
                return true;
            }
        }

        boolean diagonalWin1 = true;
        boolean diagonalWin2 = true;
        for (int i = 0; i < gridSize; i++) {
            if (cells[i][i].getToken() != token) {
                diagonalWin1 = false;
            }
            if (cells[i][gridSize - 1 - i].getToken() != token) {
                diagonalWin2 = false;
            }
        }
        return diagonalWin1 || diagonalWin2;
    }

    private class Cell extends JButton {
        private char token = ' ';
        int selectedGridSize = (int) gridSizeComboBox.getSelectedItem();

        public Cell() {
            setPreferredSize(new Dimension(60, 60));
            if (selectedGridSize == 3) {
                setFont(new Font("Sans Serif", Font.BOLD, 100));
            } else if (selectedGridSize == 4) {
                setFont(new Font("Sans Serif", Font.BOLD, 80));
            } else if (selectedGridSize == 5) {
                setFont(new Font("Sans Serif", Font.BOLD, 50));
            } else {
                setFont(new Font("Sans Serif", Font.BOLD, 40));
            }
            setFocusPainted(false);
            setBorder(BorderFactory.createLineBorder(Color.black));
            addActionListener(new MyActionListener());
        }

        public char getToken() {
            return token;
        }

        public void setToken(char token) {
            this.token = token;
            
            if (token == 'X') {
                setForeground(Color.BLUE);
                UIManager.put("Button.background", Color.black);
            } else if (token == 'O') {
                setForeground(Color.MAGENTA);
                UIManager.put("Button.background", Color.black);
            }
            
            setText(Character.toString(token));
            setEnabled(true);
            updateUI();
        }

        private class MyActionListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gameStarted && token == ' ' && whoseTurn != ' ') {
                    setToken(whoseTurn);

                    if (isWon(whoseTurn)) {
                        jlblStatus.setText(getCurrentPlayerName() + " wins!");
                        disableGame();
                        updateScores();
                        whoseTurn = (whoseTurn == 'X') ? 'O' : 'X';
                    } else if (isFull()) {
                        jlblStatus.setText("It's a draw!");
                        disableGame();
                        whoseTurn = ' ';
                    } else {
                        whoseTurn = (whoseTurn == 'X') ? 'O' : 'X';
                        jlblStatus.setText(getCurrentPlayerName() + "'s turn");
                    }
                }
            }
        }
    }

    private String getCurrentPlayerName() {
        return (whoseTurn == 'X') ? jtfPlayer1.getText() : jtfPlayer2.getText();
    }

    private void updateScores() {
        if (whoseTurn == 'X') {
            player1Score++;
            jlblPlayer1Score.setText(jtfPlayer1.getText() + "'s Score : " + player1Score);
        } else {
            player2Score++;
            jlblPlayer2Score.setText(jtfPlayer2.getText() + "'s Score : " + player2Score);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TicTacToe::new);
    }
}