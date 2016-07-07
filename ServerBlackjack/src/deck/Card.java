package deck;

import java.io.Serializable;

public class Card implements Serializable{

    int value;
    String culori;
    Card(int value, String culori){
        this.value = value;
        this.culori = culori;

    }

    @Override
    public String toString() {
        if(value == 1)
        {
            return "Ace of " + culori;
        }
        if(value == 11)
        {
            return "Jack of " + culori;
        }
        if(value == 12) {
            return "Queen of " + culori;
        }
        if(value == 13)
        {
            return "Kind of " + culori;
        }
        return value + " of " + culori;
    }
}
