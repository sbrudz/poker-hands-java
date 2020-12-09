package com.defmethod.pokerhands;

public class Card implements Comparable<Card> {
    private final CardRank rank;
    private final CardSuit suit;

    public Card(CardRank rank, CardSuit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        return rank == card.rank && suit == card.suit;

    }

    @Override
    public int hashCode() {
        int result = rank.hashCode();
        result = 31 * result + suit.hashCode();
        return result;
    }

    @Override
    public String toString(){
        return rank.getRankString() + suit.getSuitString();
    }

    @Override
    public int compareTo(Card that) {
        //Swapped comparison order so that cards sort descending (Ace, King, Queen...)
        return Integer.compare(that.rank.ordinal(), this.rank.ordinal());
    }
}
