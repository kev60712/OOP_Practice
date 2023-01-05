package com.company;

public class Card implements Comparable<Card>{

    private final Rank rank;
    private final Suit suit;

    public enum Suit{ // TODO: 為什麼 Suit 不用 Comparable
        SPADE('♠'), HEART('♥'), DIAMOND('♦'), CLUB('♣');

        private final char representation;
        Suit (char representation){
            this.representation = representation;
        }

        @Override
        public String toString() {
            return String.valueOf(representation);
        }
    }

    public enum Rank implements Comparable<Rank> { //TODO: Comparable 要研究一下 enum 為什麼不用寫compare to 方法
        R2("2"),
        R3("3"), R4("4"), R5("5"),
        R6("6"), R7("7"), R8("8"),
        R9("9"), R10("10"),
        J("J"), Q("Q"), K("K"),
        A("A");

        private final String representation;

        Rank(String representation){
            this.representation = representation;
        }

        @Override
        public String toString() {
            return representation;
        }
    }


    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    // TODO: Check 這邊的用法
    @Override
    public int compareTo(Card card) {
        if (this.getRank() == card.getRank()) {
            return this.getSuit().compareTo(card.getSuit());
        }
        return this.getRank().compareTo(card.getRank());
    }

    @Override
    public String toString() {
        return String.format("%s%s", suit, rank);
    }
}