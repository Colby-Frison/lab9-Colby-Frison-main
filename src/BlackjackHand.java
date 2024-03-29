import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlackjackHand {
    
    private static Map<Rank, Integer> CARD_VALUES;

    private int MAX_VALUE = 21;

    private List<Card> cards = new ArrayList<>();

    private int value = 0;

    private int numAcesAs11 = 0;


    public BlackjackHand(Card c1, Card c2){

        //assign cards
        cards.add(c1);
        cards.add(c2);

        if(c1.getRank() == Rank.ACE){
            numAcesAs11++;
        }
        if(c2.getRank() == Rank.ACE){
            numAcesAs11++;
        }

        initializeCardVals();
        
    }

    public void addCard(Card card) throws NullPointerException {

        if(card == null){
            throw new NullPointerException();
        }

        if(getValue() < 21){
            cards.add(card);
        }

        if(card.getRank() == Rank.ACE){
            numAcesAs11++;
        }

        value = getValue();
    }

    public int size(){
        return cards.size();
    }

    public static Map<Rank, Integer> getCardValues(){
        initializeCardVals();

        Map<Rank, Integer> copyMap = new HashMap<>();
        copyMap.putAll(CARD_VALUES);
        return copyMap;
    }

    public List<Card> getCards(){
        return new ArrayList<Card>(cards);
    }

    public int getValue(){
        int val = 0;
        for(int i = 0;i < cards.size(); i++){
            val += CARD_VALUES.get(cards.get(i).getRank());
        }

        int tempNum = numAcesAs11;
        while (val > 21 && tempNum > 0) {
            val -= 10;
            tempNum--;
        }
        
        return val;
    }

    public String toString(){
        String out = "";
        if(cards.size() > 0){
            out += "" + cards.get(0).getRank() + cards.get(0).getSuit();

            for(int i = 1; i < size(); i++){
                out += ", " + cards.get(i).getRank() + cards.get(i).getSuit();
            }
        }

        return "[" + out + "]";
    }

    public static void initializeCardVals(){
        CARD_VALUES = new HashMap<>(); // initialize map

        //create array of ranks
        ArrayList<Rank> rankArr = new ArrayList<>();

        //assign ranks
        for(Rank c : Rank.values())
            rankArr.add(c);

        // Adding numbered cards to map
        for (int i = 0; i <= 10; i++) {
            CARD_VALUES.put(rankArr.get(i), i + 2);
        }

        // Adding face cards to map
        CARD_VALUES.put(rankArr.get(9), 10);
        CARD_VALUES.put(rankArr.get(10), 10);
        CARD_VALUES.put(rankArr.get(11), 10);
        CARD_VALUES.put(rankArr.get(12), 11); 
    }

}