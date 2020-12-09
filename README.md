# PokerHands
This is a sample program to bu used as a jump-off point for a pair programming exercise.  
It is based on the [PokerHands](https://projecteuler.net/problem=54) from [Project Euler](https://projecteuler.net/)

There is a Card class that represents a 52-card deck of with
4 suits - Clubs, Spades, Hearts, Diamonds, abbreviated C,S,H,D
13 ranks - 2,3,4,5,6,7,8,9,10(T),Jack(J),Queen(Q),King(K),Ace(A)

To allow for a simple shorthand notation (and to match the style from the Project Euler problem), a card is defined using a 2 character string of rank and suit.
For example "2H" is the 2 of hearts, "TC" is ten of clubs, etc.

The purpose of this exercise is to begin to solve the problem of what constitutes a winning poker hand as described below, copied from the Project Euler site.

In the card game poker, a hand consists of five cards and are ranked, from lowest to highest, in the following way:

* High Card: Highest value card.
* One Pair: Two cards of the same value.
* Two Pairs: Two different pairs.
* Three of a Kind: Three cards of the same value.
* Straight: All cards are consecutive values.
* Flush: All cards of the same suit.
* Full House: Three of a kind and a pair.
* Four of a Kind: Four cards of the same value.
* Straight Flush: All cards are consecutive values of same suit.
* Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.

The cards are valued in the order:

* 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace.


For more info on poker hands, you can also check out the Wikipedia [List of poker hands](http://en.wikipedia.org/wiki/List_of_poker_hands) page

## Getting Started
Please create your own branch to keep the master as a clean jump off point for all interviews

**git co -b *candidate-name* **

You should feel empowered to implement the solutions and use a workflow that is right for you.

### Hints
The Cyrus employee doing the pairing should review the  [hints.md](hints.md) file to help structure the exercise. 
The candidate can look at the hints page if they get stuck, although it would be better if the Cyrus employee talks them through the problem.
