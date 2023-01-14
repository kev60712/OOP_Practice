package C1M2H1.ShowDownGame;

import java.util.*;
import java.util.stream.Collectors;

public class ShowDown {

    public static final int NUM_OF_ROUNDS = 13;
    private final Deck deck;
    private final List<Player> players;
    private final List<TurnMove> turnMoves = new ArrayList<>(); // 記錄 每一 round 玩家的行為

    public ShowDown(Deck deck, List<Player> players) {
        this.deck = deck;
        this.players = players;
        players.forEach(p -> p.setShowDown(this)); // functional 寫法
//        for (Player player : players) {
//            player.setShowDown(this);
//        }
    }

    public void start(){
//        Collections.shuffle(players);
        playerSetUpName();
        deck.shuffle();
        dealCard();
        playRounds();
        gameOver();
    }

    private void playerSetUpName(){
        for (int i = 0; i < players.size(); i++){
            players.get(i).nameHimself(i + 1);
        }
    }

    private void dealCard(){
        int cardSize = deck.size()/players.size();
        for (Player player : players) {
            for (int i = 0; i < cardSize; i++){
                Card card = deck.drawCard();
                player.addHandCard(card);
            }
        }
    }

    private void playRounds(){
        for (int i = 0; i < NUM_OF_ROUNDS; i++){
            players.forEach(this::takeTurn); // 這個寫法要在學一下
//            for (Player player : players) {
//                takeTurn(player);
//            }
            showdown();
            turnMoves.clear(); // ??
        }
    }

    private void takeTurn(Player player){
        System.out.println(String.format("It's %s's turn.", player.getName()));
        TurnMove turnMove = player.takeTurn();
        turnMoves.add(turnMove);
    }

    private void showdown(){
        printShowCards();
        // 此寫法也可練一練
        TurnMove winnerTurnMove = Collections.max(turnMoves, Comparator.comparing(TurnMove::getShowCard));
        Player winner = winnerTurnMove.getPlayer();
        winner.gainPoint();
        System.out.println(String.format("%s wins this round.", winner.getName()));
    }

    private void printShowCards(){
        System.out.print("Show Cards: ");
        // 這個寫法也可練一練
        String cards = turnMoves.stream()
                .map(TurnMove::getShowCard)
                .map(Objects::toString).collect(Collectors.joining(" "));
        // Show Cards: ♦5 ♥4 ♣3 ♥5
        System.out.println(cards);
    }


    private void gameOver(){
        Player winner = Collections.max(players, Comparator.comparingInt(Player::getPoint)); // 這寫法可在練習
        System.out.println(String.format("The winner is %s", winner.getName()));
    }

    public List<Player> getPlayers(){
        return players;
    }
}

