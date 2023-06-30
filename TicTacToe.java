import java.util.Scanner;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;
    
    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        initializeBoard();
    }
    
    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }
    
    private void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isWinningMove(int row, int col) {
        // Check rows and columns
        if (board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
            return true;
        }
        if (board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
            return true;
        }
        
        // Check diagonals
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[1][1] != '-') {
            return true;
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[1][1] != '-') {
            return true;
        }
        
        return false;
    }
    
    private void makeMove(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != '-') {
            System.out.println("Invalid move. Try again.");
            return;
        }
        
        board[row][col] = currentPlayer;
        
        if (isWinningMove(row, col)) {
            System.out.println("Player " + currentPlayer + " wins!");
            System.exit(0);
        } else if (isBoardFull()) {
            System.out.println("It's a tie!");
            System.exit(0);
        }
        
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
    
    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Let's play Tic-Tac-Toe!");
        System.out.println("Enter row (0-2) and column (0-2) separated by a space to make a move.");
        
        while (true) {
            System.out.println("\nCurrent board:");
            printBoard();
            
            System.out.print("Player " + currentPlayer + ", make your move: ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            
            makeMove(row, col);
        }
    }
    
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.playGame();
    }
}
