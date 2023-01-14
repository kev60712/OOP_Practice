package C1M2H1.ShowDownGame;

import java.util.Collections;
import java.util.Stack;

public class Deck {
    private final Stack<Card> cardStack = new Stack<>();

    public static Deck standard52Cards(){
        Deck deck = new Deck();
        Card.Suit[] suits = Card.Suit.values(); // TODO: 原來這樣就可以拿到 Enum 所有的值
        Card.Rank[] ranks = Card.Rank.values();
        for (Card.Suit suit: suits){
            for (Card.Rank rank: ranks){
                deck.push(new Card(rank, suit));
            }
        }
        return deck;
    }

    public void push(Card card){
        cardStack.push(card);
    }

    public void shuffle(){
        Collections.shuffle(cardStack);
    }

    public Card drawCard(){
        return this.cardStack.pop();
    }

    public int size(){
        return cardStack.size();
    }
}
