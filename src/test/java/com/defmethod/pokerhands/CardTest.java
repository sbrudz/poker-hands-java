package com.defmethod.pokerhands;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.defmethod.pokerhands.CardRank.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;

public class CardTest {

    @Test
    public void testCanCompareTwoCards(){
        Card aKingOfDiamonds = new Card(KING, CardSuit.DIAMONDS);
        Card anotherKingOfDiamonds = new Card(KING, CardSuit.DIAMONDS);
        Card kingOfSpades = new Card(KING, CardSuit.SPADES);

        Assert.assertEquals(aKingOfDiamonds, anotherKingOfDiamonds);
        Assert.assertNotEquals(aKingOfDiamonds, kingOfSpades);
    }

    @Test
    public void testCanSortAListCards(){
        final List<Card> cards = Arrays.asList(KING.of(CardSuit.DIAMONDS), TWO.of(CardSuit.CLUBS), ACE.of(CardSuit.SPADES));
        final List<Card> expectedCardSortOrder = Arrays.asList(ACE.of(CardSuit.SPADES), KING.of(CardSuit.DIAMONDS), TWO.of(CardSuit.CLUBS));

        Collections.sort(cards);

        Assert.assertThat(cards, is(equalTo(expectedCardSortOrder)));
    }

    @Test
    public void testCanConvertACardToAString() {
        Card aKingOfDiamonds = new Card(KING, CardSuit.DIAMONDS);
        Assert.assertEquals(aKingOfDiamonds.toString(), "KD");
    }
}
