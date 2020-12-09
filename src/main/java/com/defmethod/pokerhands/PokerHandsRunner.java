package com.defmethod.pokerhands;

public class PokerHandsRunner {
    public static void main(String[] args) {
        new PokerHands(System.out, new HandParser(), new HandEvaluator()).execute(args);
    }
}
