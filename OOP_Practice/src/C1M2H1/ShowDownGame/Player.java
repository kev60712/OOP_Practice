package C1M2H1.ShowDownGame;

import java.util.Objects;
import java.util.Optional;

public abstract class Player {

    private int point = 0;
    private String name;
    private Hand hand = new Hand();
    private ExchangeHand exchangeHand;
    private ShowDown showDown; // 為了等等可以從showdown裡面找出所有player

    public TurnMove takeTurn(){
        Optional<ExchangeHand> exchangeHand = hasUsedExchangeHand() ? Optional.empty() : makeExchangeHandDecision();
        TurnMove turnMove = new TurnMove(this, exchangeHand, showCard());
        turnMove.getExchangeHand().ifPresent(this::setExchangeHand);
//        if (turnMove.getExchangeHand().isPresent()){
//            setExchangeHand(turnMove.getExchangeHand().get());
//        }
        getExchangeHand().ifPresent(ExchangeHand::countdown);
//        if (getExchangeHand().isPresent()){
//            getExchangeHand().get().countdown();
//        }
        return turnMove;
    };

    public abstract void nameHimself(int order); // 增加order是為了等等方便AI命名

    public abstract Optional<ExchangeHand> makeExchangeHandDecision(); // 代表有可能有換也可能沒換

    public abstract Card showCard();

    public void addHandCard(Card card){
        hand.addCard(card);
    }

    public void gainPoint(){
        point++;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = Objects.requireNonNull(name); // RequireNonNull 寫法很好
    }

    public Optional<ExchangeHand> getExchangeHand(){ // 有可能是沒有的
        return Optional.ofNullable(exchangeHand);
    }

    public void setExchangeHand(ExchangeHand exchangeHand){
        this.exchangeHand = exchangeHand;
    }

    public boolean hasUsedExchangeHand(){
        return exchangeHand != null;
    }

    public int getPoint(){
        return point;
    }

    public void setPoint(int point){
        this.point = point;
    }

    public Hand getHand(){
        return hand;
    }

    public void setHand(Hand hand){
        this.hand = Objects.requireNonNull(hand);
    }

    public ShowDown getShowDown(){
        return showDown;
    }

    public void setShowDown(ShowDown showDown){
        this.showDown = showDown;
    }
}