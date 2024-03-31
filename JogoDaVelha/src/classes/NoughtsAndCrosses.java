package classes;


public class NoughtsAndCrosses{
    private char[][] board;
    private int dimension;
    
    public NoughtsAndCrosses(int dimension){
        
        this.dimension = dimension;
        this.board = new char[dimension][dimension];

    }

    public boolean makeAMove(int row, int col, char symbol) throws IllegalArgumentException, PositionFilledException{

        if (symbol != 'X'  && symbol != 'O') throw new IllegalArgumentException();    

        if(board[row][col] != '\0') throw new PositionFilledException("This position is already filled! ");

        board[row][col] = symbol;

        return true;
    }


    private boolean checkRowCol(){
        for (int i = 0; i < dimension; i++) {
            char startRow = board[i][0];
            char startCol = board[0][i];
            boolean wonRow = true;
            boolean wonCol = true;

            for (int j = 1; j < dimension; j++) {
                if (board[i][j] != startRow || startRow == '\0') wonRow = false;
                if (board[j][i] != startCol || startCol == '\0') wonCol = false;              
            }

            if (wonRow || wonCol) return true;
        }
        return false;
    }

    private boolean checkDiagonal(){
        char primaryDiagonal = board[0][0];
        char secundaryDiagonal = board[0][dimension - 1];
        boolean wonPrimaryDiagonal = true;
        boolean wonSecundaryDiagonal = true;

        for (int i = 1; i < dimension; i++) {
                if (board[i][i] != primaryDiagonal || primaryDiagonal == '\0') wonPrimaryDiagonal = false;
                if (board[i][dimension - 1 - i] != secundaryDiagonal || secundaryDiagonal == '\0') wonSecundaryDiagonal = false;    
        }

        if (wonPrimaryDiagonal || wonSecundaryDiagonal) return true;
        else return false;
    }
    

    public boolean checkWinner(){
        if (checkRowCol() || checkDiagonal()) return true;
        else return false;
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