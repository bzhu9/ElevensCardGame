import java.util.ArrayList;

public class Board {
    private ArrayList<Card> cards;

    public Board(ArrayList<Card> initial){
        cards = new ArrayList<>();
        cards.addAll(initial);
    }

    public String getBoard(){
        String out = "";
        for (int i = 0; i<cards.size(); i++) {
            out += cards.get(i);
            if (i%3 == 2)
                out+="\n";
        }
        return out;
    }

    //Returns true or false if move can be made
    public void makeMove(String in, Card next){
        for (int i = 0; i<cards.size(); i++) {
            if (cards.get(i).getName().equals(in))
                cards.set(i, next);
        }
    }
    public boolean checkSum(ArrayList<Card> c){

    }
}
