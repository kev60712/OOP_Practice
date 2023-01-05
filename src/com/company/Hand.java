package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Hand implements Iterable<Card>{ // 要了解一下什麼是 Iterable

    private final List<Card> cardList = new ArrayList<>();

    public void addCard(Card card){
        this.cardList.add(card);
    }

    public Card getCard(int index){
        return cardList.get(index);
    }

    public Card showCard(int index){
        return cardList.remove(index);
    }

    public int size(){
        return cardList.size();
    }


    public void printCards(){
        for (int i = 0; i < cardList.size(); i++){
            Card card = cardList.get(i);
            System.out.println(String.format("Index: %s, Card: %s", i, card.toString()));
        }
    }

    @Override
    public Iterator<Card> iterator() {
        return cardList.iterator();
    }
}

