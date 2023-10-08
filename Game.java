import java.util.*;

public class Game {
    static String[] board;
    static String turn;

    static String checkWinCondition(String[] board) {
        //Row Conditions
        String line1 = board[0] + board[1] + board[2];
        if (line1.equals("XXX")){return "X";}
        if (line1.equals("OOO")){return "O";}

        String line2 = board[3] + board[4] + board[5];
        if (line2.equals("XXX")){return "X";}
        if (line2.equals("OOO")){return "O";}

        String line3 = board[6] + board[7] + board[8];
        if (line3.equals("XXX")){return "X";}
        if (line3.equals("OOO")){return "O";}

        //Column Conditions
        String line4 = board[0] + board[3] + board[6];
        if (line4.equals("XXX")){return "X";}
        if (line4.equals("OOO")){return "O";}

        String line5 = board[1] + board[4] + board[7];
        if (line5.equals("XXX")){return "X";}
        if (line5.equals("OOO")){return "O";}

        String line6 = board[2] + board[5] + board[8];
        if (line6.equals("XXX")){return "X";}
        if (line6.equals("OOO")){return "O";}

        //Diagonal Conditions
        String line7 = board[0] + board[4] + board[8];
        if (line7.equals("XXX")){return "X";}
        if (line7.equals("OOO")){return "O";}

        String line8 = board[6] + board[4] + board[2];
        if (line8.equals("XXX")){return "X";}
        if (line8.equals("OOO")){return "O";}

        return null;

    }
    static void board(){
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("|---|---|---|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("|---|---|---|");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("|---|---|---|");
    }


    public static void main(String[] args){
        //Initializing variables and creating the board
        Scanner userInput = new Scanner(System.in);
        turn = "X";
        board = new String[9];
        for (int i = 0; i < board.length; i++){
            board[i] = (i + 1) + "";
        }
        System.out.println("Welcome to Tic-Tac-Toe!");
        board();
        System.out.println("To place your turn, please press the corresponding number on you keyboard");


        //Players placing down their X and O on the board
        String winCondition = null;
        int turnInt;
        int counter = 0;
        while (winCondition == null){
            System.out.println(turn + "'s turn; enter a slot number to place " + turn + " in: ");
            turnInt =userInput.nextInt();

            //Handling edge cases
            try{
                if (!(turnInt > 0 && turnInt <= 9)){
                    System.out.println("Please enter a valid number between range [1,9]");
                    continue;
                }
            } catch (InputMismatchException e){
                System.out.println("Please enter a valid number between range [1,9]");
                continue;
            }
            //Converting Scanner Object Input to int for indexing
            board[turnInt-1] = turn;
            winCondition = checkWinCondition(board);
            board();

            //Condition for switching turns each time
            if (board[turnInt-1] == "X"){
                turn = "O";
            } else{
                turn = "X";}

            //Condition to check for draw
            counter++;
            if ((counter==9) && (winCondition == null)){
                winCondition = "Draw";
            }
        }

        //Printing result of the game
        if (winCondition.equals("Draw")){
            System.out.println("The game is a draw :(\nThank you for playing!");

        } else {
            System.out.println(winCondition + " is the winner!\nThank you for playing! :)");
        }
    }
}
