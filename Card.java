//Karim's Card implementation.
public class Card{
    protected int suit;
    protected int value;

    public Card(int suit, int value){

        this.suit = suit;
        this.value = value;
    }

    public int getSuit(){

        return suit;
    }

    public int getValue(){

        return value;
    }

    public String getSuitAsString(){

        switch (suit) {
            case 1:
                return "spades";

            case 2:
                return "hearts";

            case 3:
                return "diamonds";

            case 4:
                return "clubs";

            case 5:
                return "";

            default:
                return "Placeholder";

        }
    }

    public String getValueAsString(){

        if(suit == 5){
            return "";    
        }
        switch (value) {

            case 1:
                return "ace";

            case 2:
                return "2";

            case 3:
                return "3";
            
            case 4:
                return "4";
            
            case 5:
                return "5";
            
            case 6:
                return "6";
            
            case 7:
                return "7";
            
            case 8:
                return "8";
            
            case 9:
                return "9";
            
            case 10:
                return "10";
            
            case 11:
                return "jack";
            
            case 12:
                return "queen";
            
            case 13:
                return "king";

            case 14:
                return "";
        
            default:
                return "Placeholder";
        }
    }

    public String toString(){

            return (getValueAsString() + " of " + getSuitAsString());
    }
}

