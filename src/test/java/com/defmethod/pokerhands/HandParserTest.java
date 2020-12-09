package com.defmethod.pokerhands;

import org.junit.Assert;
import org.junit.Test;

public class HandParserTest {
    private final static CardRank[] validCardRanks = CardRank.AllCardRanks();
    private final static CardSuit[] validCardSuits = CardSuit.AllCardSuits();
    private final static HandParser handParser = new HandParser();

    @Test
    public void testShouldOnlyValidateHandsWithValidRanks(){
        String[] invalidRankHand = new String[] {"8D", "TF"};
        Assert.assertFalse(handParser.isValidHand(invalidRankHand));
    }

    @Test
    public void testShouldOnlyValidateHandsWithValidSuits(){
        String[] invalidRankHand = new String[] {"8D", "ZS"};
        Assert.assertFalse(handParser.isValidHand(invalidRankHand));
    }

    @Test
    public void testShouldOnlyValidateHandsWithlengthOfTwo(){
        String[] oversizedCardString = new String[] {"10D"};
        String[] undersizedCardString = new String[] {"S"};
        Assert.assertFalse(handParser.isValidHand(oversizedCardString));
        Assert.assertFalse(handParser.isValidHand(undersizedCardString));
    }

    @Test
    public void testShouldHaveAllValidCards(){
        for(CardRank rank : validCardRanks) {
            for(CardSuit suit : validCardSuits) {
                final String rankWithValidSuit = rank.getRankString() + suit.getSuitString();
                final boolean isRankValid = handParser.isValidHand(new String[]{rankWithValidSuit});
                Assert.assertTrue(rankWithValidSuit + " is a valid card rank", isRankValid);
            }
        }
    }
}
