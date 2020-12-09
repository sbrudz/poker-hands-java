package com.defmethod.pokerhands;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.defmethod.pokerhands.CardRank.*;

public class PokerHandTest {
    @Test
    public void testComparingTwoPokerHandsForEquality() {
        List<Card> firstHandCards = Arrays.asList(new Card(ACE, CardSuit.DIAMONDS), new Card(ACE, CardSuit.SPADES));
        List<Card> secondHandCards = Arrays.asList(new Card(ACE, CardSuit.SPADES), new Card(ACE, CardSuit.DIAMONDS));
        Assert.assertEquals(new PokerHand(firstHandCards), new PokerHand(secondHandCards));
    }

    @Test
    public void testCanProperlyFormatAHandAsString(){
        List<Card> handOfCards = Arrays.asList(new Card(ACE, CardSuit.SPADES), new Card(ACE, CardSuit.DIAMONDS));
        Assert.assertEquals(new PokerHand(handOfCards).toString(), "AS AD");
    }
}
