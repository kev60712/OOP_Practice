package C1M2H1.ShowDownGame;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.String.format;
import static java.util.stream.Collectors.joining;
import static java.util.stream.IntStream.range;

public class HumanPlayer extends Player{

    private final static Scanner scanner = new Scanner(System.in); // 為何要用final static 可以研究一下

    @Override
    public void nameHimself(int order) {
        System.out.println("What is your name?");
        String name = scanner.next();
        if (name.isEmpty()){
            nameHimself(order); // 再輸入一次
        }else {
            setName(name);
        }
    }

    @Override
    public Optional<ExchangeHand> makeExchangeHandDecision() {
        System.out.print(String.format("Would you like to perform hands exchange? (y/n): "));
        String answer = scanner.next().toLowerCase().trim(); // 此寫法也可以多練習
        if (answer.equals("y")) {
            List<Player> players = getShowDown().getPlayers().stream().filter(p -> p != this).collect(Collectors.toList()); // 排除自己
            return Optional.of(selectExchangeHandTarget(players));
        }else {
            return Optional.empty();
        }
    }

    public ExchangeHand selectExchangeHandTarget(List<Player> players){
        printPlayerChoices(players);
        int targetIndex = scanner.nextInt();
        if (targetIndex >= players.size() || targetIndex < 0){ // 如果輸入錯數字就在選一次
            return selectExchangeHandTarget(players);
        }
        return new ExchangeHand(this, players.get(targetIndex));
    }

    private void printPlayerChoices(List<Player> players){
        String playerChoices = String.format("Select the target %s:",
                range(0, players.size()).mapToObj(i -> format("(%d) %s", i, players.get(i).getName())).collect(joining(" "))
        ); // Select the target (0) AI-2 (1) AI-3 (2) AI-4:
        System.out.println(playerChoices);
    }

    @Override
    public Card showCard() {
        this.getHand().printCards();
        System.out.println("Choose your card.");
        int index = scanner.nextInt();
        return this.getHand().showCard(index);
    }
}
