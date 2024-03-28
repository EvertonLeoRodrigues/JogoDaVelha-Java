package classes;


public class NoughtsAndCrosses{
    private char[][] board;
    private int dimension;
    
    public NoughtsAndCrosses(int dimension){
        
        this.dimension = dimension;
        this.board = new char[dimension][dimension];

    }

    public boolean makeAMove(int row, int col, char symbol) throws IllegalArgumentException, PositionFilledException{
        if (symbol != 'X'  && symbol != 'O') {
            throw new IllegalArgumentException();
        }

        if(board[row][col] != '\0'){
            throw new PositionFilledException("This position is already filled! ");
        }

        board[row][col] = symbol;
        return true;
    }

    public boolean checkWinner(){

        char primaryDiagonal = board[0][0];
        char secundaryDiagonal = board[0][dimension-1];

        for (int i = 1; i < dimension; i++) {
            if(board[i][i]!=primaryDiagonal || board[i][dimension-1-i]!=secundaryDiagonal){
                break;
            }

            if (i == dimension-1) {
                return true;
            }
        } 

        for (int i = 0; i < dimension; i++) {
            char currentRow = board[i][0];
            char currentCol = board[0][i];

            for (int j = 1; j < dimension; j++) {
                if (board[i][j]!=currentRow || board[j][i]!=currentCol) {
                    break;
                }

                if (j == dimension-1) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (char[] line : board) {


            for (int i = 0; i < dimension; i++) {
                
                sb.append(" ").append("-");
            } 

            sb.append("\n");

            for (int i = 0; i < line.length; i++) {
                sb.append("|").append(line[i]=='\0'?" ": line[i]);
            } 
            
            
            sb.append("|\n");
            
            

        }

        for (int i = 0; i < dimension; i++) {
           
            sb.append(" ").append("-");
        }

        return sb.toString();
    }
}