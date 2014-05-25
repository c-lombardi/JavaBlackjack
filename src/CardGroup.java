import java.util.Random;

/**
 * Created by Christopher on 1/22/14.
 */
public class CardGroup
{
    public Card[] cards;
    public int numCards;

    public CardGroup()
    {
        this.cards = new Card[52];
        this.setNumCards(0);
    }
    public void setNumCards(int num)
    {
        this.numCards = num;
    }
    public int getNumCards()
    {
        return this.numCards;
    }
    public Card getCard(int position)
    {
        return this.cards[position];
    }
    public void setCard(int position, Card card)
    {
        this.cards[position] = card;
    }
    public void addToDeck(Card card)
    {
        this.setNumCards(this.getNumCards()+1);
        Card[] cards;
        cards = new Card[this.getNumCards()];
        for(int i = 0; i < this.getNumCards()-1; i++)
        {
            Card card1 = this.cards[i];
            cards[i] = card1;
        }
        cards[this.getNumCards()-1] = card;
        this.cards = cards;
    }
    public void makeWholeDeck ()
    {
        int count = 0;
        for (Blackjack.Suit suit : Blackjack.Suit.values())
        {
            for (Blackjack.FaceValue value : Blackjack.FaceValue.values())
            {
                this.setCard(count, new Card(value, suit));
                this.setNumCards(this.getNumCards()+1);
                ++count;
            }
        }
    }
    public void shuffle()
    {
        Random rnd = new Random();
        for (int i = this.numCards - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            Card a = this.getCard(index);
            this.cards[index] = this.getCard(i);
            this.cards[i] = a;
        }
    }
    public Card dealTopCard()
    {
        this.setNumCards(this.getNumCards()-1);
        Card returnVal = this.getCard(0);
        Card[] cards = new Card[this.getNumCards()];
        for (int i = 1; i <= this.getNumCards(); i++)
        {
            cards[i-1] = this.cards[i];
        }
        this.cards = cards;
        return returnVal;
    }
    public String toString()
    {
        String returnVal = new String("Your hand is as follows:\n");
        for(Card a : this.cards)
        {
            returnVal = returnVal + " " + a.getFaceValue() + " of " + a.getSuit() + " " + "\n";
        }
        return returnVal;
    }
    public int getValue()
    {
        int total = 0;
        for(Card a : this.cards)
        {
            total += a.getValue();
        }
        return total;
    }
    public void returnCardsToDeck(CardGroup deck)
    {
        for (int i = 0; i < this.getNumCards(); i++)
        {
            Card a = this.dealTopCard();
            deck.addToDeck(a);
        }
    }
    public String displayComputerHand()
    {
        String returnVal = new String("The Computer was dealt:\n");
        for (Card c: this.cards)
        {
            returnVal += " " + c.toString() + "\n";
        }
        return returnVal;
    }
}