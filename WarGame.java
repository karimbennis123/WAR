import java.util.Scanner;
import java.util.ArrayList;

public class WarGame {
    private static int  i = 0;
    static ArrayList<Card> cardsAtStake = new ArrayList<Card>();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //create deck
        Deck deck = new Deck();
        //shuffle the deck multiple times
        deck.shuffle();
        deck.shuffle();
        deck.shuffle();
        //set name for players and assign new decks
        System.out.println("Player 1: ");
        String name1 = input.nextLine();

        System.out.println("Player 2: ");
        String name2 = input.nextLine();

        Player player1 = new Player(name1);

        Player player2 = new Player(name2);

        //split the deck between players
        int cardIndex = 0;
        for(int i = 0; i < 26 ; i++ ){

            player1.getPlayerDeck().addToDeck(deck.dealCard(cardIndex++));
            player2.getPlayerDeck().addToDeck(deck.dealCard(cardIndex++));

        }

        player1.getPlayerDeck().addToDeck(deck.dealCard(52));
        player2.getPlayerDeck().addToDeck(deck.dealCard(53));



        while ((player1.getPlayerDeck().getNumCards() != 0) && (player2.getPlayerDeck().getNumCards() != 0)){
            dealAndPrint(player1);
            dealAndPrint(player2);

            if(player1.getPlayerDeck().dealCard(player1.getPlayerDeck().getNumCards()).getValue() == player2.getPlayerDeck().dealCard(player2.getPlayerDeck().getNumCards()).getValue()){
                System.out.println("WAR!");
                continue;
            }
            if((player1.getPlayerDeck().dealCard(player1.getPlayerDeck().getNumCards()).getValue() == 1) && (player2.getPlayerDeck().dealCard(player2.getPlayerDeck().getNumCards()).getValue() < 14)){
                System.out.println(player1.getName() + " won the duel.");
                for(Card cardAtStake : cardsAtStake) {
                    player1.getPlayerDeck().addToDeck(cardAtStake);
                    player1.getPlayerDeck().shuffle();
                }
            } else if ((player2.getPlayerDeck().dealCard(player2.getPlayerDeck().getNumCards()).getValue() == 1) && (player1.getPlayerDeck().dealCard(player1.getPlayerDeck().getNumCards()).getValue() < 14)) {
                System.out.println(player2.getName() + " won the duel.");
                for(Card cardAtStake : cardsAtStake) {
                    player2.getPlayerDeck().addToDeck(cardAtStake);
                    player2.getPlayerDeck().shuffle();
                }
            } else if(player1.getPlayerDeck().dealCard(player1.getPlayerDeck().getNumCards()).getValue() > player2.getPlayerDeck().dealCard(player2.getPlayerDeck().getNumCards()).getValue()){
                System.out.println(player1.getName() + " won the duel.");
                for(Card cardAtStake : cardsAtStake) {
                    player1.getPlayerDeck().addToDeck(cardAtStake);
                    player1.getPlayerDeck().shuffle();
                }
            }else if(player2.getPlayerDeck().dealCard(player2.getPlayerDeck().getNumCards()).getValue() > player1.getPlayerDeck().dealCard(player1.getPlayerDeck().getNumCards()).getValue()){
                System.out.println(player2.getName() + " won the duel.");
                for(Card cardAtStake : cardsAtStake) {
                    player2.getPlayerDeck().addToDeck(cardAtStake);
                    player2.getPlayerDeck().shuffle();
                }
            }
            cardsAtStake.clear();

            System.out.println();
            System.out.println(player1.getName() + " has " + player1.getPlayerDeck().getNumCards() + " cards and " + player2.getName() + " has " + player2.getPlayerDeck().getNumCards() + " cards.");
            System.out.println("----------------------------------------");
        }

        if(player2.getPlayerDeck().getNumCards() == 0){
            System.out.println(player1.getName() + " won!!!");
        }else{
            System.out.println(player2.getName() + " won!!!");
        }


    }


    //This method deals a card and prints it to the terminal
    public static void dealAndPrint(Player player) {
        Scanner input = new Scanner(System.in);
        Card preDeal = player.getPlayerDeck().dealCard(player.getPlayerDeck().getNumCards() - 1);
        cardsAtStake.add(preDeal);
        System.out.println(player.getName() + ", please draw a card using the 'enter' key.");
        input.nextLine();
        System.out.println(player.getName() + " dealt: " + player.getPlayerDeck().dealCard());
        System.out.println();

    }

    //This method checks one of two things: 1. the winner of the battle, 2. the occurence of a war. NOTE** FIX ACE WAR SCENARIO
    public static void duelOutcome(Player player1, Player player2){



    }
}
