package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Player> players = Arrays.asList(new HumanPlayer(), new AiPlayer(), new AiPlayer(), new AiPlayer());
        ShowDown showDown = new ShowDown(Deck.standard52Cards(), players);
        showDown.start();
    }
}
