
import classes.*;

import java.util.Scanner;

class App {
    
    public static void main(String[] args) throws Exception {
        while (true) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Type the name of the first player: ");
            String playerOneName = sc.nextLine();
            System.out.print("New, type the name of the second player: ");
            String playerTwoName = sc.nextLine();
            System.out.println("");

            Player playerOne = new Player(playerOneName, 'X');
            Player playerTwo = new Player(playerTwoName, 'O');
            
            System.out.println("Enter the board size: ");
            int dimension = sc.nextInt();

            NoughtsAndCrosses board = new NoughtsAndCrosses(dimension);

            boolean player1Turn = true;

            while (true) {
                if(player1Turn){
                    System.out.println("Your turn "+playerOne.getName());
                }else{
                    System.out.println("Your turn "+playerTwo.getName());
                }

                System.out.println();
                int row, col;

                do {

                    System.out.println(String.format("Choose the row and column for your move: (0 to %d)", dimension-1));
                    System.out.print("ROW: ");
                    row = sc.nextInt();
                    System.out.print("COL: ");
                    col = sc.nextInt();

                } while (!board.makeAMove(row, col, player1Turn? 'x':'O'));
            
                System.out.println();
                System.out.println(board);
                System.out.println();

                if(board.checkWinner()){
                    if(player1Turn){
                        System.out.println("Player one has triumphed!");
                        playerOne.setScore(playerOne.getScore()+1);
                    }else{
                        System.out.println("Player two has triumphed!");
                        playerTwo.setScore(playerTwo.getScore()+1);
                    }
                    
                    break;
                }

                player1Turn = !player1Turn;
            }

            System.out.println("Final score! ");
            System.out.println(playerOne);
            System.out.println();
            System.out.println(playerTwoName+"\n");

            System.out.println("Do you want go again? (s/n)");
            String answer = sc.next();
            if (!answer.equalsIgnoreCase("s")) {
                break;
            }
        }

        

    }
}
