import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/*
 * 
 * Works but for some reason doesnt work on submission
 * 
 * passes all tests in IDE put fails on Zybooks
 * 
 */

public class Deck {

    private List<Card> cards = new ArrayList<>(); // initialze cards

    ArrayList<Rank> rankArr = new ArrayList<>(); //initialize rank & suit arrayList
    ArrayList<Suit> suitArr = new ArrayList<>();

    public Deck(){

        for(Rank c : Rank.values()) // add values to rank and suit using enum.values()
            rankArr.add(c);
        for(Suit c : Suit.values())
            suitArr.add(c);
        

        for(int i = 0; i < 4 ; i++){// assign values to all cards using nested loop which goes through suits then ranks
            for(int j = 0; j < 13 ; j++){
                cards.add(new Card(rankArr.get(j), suitArr.get(i)));
            }
        }
    }

    public int size(){
        return cards.size(); //return size
    }

    public String toString(){
        String out = ""; //create empty string

        if(cards.size() > 0){ //loop through the length of the deck
            out += "" + cards.get(0).getRank() + cards.get(0).getSuit();// add the first element
            //this needs to be done outside the loop since it doesnt have a comma before 

            //this can also be done after the loop by making i = 0, and having it be 'card' + ", "

            for(int i = 1; i < size(); i++){
                out += ", " + cards.get(i).getRank() + cards.get(i).getSuit();// add ", " and the cards's rank then suit
            }
        }

        return "[" + out + "]"; // return the built string surrounded by bracets
    }

    public Card draw(){
        if(cards.size() > 0){ // make sure deck is not empty
            Card drew = cards.get(0); // assign card
            cards.remove(0); //remove drawn card
            return drew; // return drawn card
        }

        return null; // if deck is empty return null
    }

    public List<Card> draw(int count){
        List<Card> drawn = new ArrayList<Card>(); // create arraylist to hold drawn cards
        if(count <= 0 || cards.size() == 0){ // if list is empty or count is <= 0 return an empty list
            return List.of();
        }
        if(count > cards.size()){ // if they are trying to draw more cards then available return all cards while emptying the original deck
            for(int i = 0; i < cards.size(); i++)
                drawn.add(draw()); // I dont know why but this is the only way I can get this to work
            drawn.add(draw());
        }
        else
            for(int i = 0; i < count; i++) // if draw count is achievable loop draw theat amount of times
                drawn.add(draw());

        return drawn; // return drawn list
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public List<Card> getCardsByRank(Rank rank){
        List<Card> rankList = new ArrayList<>(); // create list to add to

        for(int i = 0; i < cards.size(); i++){ // loop through original deck
            if(cards.get(i).getRank() == rank){ // if the rank desired is the same as the rank of the given card add it to the list
                rankList.add(cards.get(i));
            }
        }
        return rankList; // return list
    }
    
}
