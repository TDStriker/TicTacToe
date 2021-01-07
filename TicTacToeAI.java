package TicTacToe;

public class TicTacToeAI {
	private static int[][] positions; 
	private static int PLAYER;
	private static int COMPUTER;
	
	public static void takeTurn(TicTacToe board) {
		positions = new int[3][3];
		COMPUTER = board.getTurn() % 2;
		PLAYER = 1 - COMPUTER;
		calculateBranch(board, board.getTurn());
		int row = 0;
		int col = 0;
		for(int i = 0; i < positions.length; i++) {
			for(int j = 0; j < positions.length; j++) {
				if((board.getTurn() % 2 == COMPUTER && positions[i][j] > positions[row][col]) || (board.getTurn() % 2 == PLAYER && positions[i][j] < positions[row][col])){
					row = i;
					col = j;
				}
			}
		}
		board.takeTurn(row, col);
	}
	
	public static int calculateBranch(TicTacToe board, int startingTurn) {		
		int[][] options = new int[3][3];
		
		for(int row = 0; row < positions.length; row++) {
			for(int col = 0; col < positions.length; col++) {
				if(board.spaceValid(row, col)) {
					board.takeTurn(row, col);
					if(board.gameOver()) {
						if(board.checkWin()) {
							if(board.getTurn() % 2 == PLAYER) {
								options[row][col] = 100 / board.getTurn();
							}else {
								options[row][col] = -100 / board.getTurn();
							}
						}
					}else {
						options[row][col] = calculateBranch(board,startingTurn);
					}
					board.undoSpace(row, col);
				}else {
					options[row][col] = board.getTurn() % 2 == COMPUTER ? Integer.MIN_VALUE : Integer.MAX_VALUE;
				}
			}
		}
		if(board.getTurn() == startingTurn) {
			for(int i = 0; i < options.length; i++) {
				for(int j = 0; j < options.length; j++) {
					positions[i][j] = options[i][j];
				}
			}
		}else {
			int row = 0;
			int col = 0;
			for(int i = 0; i < options.length; i++) {
				for(int j = 0; j < options.length; j++) {
					if((board.getTurn() % 2 == COMPUTER && options[i][j] > options[row][col]) || (board.getTurn() % 2 == PLAYER && options[i][j] < options[row][col])){
						row = i;
						col = j;
					}
				}
			}
			return options[row][col];
		}
		
		return 0;
	}
}
