package com.company;

import java.util.Optional;

public class TurnMove {
    private final Player player;
    private final Optional<ExchangeHand> exchangeHand;
    private final Card showCard;

    public TurnMove(Player player, Optional<ExchangeHand> exchangeHand, Card showCard) {
        this.player = player;
        this.exchangeHand = exchangeHand;
        this.showCard = showCard;
    }

    public Player getPlayer() {
        return player;
    }

    public Optional<ExchangeHand> getExchangeHand() {
        return exchangeHand;
    }

    public Card getShowCard() {
        return showCard;
    }
}

