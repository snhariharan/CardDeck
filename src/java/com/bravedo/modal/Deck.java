package com.bravedo.modal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Deck implements Cloneable {
    ArrayList<Card> deck;

    public Deck() {
        this.deck = (ArrayList<Card>) Arrays.stream(Rank.values())
                .map(this::getSuitsForRank)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public Deck clone() {
        return new Deck();
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void shuffle() {
        for (int i = 0; i < deck.size(); i++) {
            int index = (int) (Math.random() * deck.size());
            Card temp = deck.get(i);
            deck.set(i, deck.get(index));
            deck.set(index, temp);
        }
    }

    private List<Card> getSuitsForRank(Rank rank) {
        return Arrays.stream(Suit.values())
                .map(suit -> new Card(rank, suit))
                .collect(Collectors.toList());
    }

    public List<Card> replaceRank(Rank from, Rank to) {
        return deck.stream()
                .peek(item -> {
                    if (item.getRank() == from) {
                        item.setRank(to);
                    }
                })
                .collect(Collectors.toList());
    }
}
