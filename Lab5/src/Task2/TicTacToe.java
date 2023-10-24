package Task2;

public class TicTacToe {
	private static final char EMPTY = ' ';
	private char[][] board;

	// Constructor to initialize the Tic-Tac-Toe board
	public TicTacToe() {
		board = new char[3][3];
		// Initialize the board with empty characters
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = EMPTY;
			}
		}
	}

	// Other methods for updating the board...

	/*
	 * This method checks all rows and returns true if any of them are marked with
	 * all of a single player's markers. Otherwise, returns false.
	 */
	public boolean checkRows() {
		for (int row = 0; row < 3; row++) {
			if (board[row][0] != EMPTY && board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
				return true;
			}
		}
		return false;
	}

	/*
	 * This method checks all columns and returns true if any of them are marked
	 * with all of a single player's markers. Otherwise, returns false.
	 */
	public boolean checkColumns() {
		for (int col = 0; col < 3; col++) {
			if (board[0][col] != EMPTY && board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
				return true;
			}
		}
		return false;
	}

	/*
	 * This method checks both diagonals and returns true if any of them are marked
	 * with all of a single player's markers. Otherwise, returns false.
	 */
	public boolean checkDiagonals() {
		// Check top-left to bottom-right diagonal
		if (board[0][0] != EMPTY && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
			return true;
		}

		// Check bottom-left to top-right diagonal
		if (board[0][2] != EMPTY && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
			return true;
		}

		return false;
	}

	    public static void main(String[] args) {
	        TicTacToe game = new TicTacToe();
	        game.placeMarker(0, 0, 'X'); // Example: Player X places a marker at (0, 0)
	        game.placeMarker(1, 1, 'O'); // Example: Player O places a marker at (1, 1)
	        // Continue placing markers...

	        // Print the current state of the board
	        game.printBoard();

	        // Check for a win
	        if (game.checkRows() || game.checkColumns() || game.checkDiagonals()) {
	            System.out.println("Player wins!");
	        } else {
	            System.out.println("No win yet.");
	        }
	    }

		private void printBoard() {
			// TODO Auto-generated method stub
			
		}

		private void placeMarker(int i, int j, char c) {
			// TODO Auto-generated method stub
			
		}
	}


