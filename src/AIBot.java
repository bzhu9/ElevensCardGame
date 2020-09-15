import java.util.ArrayList;
import java.util.Arrays;

public class AIBot {
    private Board b;
    public AIBot(Board play){
        b=play;
    }

    public String find11(){
        ArrayList<String> arr = new ArrayList<>(Arrays.asList("J","Q","K"));
        ArrayList<Integer> elevens = new ArrayList<>();
        for (Card c:b.cards){
            if (arr.contains(c.getName())){
                arr.remove(c.getName());
            }
            for (Integer spot:elevens){
                if (spot+c.getValue()==11){
                    return (Integer.toString(spot)+Integer.toString(c.getValue()));
                }
            }
            elevens.add(c.getValue());
        }
        if (arr.isEmpty()){
            return "JQK";
        }
        return "";
    }


}
