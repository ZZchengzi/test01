package demo13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
public class GamePanel extends JPanel implements KeyListener, ActionListener {
    int[] snakeX = new int[500];//贪吃蛇横坐标
    int[] snakeY = new int[500];//贪吃蛇纵坐标
    int foodX;//食物横坐标
    int foodY;//食物蛇纵坐标
    int length;//贪吃蛇的长度
    String  direction;//贪吃蛇头方向
    int score;//积分
    Random r = new Random();
    Timer timer = new Timer(100,this);
    boolean isStart;
    boolean isFail;
    //构造函数
    public GamePanel(){
        init();
        this.setFocusable(true);
        this.addKeyListener(this);
        timer.start();
    }
    private void init(){
        length=3;
        snakeX[0]=100;snakeY[0]=100;
        snakeX[1]=75;snakeY[1]=100;
        snakeX[2]=50;snakeY[2]=100;
        direction = "R";
        eat(foodX,foodY);
        isStart = false;
        isFail = false;
        score = 0;

    }
    private void eat(int x,int y){
        x= 25 + 25*r.nextInt(34);
        y= 75 + 25*r.nextInt(24);
        for (int i = 0; i < length; i++) {
            if(snakeX[i]==x&&snakeY[i]==y){
                x = 25 + 25*r.nextInt(34);
                y = 75 + 25*r.nextInt(24);
            }
        }
        foodX = x;foodY = y;
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.white);//设置背景板为白色
        //画标题
        g.setColor(Color.GREEN);
        g.setFont(new Font("幼圆",Font.BOLD,50));
        g.drawString("贪吃蛇游戏",300,60);
        //绘制游戏区域
        g.setColor(Color.GRAY);
        g.fillRect(25,75,850,600);
        //画贪吃蛇头部
        if(direction=="R"){
            Data.right.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        else if(direction=="L"){
            Data.left.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        if(direction=="U"){
            Data.up.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        else if(direction=="D"){
            Data.down.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        //画身体
        for (int i = 1; i < length ; i++) {
            Data.body.paintIcon(this,g,snakeX[i],snakeY[i]);
        }
        //画食物
        Data.food.paintIcon(this,g,foodX,foodY);
        //绘制积分栏
        g.setColor(Color.BLACK);
        g.setFont(new Font("幼圆",Font.BOLD,20));
        g.drawString("长度："+length,730,30);
        g.drawString("得分："+score,730,60);
        //游戏开始提醒
        if(isStart==false){
            g.setColor(Color.BLACK);
            g.setFont(new Font("幼圆",Font.BOLD,40));
            g.drawString("按空格键开始游戏",300,300);
        }
        //失败判断
        if(isFail){
            g.setColor(Color.RED);
            g.setFont(new Font("幼圆",Font.BOLD,40));
            g.drawString("游戏失败，按空格键重新开始",300,300);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();//获取按下的按键
        //判断空格
        if(keyCode==KeyEvent.VK_SPACE){
            if(isFail){
                isFail = false;
                init();
            }
            else{
                isStart = !isStart;
            }
            repaint();
        }
        //判断方向
        if(keyCode==KeyEvent.VK_LEFT&&direction!="R"){
            direction = "L";
        }
        else if(keyCode==KeyEvent.VK_RIGHT&&direction!="L"){
            direction = "R";
        }
        else if(keyCode==KeyEvent.VK_UP&&direction!="D"){
            direction = "U";
        }
        else if(keyCode==KeyEvent.VK_DOWN&&direction!="U"){
            direction = "D";
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
    @Override
    public void keyTyped(KeyEvent e) {
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //判断游戏状态
        if(isStart&&!isFail){
            //移动身体
            for (int i = length-1; i > 0 ; i--) {
                snakeX[i] = snakeX[i-1];
                snakeY[i] = snakeY[i-1];
            }
            //移动头部
            if(direction=="R"){
                snakeX[0] += 25;
                if(snakeX[0]>850){
                    snakeX[0] = 25;
                }
            }
            else  if(direction=="L"){
                snakeX[0] -= 25;
                if(snakeX[0]<25){
                    snakeX[0] = 850;
                }
            }
            else  if(direction=="U"){
                snakeY[0] -= 25;
                if(snakeY[0]<75){
                    snakeY[0] = 650;
                }
            }
            else  if(direction=="D"){
                snakeY[0] += 25;
                if(snakeY[0]>650){
                    snakeY[0] = 75;
                }
            }
            //吃食物
            if(snakeX[0]==foodX&&snakeY[0]==foodY){
                length++;
                score += 10;
                eat(foodX,foodY);
            }
            //死亡判定
            for (int i = 1; i < length; i++) {
                if(snakeX[0]==snakeX[i]&&snakeY[0]==snakeY[i]){
                    isFail=true;
                }
            }
            repaint();
        }
        timer.start();
    }}
