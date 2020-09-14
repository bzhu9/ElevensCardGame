import java.util.ArrayList;

public class Board {
    public ArrayList<Card> cards;

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
            if (cards.get(i).getName().equals(in)) {
                cards.set(i, next);
                break;
            }
        }
    }
    public boolean checkSum(ArrayList<Card> c){
        if (c.size()==3)
            return checkJQK(c);
        return  (c.get(0).getValue() + c.get(1).getValue())==11;
    }
    private static boolean checkJQK (ArrayList<Card> c){
        String need = "JQK";
        for (Card card: c){
            if (need.contains(card.getName()))
                need = need.replace(card.getName(),"");
        }
        return need.length()==0;
    }

}
