package com.defmethod.pokerhands;


public enum CardSuit {
    SPADES("S"),
    CLUBS("C"),
    DIAMONDS("D"),
    HEARTS("H");
    private static final CardSuit[] allCardSuits = CardSuit.values();
    private final String suitString;

    CardSuit(String suitString) {
        this.suitString = suitString;
    }

    public static CardSuit[] AllCardSuits() {
        return allCardSuits;
    }

    public String getSuitString() {
        return this.suitString;
    }

    public static boolean isValidSuit(String cardSuit) {
        for (CardSuit suit : allCardSuits) {
            if(suit.suitString.equals(cardSuit)) {
                return true;
            }
        }
        return false;
    }

    public static CardSuit forIdentifier(String cardSuitString) {
        for (CardSuit suit : allCardSuits) {
            if(suit.suitString.equals(cardSuitString)) {
                return suit;
            }
        }
        throw new IllegalArgumentException();
    }
}
