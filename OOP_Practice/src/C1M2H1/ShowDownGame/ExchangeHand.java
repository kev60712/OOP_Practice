package C1M2H1.ShowDownGame;

public class ExchangeHand {

    private final Player source;
    private final Player target;
    private int round = 3;

    public ExchangeHand(Player source, Player target) {
        this.source = source;
        this.target = target;
        exchange();
    }

    private void exchange(){
        Hand hand = source.getHand();
        source.setHand(target.getHand());
        target.setHand(hand);
        System.out.println(String.format("You have exchanged your hand with the player %s.", target.getName()));
    }

    public void countdown(){
        round--;
        if (round == 0){
            exchange(); // 換回去
        }
    }
}

