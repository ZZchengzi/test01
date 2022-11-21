package demo13;

import javax.swing.*;
import java.awt.*;

public class StartGame {
    public static void main(String[] args){
        //建立游戏窗口
        JFrame frame = new JFrame("Java-贪吃蛇小游戏");//标题
        frame.setSize(900,720);//窗口大小
        frame.setLocationRelativeTo(null);//窗口显示屏幕中间
        frame.setResizable(false);//固定窗口大小
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗体关闭事件
        frame.add(new GamePanel());//添加游戏内容
        frame.setVisible(true);//设置窗体可见
    }
}
