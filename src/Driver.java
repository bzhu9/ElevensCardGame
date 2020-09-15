import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        //System.out.println("Human (1) or AI (2): ");
        //int num = in.nextInt();
        //in.nextLine();
        int num = 2;
        int count = 0;
        for (int k = 0; k < 1000000; k++) {
            boolean gameover = false;
            boolean win = false;
            Deck d = new Deck();
            ArrayList<Card> initialCards = new ArrayList<>();
            for (int i = 0; i < 9; i++) {
                initialCards.add(d.getNextCard());
            }
            Board b = new Board(initialCards);
            b.getBoard();

            while (!gameover) {
                if (d.numCardsLeft()== 0) {
                    win = true;
                    gameover = true;
                    break;

                }
                else if (!b.checkAvailableMoves()){
                    gameover = true;
                    break;
                }
                if (num == 1) {
                    System.out.println("Player 1st choice: ");
                    String playerChoice = in.nextLine();
                    System.out.println("Player 2nd choice: ");
                    String playerChoice2 = in.nextLine();
                    System.out.println("Do you need to select a third card? (1=yes, 2=no): ");
                    int third = in.nextInt();
                    in.nextLine();
                    if(d.numCardsLeft() >=2){
                        Card newCard1 = d.getNextCard();
                        Card newCard2 = d.getNextCard();
                        b.makeMove(playerChoice,newCard1);
                        b.makeMove(playerChoice2,newCard2);

                    }
                    else{
                        Card newCard1 = new Card(0);
                        Card newCard2 = new Card(0);
                        b.makeMove(playerChoice,newCard1);
                        b.makeMove(playerChoice2,newCard2);
                    }



                    if(third==1){
                        System.out.println("Player 3rd choice: ");
                        String playerChoice3 = in.nextLine();
                        Card newCard3 = d.getNextCard();
                        b.makeMove(playerChoice3,newCard3);

                    }

                    System.out.println(b.getBoard());


                }
                else {

                    AIBot ai = new AIBot(b);
                    String aiSelection = ai.find11();

                    for (int i = 0; i < aiSelection.length(); i++) {
                        String s = aiSelection.substring(i,i+1);
                        if(d.numCardsLeft() >=1){
                            Card newCard1 = d.getNextCard();
                            b.makeMove(s,newCard1);
                        }
                        else{
                            Card newCard1 = new Card(0);
                            b.makeMove(s,newCard1);
                        }
                    }
                    b.getBoard();

                }




            }
            if(win){
                //System.out.println("you won!");
                count++;
            }
            else{
                //System.out.println("you lost!");
            }
        }
        System.out.println(count);



    }
}
