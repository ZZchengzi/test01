package snake.game;

import java.awt.EventQueue;

import snake.view.MainWindow;
/*
 * 作为游戏的主方法，启动游戏，通过启动窗体，实现启动程序
 */
public class Game {

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainWindow frame = new MainWindow();
                    frame.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}