package com.bravedo;

import com.bravedo.modal.Card;
import com.bravedo.modal.Deck;
import com.bravedo.modal.Rank;

import java.util.ArrayList;
import java.util.Arrays;

public class CardDesk {
    public static void main(String[] args) {
        Deck deckOne = new Deck();
        System.out.println("Initial Pack Contents:");
        printPackContents(deckOne);
        Deck clonedDeck = deckOne.clone();
        clonedDeck.shuffle();
        deckOne.replaceRank(Rank.ACE, Rank.QUEEN);
        System.out.println("Pack Contents after replacing Ace to Queen:");
        printPackContents(deckOne);
        printRankCount(deckOne);
        System.out.println("shuffled pack contents:");
        printPackContents(clonedDeck);
    }

    private static void printRankCount(Deck deckOne) {
        Arrays.stream(Rank.values())
                .forEach(rank -> {
                    System.out.println(rank + ": " + printCountIn(deckOne, rank));
                });
    }

    private static long printCountIn(Deck deckOne, Rank rank) {
        return deckOne.getDeck().stream()
                .filter(item -> item.getRank() == rank)
                .count();
    }

    private static void convertAceToQueen(Deck deckOne) {
        deckOne.replaceRank(Rank.ACE, Rank.QUEEN);
    }

    private static void printPackContents(Deck deck) {
        ArrayList<Card> pack = deck.getDeck();
        pack.forEach(item -> System.out.println(item.getRank() + " of " + item.getSuit()));
    }
}
