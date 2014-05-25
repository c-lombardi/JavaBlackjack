/**
 * Created by Christopher on 1/22/14.
 */
public class Card {
    private Blackjack.FaceValue faceValue;
    private Blackjack.Suit suit;
    public Card (Blackjack.FaceValue value, Blackjack.Suit suit)
    {
        this.faceValue = value;
        this.suit = suit;
    }
    public Card(Card card)
    {
        this.faceValue = card.faceValue;
        this.suit = card.suit;
    }
    public void setSuit(Blackjack.Suit suit)
    {
        this.suit = suit;
    }
    public Blackjack.Suit getSuit()
    {
        return this.suit;
    }
    public Blackjack.FaceValue getFaceValue()
    {
        return this.faceValue;
    }
    public int getValue()
    {
        switch(this.faceValue)
        {
            case TWO:
                return 2;
            case THREE:
                return 3;
            case FOUR:
                return 4;
            case FIVE:
                return 5;
            case SIX:
                return 6;
            case SEVEN:
                return 7;
            case EIGHT:
                return 8;
            case NINE:
                return 9;
            case TEN:
                return 10;
            case JACK:
                return 10;
            case QUEEN:
                return 10;
            case KING:
                return 10;
            case ACE:
                return 1;
            default:
                return 0;
        }
    }
    public String toString ()
    {
        String returnVal = new String();
        returnVal = this.getFaceValue().toString() + " of " + this.getSuit().toString();
        return returnVal;
    }
}