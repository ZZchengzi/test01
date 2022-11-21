package card;

import java.util.HashSet;
import java.util.Set;

public class Players {

    private String name;//玩家姓名
    /*
     * 带有泛型Poker的Set的类型属性
     *
     */
    private Set<Card> handCards;//玩家手牌，使用集合框架Collection接口下面的Set子接口

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Card> getHandCards() {
        return handCards;
    }

    public void setHandCards(Set<Card> handCards) {
        this.handCards = handCards;
    }

    /*
     * 带参构造函数
     *
     */
    public Players(String name){
        this.name = name;
        this.handCards = new HashSet<Card>();//实例化，使用HashSet接口对玩家手牌进行实例化
    }
}
