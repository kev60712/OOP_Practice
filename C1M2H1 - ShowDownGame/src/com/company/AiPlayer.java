package com.company;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class AiPlayer extends Player{

    private final static Random random = new Random();

    @Override
    public void nameHimself(int order) {
        setName(String.format("AI-%d", order));
    }

    @Override
    public Optional<ExchangeHand> makeExchangeHandDecision() {
        if (hasUsedExchangeHand()) {
            return Optional.empty();
        }
        return random.nextBoolean() ? Optional.empty() : Optional.of(randomlyExchangeHand());
    }

    @Override
    public Card showCard() {
        if (getHand().size() == 1){
            return getHand().getCard(0);
        }
        return getHand().showCard(random.nextInt(getHand().size())); // nextInt() 裡面放數字可以找 range
    }

    private ExchangeHand randomlyExchangeHand(){
        List<Player> players = getShowDown().getPlayers().stream().filter(p -> p != this).collect(Collectors.toList()); // 排除自己
        return new ExchangeHand(this, players.get(random.nextInt(players.size())));
    }
}
