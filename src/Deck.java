import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {

    private List<Card> cards = new ArrayList<>();

    public Deck(){
        
        ArrayList<Rank> rankArr = new ArrayList<>();
        ArrayList<Suit> suitArr = new ArrayList<>();

        for(Rank c : Rank.values())
            rankArr.add(c);
        for(Suit c : Suit.values())
            suitArr.add(c);
        

        for(int i = 0; i < 4 ; i++){
            for(int j = 0; j < 13 ; j++){
                cards.add(new Card(rankArr.get(j), suitArr.get(i)));
            }
        }
    }

    public int size(){
        return cards.size();
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

    public Card draw(){
        if(cards.size() > 0){
            Card drew = cards.get(0);
            cards.remove(0);
            return drew;
        }

        return null;
    }

    public List<Card> draw(int count){
        List<Card> drawn = new ArrayList<Card>();
        if(count <= 0){
            return List.of();
        }
        if(size() == 0){
            return List.of();
        }
        if(count > cards.size()){

            for(int i = 0; i < size(); i++){
                drawn.add(draw());
            }

            drawn.add(draw());

            return drawn;
        }

        for(int i = 0; i < count; i++){
            drawn.add(draw());
        }
        

        return drawn;
    }

    public void shuffle(){
        Random rand = new Random();
        int n = cards.size();
        
        for (int i = n - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            // Swap element at i with element at j
            Card temp = cards.get(i);
            cards.set(i, cards.get(j));
            cards.set(j, temp);
        }
    }

    public List<Card> getCardsByRank(Rank rank){
        List<Card> rankList = new ArrayList<>();

        for(int i = 0; i < size(); i++){
            if(cards.get(i).getRank() == rank){
                rankList.add(cards.get(i));
            }
        }
        return rankList;
    }
    
}
