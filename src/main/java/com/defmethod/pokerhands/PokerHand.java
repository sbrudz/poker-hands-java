package com.defmethod.pokerhands;

import java.util.Collection;
import java.util.HashSet;

public class PokerHand {
    private final HashSet<Card> cards;

    public PokerHand(Collection<Card> cards) {
        this.cards = new HashSet<>(cards);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PokerHand otherHand = (PokerHand) o;
        return cards.equals(otherHand.cards);

    }

    @Override
    public int hashCode() {
        return cards.hashCode();
    }

    @Override
    public String toString() {
        final StringBuilder cardString = new StringBuilder();
        for (Card card : cards) {
            cardString.append(card.toString()).append(" ");
        }
        return cardString.toString().trim();
    }
}
