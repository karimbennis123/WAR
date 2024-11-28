//shayne 6308903
public class Player{
    private String name;
    private Deck playerDeck;

    public Player(String name){
        this.name = name;
        playerDeck = new Deck(54);
    }

    public String getName(){
        return name;
    }

    public Deck getplayerDeck(){
        return playerDeck;
    }
}