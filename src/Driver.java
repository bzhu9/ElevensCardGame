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
        System.out.println(b.getBoard);

        while (gameover) {
            if (num == 1) {
                System.out.println("Player choice: ");
                String playerChoice = in.nextLine();
                Card newCard1 = d.getNextCard();
                Card newCard2 = d.getNextCard();

                if(b.checksum(playerChoice)){
                    b.move(playerChoice,newCard1,newCard2);
                }
                else{
                    System.out.println("illegal move");
                }



            }
            else {
                AIBot ai = new AIBot();
                int aiSelection = ai.find11();
                Card newCard1 = d.getNextCard();
                Card newCard2 = d.getNextCard();

                b.move(aiSelection,newCard1,newCard2);
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
