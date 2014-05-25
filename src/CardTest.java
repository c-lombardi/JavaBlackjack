/**
 * Created by Christopher on 1/22/14.
 */
public class CardTest
{
    public static void main (String[] args)
    {
        CardGroup deck = new CardGroup();
        deck.makeWholeDeck();
        System.out.println(deck.toString());
        deck.shuffle();
        System.out.println(deck.toString());
        Card a = deck.dealTopCard();
        System.out.println(a.getValue());
        System.out.println(deck.toString());
        deck.addToDeck(a);
        System.out.println(deck.toString());
    }
}
