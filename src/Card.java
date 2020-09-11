public class Card {
    private String name;
    private int value;

    public Card(int val){
        value=val;
        if (val==1){
            name="A";
        }
        else if(val==10){
            name="T";
        }
        else if(val==11){
            name="J";
        }
        else if(val==12){
            name="Q";
        }
        else if(val==13){
            name="K";
        }
        else {
            name=Integer.toString(val);
        }
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
