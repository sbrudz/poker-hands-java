package com.defmethod.pokerhands;

import java.util.ArrayList;
import java.util.Collection;

public class HandParser {
    public boolean isValidHand(String[] cardStrings) {
        for (String card : cardStrings) {
            if (!isCardValid(card)) {
                return false;
            }
        }
        return true;
    }

    public Collection<Card> parseHand(String[] cardStrings) {
        ArrayList<Card> cards = new ArrayList<>(5);
        for (String card : cardStrings) {
            cards.add(getCardFromStringIdentifier(card));
        }
        return cards;
    }

    private Card getCardFromStringIdentifier(String card) {
        CardSuit suit = CardSuit.forIdentifier(getCardSuitString(card));
        CardRank rank = CardRank.forIdentifier(getCardRankString(card));
        return new Card(rank, suit);
    }

    private boolean isCardValid(String card) {
        if(card.length() == 2) {
            return CardRank.isValidRank(getCardRankString(card)) && CardSuit.isValidSuit(getCardSuitString(card));
        }
        return false;
    }

    private String getCardSuitString(String card) {
        return card.substring(1);
    }

    private String getCardRankString(String card) {
        return card.substring(0,1);
    }
}
