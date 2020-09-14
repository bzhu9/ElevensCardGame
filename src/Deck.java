import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deck;

    public Deck(){
        deck = new ArrayList<>();
        for (int i=1;i<14;i++){
            for (int j=0;j<4;j++){
                Card c = new Card(i);
                deck.add(c);
            }
        }
        this.randomizeDeck();
    }
    public String getDeck(){
        String out = "";
        for (Card c:deck){
            out=out+c.getName()+", ";
        }
        return (out.substring(0,out.length()-1));
    }
    public void randomizeDeck(){
        Collections.shuffle(deck);
    }
    public Card getNextCard(){
        Card c = deck.get(0);
        deck.remove(0);
        return c;
    }
    public int numCardsLeft(){
        return deck.size();
    }
}
