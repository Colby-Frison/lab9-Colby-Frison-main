import java.util.Objects;

public class Card {

    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) throws NullPointerException{
        if(rank != null && suit != null){
            this.rank = rank;
            this.suit = suit;
        }
        else{
            throw new NullPointerException();
        }
    }

    public int compareTo(Card card){
        int suitVal = this.suit.compareTo(card.suit);
        int rankVal = this.rank.compareTo(card.rank);

        if(suitVal != 0){
            return suitVal;
        }
        else{
            return rankVal;
        }
    }

    public boolean equals(Object obj){
        if(!(obj instanceof Card)){
            return false;
        }

        Card card = (Card)obj;

        int suitVal = card.getSuit().compareTo(suit);
        int rankVal = card.getRank().compareTo(rank);

        if(suitVal == 0 && rankVal == 0){
            return true;
        }
        else{
            return false;
        }
    }

    public Rank getRank(){


        return rank;
    }

    public Suit getSuit(){


        return suit;
    }

    public int hashCode(){
        
        return Objects.hash(rank, suit);
    }

    public String toString(){
        return rank.toString() + suit.toString();
    }
    

}
