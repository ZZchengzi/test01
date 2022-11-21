package card;

import java.util.*;

public class Init {

    private List<Card> allcards;//全部扑克牌

    public Init(){
        this.allcards = new ArrayList<Card>();//实例化
    }

    public Init(List<Card> allcards, String name) {
        this.allcards = allcards;
        this.name = name;
    }

    public List<Card> getAllcards() {
        return allcards;
    }

    public void setAllcards(List<Card> allcards) {
        this.allcards = allcards;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
     * 创建扑克牌
     */
    public void setup(){
        String color[] = {"黑桃","红桃","梅花","方片"};
        String point[] = {"A","K","Q","J","10","9","8","7","6","5","4","3","2"};
        for(int i=0;i<4;i++){
            for(int j = 0;j<13;j++){
                Card poker = new Card(color[i],point[j]);
                allcards.add(poker);
            }
        }
    }
//    /*
//     * 通过for each方法访问集合元素
//     */
//    public void print(){
//        System.out.println("扑克牌有：");
//        for(Object obj:allcards){
//            Card card = (Card)obj;
//            System.out.println(card.color+card.points+",");
//        }
//    }

    /*
     * 创建玩家
     */
    private String name;
    public int createPlayer(int num){
        Scanner input;
        input = new Scanner(System.in);
        System.out.println("请输入第"+num+"位玩家的姓名");
        name = input.next();
        return 0;
    }
    /*
     * 发牌
     */
    public void deal(Players playernum){
        Card card = this.allcards.get(0);
        playernum.getHandCards().add(card);
        this.allcards.remove(card);
        //System.out.println("\t\t\t\t|\t\t玩家"+playernum.getName()+"拿牌\t\t\t\t|");

    }
    /*
     * 比较牌面大小
     */
    public Card pkPoker(Card a, Card b){
        ArrayList<String> color = new ArrayList<String>(Arrays.asList("黑桃","红桃","梅花","方片"));
        ArrayList<String> point = new ArrayList<String>(Arrays.asList("A","K","Q","J","10","9","8","7","6","5","4","3","2"));
        if(point.indexOf(a.points)<point.indexOf(b.points)){
            return a;
        }else if(point.indexOf(a.points)>point.indexOf(b.points)){
            return b;
        }else{
            if(color.indexOf(a.color)>color.indexOf(b.color)){
                return b;
            }else{
                return a;
            }
        }
    }
}
