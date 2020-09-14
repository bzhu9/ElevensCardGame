import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Human (1) or AI (2): ");
        int num = in.nextInt();
        boolean gameover = false;
        boolean win = false;
        Deck d = new Deck();
        Board b = new Board();
        System.out.println(b.getBoard());

        while (gameover) {
            if (num == 1) {
                System.out.println("Player 1st choice: ");
                String playerChoice = in.nextLine();
                System.out.println("Player 2nd choice: ");
                String playerChoice2 = in.nextLine();
                System.out.println("Do you need to select a third card? (1=yes, 2=no): ");
                int third = in.nextInt();
                Card newCard1 = d.getNextCard();
                Card newCard2 = d.getNextCard();
                if(third==1){
                    System.out.println("Player 3rd choice: ");
                    String playerChoice3 = in.nextLine();
                    Card newCard3 = d.getNextCard();

                }
                ArrayList<String> choices = new ArrayList<>();



                if(b.checkSum()){
                    b.makeMove(playerChoice,newCard1);
                }
                else{
                    System.out.println("illegal move");
                }



            }
            else {
                AIBot ai = new AIBot();
                String aiSelection = ai.find11();
                Card newCard1 = d.getNextCard();
                Card newCard2 = d.getNextCard();

                b.makeMove(aiSelection,newCard1);
            }

            if (d.numCardsLeft() == 0) {
                win = true;
                gameover = true;

            }
            else if (b.checkAvailableMoves()){
                gameover = true;
            }


        }
        if(win){
            System.out.println("you won!");
        }
        else{
            System.out.println("you lost!");
        }


    }
}
