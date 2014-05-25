import javax.swing.*;

/**
 * Created by Christopher on 1/22/14.
 */
public class Assign1 {

    public static void main (String[] args)
    {
        CardGroup deck = new CardGroup();
        CardGroup userHand = new CardGroup();
        CardGroup computerHand = new CardGroup();
        int total = 0;
        int computerTotal = 0;

        int plays;

        int play = 1;
        int option = 1;
        int cont = 0;

        int wins = 0;
        int compWins = 0;

        deck.makeWholeDeck();
        deck.shuffle();
        while (play == 1)
        {
            plays = 0;
            while (plays < 5)
            {
                userHand.addToDeck(deck.dealTopCard());
                while (option == 1)
                {
                    userHand.addToDeck(deck.dealTopCard());
                    total = userHand.getValue();
                    if (total > 21)
                    {
                        break;
                    }
                    option = Integer.parseInt(JOptionPane.showInputDialog("1: Hit   2:Stay\n" + userHand.toString() + "\n Total: " + total));
                }
                while (computerTotal < 16)
                {
                    computerHand.addToDeck(deck.dealTopCard());
                    computerTotal = computerHand.getValue();
                }
                if (total > 21 && computerTotal > 21)
                {
                    compWins += 1;
                    JOptionPane.showMessageDialog(null,computerHand.displayComputerHand() + "\nYou busted and so did the computer.");
                }
                else if (computerTotal > 21 && total <= 21)
                {
                    wins += 1;
                    JOptionPane.showMessageDialog(null,computerHand.displayComputerHand() + "\nYou won and the computer busted!");
                }
                else if (total > 21 && computerTotal <= 21)
                {
                    compWins += 1;
                    JOptionPane.showMessageDialog(null,computerHand.displayComputerHand() + "\nYou busted.");
                }
                else if(total <= 21 && total > computerTotal && computerTotal <= 21)
                {
                    wins += 1;
                    JOptionPane.showMessageDialog(null,computerHand.displayComputerHand() + "\nYou won!");
                }
                else
                {
                    compWins += 1;
                    JOptionPane.showMessageDialog(null, computerHand.displayComputerHand() + "\nYou lost.");
                }
                total = 0;
                computerTotal = 0;
                option = 1;
                userHand.returnCardsToDeck(deck);
                computerHand.returnCardsToDeck(deck);
                userHand = new CardGroup();
                computerHand = new CardGroup();
                plays++;
            }
            cont = Integer.parseInt(JOptionPane.showInputDialog("1: Play another set of 5 rounds   2: Quit\n Wins: " + wins + " Losses: " + compWins));
            if (cont == 1)
            {
                plays = 0;
            }
            else
            {
                play = 0;
            }
        }
    }
}
