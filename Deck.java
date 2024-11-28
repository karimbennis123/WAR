//Deven's Deck.java
public class Deck {
  
  private Card[] deck;
  private int numCards;

  public Deck (int size) { //Parameterized
    deck = new Card[size];
    numCards = 0;
  }

  public Deck() { //Deck Constuctor
    deck = new Card[54]; // array deck of 54 cards
    int indexCount = 0;
    numCards = 54;

    for (int i = 1; i <= 4; i++) {//for the suit
      
      for (int j = 1; j <= 13; j++) {//for the values
        Card myCard = new Card(j,i);
        deck[indexCount++] = myCard;
      }

    }
    deck[52] = new Joker(1,5);
    deck[53] = new Joker(2,5);

  }
 
  public void shuffle() {
    for ( int i = deck.length-1; i > 0; i-- ) {
      int rand = (int)(Math.random()*(i+1));
      Card temp = deck[i];
      deck[i] = deck[rand];
      deck[rand] = temp;
    }
  }

  public Card dealCard(int index) {
    return deck[index];
  }

  public Card dealCard() {
    if (numCards == 0) {
       System.out.println("Empty Deck!");
      
    } 

    return deck[--numCards];

  }

  public void addToDeck(Card card){
    if (numCards > deck.length) {
      System.out.println("error");
      return;
    } else {
      deck[numCards] = card;
      numCards++;
    }
  }

  public void printDeck() {
    if (numCards == 0) {
      System.out.println("Empty Deck!");
      
    } else {
      for (int i = 0; i < numCards; i++) {
        System.out.println(deck[i]);
      }
    }

  }
  
  
   /*public static void main(String[] args) {
    Deck deck = new Deck();
    Card newCard = new Card(1, 1);
    Card newCard2 = new Card(2, 1);
    deck.addToDeck(newCard);
    deck.addToDeck(newCard2);
    
    deck.dealCard();
    deck.dealCard();
    deck.printDeck();
  }
    */

    //Deven's Deck.java

}
