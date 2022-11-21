package card;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

public class Start {
    public static void main(String args[]){
        DayUnilt.storeStart();
        Init game = new Init();
        System.out.println("进行几轮赌局:");
        Scanner scanner = new Scanner(System.in);
        int round = 1;
        do {
            if(round > 13 || round <= 0) System.out.println("请输入正确的局数（1~13）");
            round = scanner.nextInt();
        }while ((round > 13) || (round <= 0));
        System.out.println("————————————创建扑克牌——————————");
        game.setup();
        System.out.println("扑克牌创建成功！");
        //game.print();
        System.out.println("开始洗牌");
        Collections.shuffle(game.getAllcards() );
        System.out.println("洗牌结束");
        System.out.println("创建玩家");
        game.createPlayer(1);
        Players player1 = new Players(game.getName());
        game.createPlayer(2);
        Players player2 = new Players(game.getName());
        System.out.println("\t\t\t\t|\t\t欢迎玩家: " + player1.getName() + "和" + player2.getName()+"\t\t|");
        for(int i = 0; i < round; i ++) {
            System.out.println("本次赌注为：");
            String thing = scanner.next();
            System.out.println("\t\t\t\t|      \t现在开始发牌\t\t\t\t|");

            game.deal(player1);
            game.deal(player2);
            game.deal(player1);
            game.deal(player2);

            System.out.println("\t\t\t\t|\t\t发牌结束,游戏开始!\t\t|");

            Card card = new Card("方片", "2");
            for (Card c : player1.getHandCards()) {
                card = game.pkPoker(card, c);
            }
            System.out.println("\t\t\t\t|\t玩家" + player1.getName() + "最大的手牌为:" + card.color + card.points + "\t\t|");

            Card temp2 = new Card("方片", "2");
            for (Card c : player2.getHandCards()) {
                temp2 = game.pkPoker(temp2, c);
            }
            System.out.println("\t\t\t\t|\t玩家" + player2.getName() + "最大的手牌为:" + temp2.color + temp2.points + "\t\t|");
            String winname;
            if (game.pkPoker(card, temp2) == card)
                winname = player1.getName();
            else winname = player2.getName();
            System.out.println("\t\t\t\t|\t\t玩家" + winname + "获胜!\t\t\t\t|");
            System.out.println("\t\t\t\t|\t\t玩家各自手牌为：\t\t\t|");
            System.out.print("\t\t\t\t|\t\t" + player1.getName() + ":");
            for (Card c : player1.getHandCards()) {
                System.out.print("[" + c.color + c.points + "] ");
            }
            player1.getHandCards().clear();

            System.out.println("\t\t|");
            System.out.print("\t\t\t\t|\t\t" + player2.getName() + ":");
            for (Card c : player2.getHandCards()) {
                System.out.print("[" + c.color + c.points + "] ");
            }
            player2.getHandCards().clear();
            System.out.println("\t\t|");
            DayUnilt.storeRound(i + 1,winname,thing);
        }
        System.out.println("---------------------正在记录本次赌局---------------------");
        System.out.println("-------------------------记录完成------------------------");
    }
}
