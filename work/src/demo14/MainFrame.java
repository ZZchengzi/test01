package demo14;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

public class MainFrame extends JFrame
{
    private SNK SNK;    //蛇
    private JPanel jpanel;//游戏棋盘
    private Timer timer;//定时器,在指定的时间调用蛇移动的方法
    private Node food;      //食物
    public MainFrame()throws HeadlessException
    {   //初始化窗口参数
        initFrame();
        //初始化游戏棋盘
        initGamePanel();
        //初始化蛇
        initSNK();
        //初始化食物
        initFood();
        //初始化定时器
        initTimer();
        //设置键盘监听，让蛇随着上下左右移动
        setKeyListener();
    }

    private void initFood()
    {
        food=new Node();
        food.random();
    }

    private void setKeyListener()        //设置键盘监听
    {
        addKeyListener(new KeyAdapter()
                //当键盘按下会自动调用此方法
        {
            @Override
            public void keyPressed(KeyEvent e)
            //键盘中的每个键都有编号
            {        switch(e.getKeyCode())
            {
                case KeyEvent.VK_UP:
                    if(SNK.getDirection()!=Direction.DOWN) {
                        SNK.setDirection(Direction.UP);
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(SNK.getDirection()!=Direction.UP) {
                        SNK.setDirection(Direction.DOWN);
                    }
                    break;
                case KeyEvent.VK_LEFT:
                    if(SNK.getDirection()!=Direction.RIGHT) {
                        SNK.setDirection(Direction.LEFT);
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(SNK.getDirection()!=Direction.LEFT) {
                        SNK.setDirection(Direction.RIGHT);
                    }
                    break;
            }
            }
        });
    }

    //初始化定时器
    private void initTimer()
    {
        //创建定时器对象
        timer=new Timer();
        //初始化定时任务
        TimerTask timerTask=new TimerTask()
        {
            @Override
            public void run()
            {
                SNK.move();
                //判断蛇头是否与食物重合
                Node head=SNK.getBody().getFirst();
                if(head.getx()==food.getx()&&head.gety()==food.gety())
                {
                    SNK.eat(food);
                    food.random();
                }
                //重绘游戏棋盘
                jpanel.repaint();
            }
        };
        //每100毫秒，执行一次定时任务
        timer.scheduleAtFixedRate(timerTask,0,100);
    }

    private void initSNK()
    {
        SNK=new SNK();
    }
    //初始化游戏棋盘
    public void initGamePanel()
    {
        jpanel=new JPanel()
        {
            //绘制
            @Override
            public void paint(Graphics g)       //Graphics g可以理解为一个画笔
            {
                //清空棋盘
                g.clearRect(0,0,600,600);
                //super.paint(g);
                //绘制横线
                for(int i=0;i<=35;i++)
                {
                    g.drawLine(0,i*15,600,i*15);
                }
                //绘制竖线
                for(int i=0;i<=36;i++)
                {
                    g.drawLine(i*15,0,i*15,600);
                }
                //绘制蛇
                LinkedList<Node> body=SNK.getBody();
                for(Node node:body)
                {
                    g.fillRect(node.getx()*15,node.gety()*15,15,15);
                }
                //绘制食物
                g.fillRect(food.getx()*15,food.gety()*15,15,15);
            }
        };
        add(jpanel);
    }
    //初始化窗口参数
    public void initFrame()
    {   //设置窗体长宽高
        setSize(540,575);
        //设置窗口位置
        setLocation(240,50);
        //设置关闭按钮
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //规定窗口大小不可变
        setResizable(false);
    }
    public static void main(String[]args)
    {
        new MainFrame().setVisible(true);
    }
}
