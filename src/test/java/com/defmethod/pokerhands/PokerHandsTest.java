package com.defmethod.pokerhands;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.defmethod.pokerhands.CardRank.*;
import static java.util.Arrays.asList;
import static org.mockito.Mockito.*;

import org.mockito.Mockito;

public class PokerHandsTest extends PrintStreamCapturingIntegrationTest {
    private final String InvalidHandArgumentStringErrorMessage = PokerHands.InvalidArgumentsMessage + System.lineSeparator();
    final String[] validCommandLineArguments = {"AS", "KS", "QS", "JS", "TS", "KD", "QD", "JD", "TD", "9D"};
    final String[] commandLineArgumentsWithInvalidFirstHand = {"ZS", "KS", "QS", "JS", "TS", "KD", "QD", "JD", "TD", "9D"};
    final String[] commandLineArgumentsWithInvalidSecondHand = {"AS", "KS", "QS", "JS", "TS", "ZD", "QD", "JD", "TD", "9D"};
    final String[] nineCardArguments = {"AS", "KS", "QS", "JS", "TS", "KD", "QD", "JD", "TD"};
    final String[] emptyArguments = new String[0];
    HandEvaluator handEvaluator;
    PokerHands runner;

    @Before
    public void setupRunner() {
        handEvaluator = Mockito.mock(HandEvaluator.class);
        runner = new PokerHands(printStreamForTest(), new HandParser(), handEvaluator);
    }

    @Test
    public void testPrintsErrorMessageWithNoArguments() {
        runner.execute(emptyArguments);
        Assert.assertEquals(consoleOutputAsString(), InvalidHandArgumentStringErrorMessage);
    }

    @Test
    public void testPrintsErrorMessageWithLessThanTenArguments() {
        runner.execute(nineCardArguments);
        Assert.assertEquals(consoleOutputAsString(), InvalidHandArgumentStringErrorMessage);
    }

    @Test
    public void testPrintsErrorMessageIfEitherHandIsInvalid() {
        runner.execute(commandLineArgumentsWithInvalidFirstHand);
        Assert.assertEquals(consoleOutputAsString(), InvalidHandArgumentStringErrorMessage);

        runner.execute(commandLineArgumentsWithInvalidSecondHand);
        Assert.assertEquals(consoleOutputAsString(), InvalidHandArgumentStringErrorMessage);
    }

    @Test
    public void testPrintsWinningPokerHandsIfBothHandsAreValid() {
        final PokerHand winningHand = new PokerHand(asList(ACE.of(CardSuit.SPADES), KING.of(CardSuit.SPADES), QUEEN.of(CardSuit.SPADES), JACK.of(CardSuit.SPADES), TEN.of(CardSuit.SPADES)));
        final PokerHand losingHand = new PokerHand(asList(KING.of(CardSuit.DIAMONDS), QUEEN.of(CardSuit.DIAMONDS), JACK.of(CardSuit.DIAMONDS), TEN.of(CardSuit.DIAMONDS), NINE.of(CardSuit.DIAMONDS)));
        stub(handEvaluator.evaluateHand(any(PokerHand.class), any(PokerHand.class))).toReturn(winningHand);

        runner.execute(validCommandLineArguments);

        verify(handEvaluator).evaluateHand(eq(winningHand), eq(losingHand));
        Assert.assertEquals(consoleOutputAsString(), "The winning hand: " + winningHand.toString() + System.lineSeparator());
    }

}
