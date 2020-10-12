package TicTacToe;

public class TicTacToe
{
   private int turn;
   private String[][] board;
    
    public TicTacToe(){
        turn = 0;
        board = new String[3][3];
        
        for(int i = 0; i < board[0].length; i++){
            for(int j = 0; j < board[1].length; j++){
                board[i][j] = " ";
            }
        }
    }
    
    public TicTacToe(TicTacToe other) {
    	turn = other.getTurn();
    	board = other.getBoard();
    }
    
    public String[][] getBoard(){
        return board;
    }
    
    public void reset() {
    	turn = 0; 
    	
    	for(int i = 0; i < board[0].length; i++){
            for(int j = 0; j < board[1].length; j++){
                board[i][j] = " ";
            }
        }
    }
   
   public int getTurn()
   {
       return turn;
   }
   
   public void printBoard()
   {
       System.out.println("\t     |     |     \n"
       					+ "\t  "+board[0][0]+"  |  "+board[0][1]+"  |  "+board[0][2]+"  \n"
       					+ "\t_____|_____|_____\n"
       					+ "\t     |     |     \n"
       					+ "\t  "+board[1][0]+"  |  "+board[1][1]+"  |  "+board[1][2]+"  \n"
       					+ "\t_____|_____|_____\n"
       					+ "\t     |     |     \n"
       					+ "\t  "+board[2][0]+"  |  "+board[2][1]+"  |  "+board[2][2]+"  \n"
       					+ "\t     |     |     \n");
   }
   
   public boolean spaceValid(int row, int col)
   {
       if(row >= board[0].length || col >= board[1].length){
           return false;
       }
       return board[row][col] == " ";
   }
   
   public void takeTurn(int row, int col)
   {
       board[row][col] = (turn % 2 == 0) ? "X":"O";
       turn++;
   }
   
   public void undoSpace(int row,int col) {
	   board[row][col] = " ";
	   turn--;
   }
   
   public boolean checkRow()
   {
       for(String[] row : board){
           if(!row[0].equals(" ") && row[0].equals(row[1]) && row[0].equals(row[2])){
               return true;
           }
       }
       return false;
   }
   
   public boolean checkCol()
   {
       for(int i = 0; i < board[1].length; i++){
           if(!board[0][i].equals(" ") && board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i])){
               return true;
           }
       }
       return false;
   }
   
   public boolean checkDiag()
   {
       return !board[1][1].equals(" ") && ((board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2])) || (board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0])));
   }
   
   public boolean checkWin()
   {
       return checkRow() || checkCol() || checkDiag();
   }
   
   public boolean boardEmpty(){
       for(String[] row : board){
           for(String col : row){
               if(col.equals(" ")){
                   return false;
               }
           }
       }
       return true;
   }
   
   public boolean gameOver(){
       return checkWin() || boardEmpty();
   }
}