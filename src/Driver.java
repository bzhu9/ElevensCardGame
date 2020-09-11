import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Human (1) or AI (2): ");
        int num = in.nextInt();
        boolean gameover = false;
        Deck d = new Deck();
        //Board b = new Board;
        //System.out.println(b.getBoard);

        while (gameover){
            if(num == 1){

            }
            else{
                AIBot ai = new AIBot();
                ai.fin
            }

            if(d.numCardsLeft()==0){
                gameover= true;
            }


        }


        //
        System.out.println("Hello Werld!");
    }
}
