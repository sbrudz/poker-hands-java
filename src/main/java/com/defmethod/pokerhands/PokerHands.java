package com.defmethod.pokerhands;

import java.io.PrintStream;

public class PokerHands {
    public static String InvalidArgumentsMessage = "Please enter two poker hands in the following format: " +
            "<hand1> <hand2> where each hand is is a rank and suit." +
            "For example: AS KS QS JS TS would be a Royal Straight Flush with the suite of spades.";
    private final PrintStream outputStream;
    private final HandParser handParser;
    private final HandEvaluator handEvaluator;

    public PokerHands(PrintStream outputStream, HandParser handParser, HandEvaluator handEvaluator) {
        this.outputStream = outputStream;
        this.handParser = handParser;
        this.handEvaluator = handEvaluator;
    }

    public void execute(String[] args) {
        if(args.length != 10) {
            outputStream.println(InvalidArgumentsMessage);
            return;
        }
        String[] firstHand = new String[] { args[0], args[1], args[2], args[3], args[4] };
        String[] secondHand = new String[] { args[5], args[6], args[7], args[8], args[9] };

        if (handParser.isValidHand(firstHand) && handParser.isValidHand(secondHand)) {
            final PokerHand winningHand = handEvaluator.evaluateHand(new PokerHand(handParser.parseHand(firstHand)),
                                                                     new PokerHand(handParser.parseHand(secondHand)));
            outputStream.println("The winning hand: " + winningHand.toString());
        }
        else{
            outputStream.println(InvalidArgumentsMessage);
        }
    }
}

