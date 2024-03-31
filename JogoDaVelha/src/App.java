
import classes.*;
import java.io.*;
import java.util.Scanner;

class App {
    
    public static void main(String[] args) throws Exception {
        Player winner;
        Player playerOne;
        Player playerTwo;

        Scanner sc = new Scanner(System.in);

        System.out.print("Type the name of the first player: ");
        String playerOneName = sc.nextLine();
        System.out.print("Now, type the name of the second player: ");
        String playerTwoName = sc.nextLine();
        System.out.println();
        playerOne = new Player(playerOneName, 'X');
        playerTwo = new Player(playerTwoName, 'O');

        while (true) {
            
            
            int dimension;

            do {
                System.out.println("Enter the board size: ");
                dimension = sc.nextInt();    
            } while (dimension<3);
            

            NoughtsAndCrosses board = new NoughtsAndCrosses(dimension);

            boolean player1Turn = true;

            while (true) {
                if(player1Turn) System.out.println("Your turn "+playerOne.getName());
                else System.out.println("Your turn "+playerTwo.getName());
                

                System.out.println();
                int row, col;

                do {

                    System.out.println(String.format("Choose the row and column for your move: (0 to %d)", dimension-1));
                    System.out.print("ROW: ");
                    row = sc.nextInt();
                    System.out.print("COL: ");
                    col = sc.nextInt();

                } while (!board.makeAMove(row, col, player1Turn? playerOne.getSymbol():playerTwo.getSymbol()));
            
                System.out.println();
                System.out.println(board);
                System.out.println();


                if(board.checkWinner()){
                    if(player1Turn){
                        System.out.println(String.format("Player one %s has triumphed!", playerOne.getName()));
                        playerOne.setScore(playerOne.getScore()+1);
                    }else{
                        System.out.println(String.format("Player two %s has triumphed!", playerTwo.getName()));
                        playerTwo.setScore(playerTwo.getScore()+1);
                    }
                    
                    break;
                }

                player1Turn = !player1Turn;
            }

            System.out.println("Final score! ");
            System.out.println(playerOne);
            System.out.println();
            System.out.println(playerTwo+"\n");

            System.out.println("Do you want go again? (s/n)");
            String answer = sc.next();
            sc.close();

            if (!answer.equalsIgnoreCase("s")) {
                break;
            }
        }

        try {
            if (playerOne.getScore()>playerTwo.getScore()) winner = playerOne;
                else winner = playerTwo;
                

            File f = new File("Result.txt");
            FileWriter fr = new FileWriter(f);
            PrintWriter out = new PrintWriter(fr);
            out.println("Winner: " + winner);
            out.close();
            fr.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }
}
