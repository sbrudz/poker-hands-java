package com.defmethod.pokerhands;

public enum CardRank {
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("T"),
    JACK("J"),
    QUEEN("Q"),
    KING("K"),
    ACE("A");

    private static final CardRank[] allCardRanks = CardRank.values();

    private final String rankString;

    CardRank(String rankString) {
        this.rankString = rankString;
    }

    public static CardRank[] AllCardRanks() {
        return allCardRanks;
    }

    public String getRankString() {
        return rankString;
    }

    public static boolean isValidRank(String rankString){
        for(CardRank rank: allCardRanks){
            if (rank.getRankString().equals(rankString)){
                return true;
            }
        }
        return false;
    }

    public static CardRank forIdentifier(String cardRankString) {
        for (CardRank rank : allCardRanks) {
            if(rank.rankString.equals(cardRankString)) {
                return rank;
            }
        }
        throw new IllegalArgumentException();
    }

    public Card of(CardSuit suit) {
        return new Card(this, suit);
    }
}
