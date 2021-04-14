package vikvlaeg;

import elevengame.DataStore;
import elevengame.GameInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameImplementation implements GameInterface {

    private List<Card> deck = new ArrayList<>();
    private List<Card> playerDeck = new ArrayList<>();


    public GameImplementation() {
        String[] values = DataStore.loadValues();
        String[] symbols = DataStore.loadSymbols();
        int[] nPoints = DataStore.loadNPoints();
        for (int i = 0; i < symbols.length; i++) {
            for (int j = 0; j < values.length; j++) {
                Card c = new Card(symbols[i], values[j], nPoints[j]);
                deck.add(c);
            }
        }
        Collections.shuffle(deck);
        for (int i = 0; i < 9; i++) {
            playerDeck.add(deck.get(i));
            deck.remove(i);
        }
    }

    @Override
    public String getName() {
        return "Eleven Game";
    }

    @Override
    public int nCards() {
        return DataStore.getNCards();
    }

    @Override
    public int getDeckSize() {
        return deck.size();
    }

    @Override
    public String getCardDescriptionAt(int index) {
        return index + ". " + playerDeck.get(index).getSymbol() + "-" + playerDeck.get(index).getValue();
    }

    @Override
    public boolean anotherPlayIsPossible() {
        String[] triple = {"jack", "queen", "king"};
        if (playerDeck.contains(triple)) {
            return true;
        }
        for (int i = 1; i < playerDeck.size() - 1; i++) {
            if ((playerDeck.get(i).getPoint() + playerDeck.get(i + 1).getPoint()) == 11) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean playAndReplace(List<Integer> iSelectedCards) {
        return false;
    }

    @Override
    public boolean isWon() {
        return false;
    }
}
