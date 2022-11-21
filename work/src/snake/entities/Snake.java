package snake.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import snake.listener.SnakeListener;
import snake.util.Global;

public class Snake {

    //定义方向变量，用来控制蛇的方向
    public static final int UP = -1;
    public static final int DOWN = 1;
    public static final int LEFT = 2;
    public static final int RIGHT = -2;
    /*
     *    定义一个旧方向，和新方向。用来在改变方向时
     * 判断新方向与旧方向是否相同，如果相同则说明
     * 是无效方向，忽略。如果不同方向改变
     */
    private int oldDirection, newDirection;

    Ground ground = new Ground();
    //定义一个坐标，用来存放食物坐标
    public Point point = null;
    //存放蛇身体总长度，占用坐标个数
    public int snakeBodyCount;
    private Point oldTail;//存放尾巴的坐标
    private boolean life; //判断蛇是否活着
    private boolean pause; //蛇是否暂停
    private boolean isPause; //每次开开局蛇为暂停状态
    public boolean isDie; //蛇是否死亡
    public int speed = 500; //初始化蛇速度： 500ms/格

    //存放蛇身体节点坐标
    private LinkedList<Point> body =
            new LinkedList<Point>();
    //定义蛇监听列表
    private Set<SnakeListener> listener =
            new HashSet<SnakeListener>();

    //构造方法，进行蛇的初始化
    public Snake() {
        init();
    }
    /*
     * 初始化蛇的位置，让蛇头出现在游戏界面中心，
     */
    public void init() {
        int x = Global.WIDTH/ 2 - 3;
        int y = Global.HEIGHT / 2 ;
        //初始化蛇，给蛇添加三个节点
        for(int i = 0; i < 3; i++) {
            body.addLast(new Point(x--, y));
        }
        //初始化方向，向右
        oldDirection = newDirection = RIGHT;
        life = true;
        pause = false;
        isPause = true;

    }
    /*
     * 蛇移动，先判断新旧方向是否相同，相同则忽略
     * 不同，进行改变方向。蛇移动，通过添加一个头节点，
     * 去除一个最后一个节点，达到移动的目的
     */
    public void move() {
        if (!(oldDirection + newDirection == 0)) {
            oldDirection = newDirection;
        }
        //去尾
        oldTail = body.removeLast();
        int x = body.getFirst().x;
        int y = body.getFirst().y;
        switch(oldDirection) {
            case UP: //向上移动
                y--;
                //到边上了可以从另一边出现
                if (y < 0) {
                    y = Global.HEIGHT - 1;
                }
                break;
            case DOWN:
                y++;
                //到边上了可以从另一边出现
                if (y >= Global.HEIGHT) {
                    y = 0;
                }
                break;
            case LEFT:
                x--;
                if (x < 0) {
                    x = Global.WIDTH - 1;
                }
                break;
            case RIGHT:
                x++;
                if (x >= Global.WIDTH) {
                    x = 0;
                }
                break;

        }
        //记录蛇头的坐标
        Point newHead = new Point(x, y);
        //加头
        body.addFirst(newHead);
    }
    //蛇改变方向
    public void chanceDirection(int direction) {
        newDirection = direction;

    }
    //蛇吃食物
    public void eatFood() {
        //通过添加删去的最后的尾节点，达到吃食物的目的
        body.addLast(oldTail);

    }

    //判断蛇是否吃到身体
    public boolean isEatBody() {
        //body.get(0)存放的为蛇头的坐标，
        //所有要排除蛇头，从i=1开始比较
        for (int i = 1; i < body.size(); i++) {
            if (body.get(i).equals(getHead())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取蛇的snakeBody链表，让食物与蛇身不重叠
     *        body    表示蛇身体的链表
     * 返回与蛇身体坐标不重复的坐标
     */
    public Point getFood(LinkedList<Point> body) {
        //获得与石头不重叠的坐标
        point = ground.getPoint();
        while (checkPoints(body)) {
            point = ground.getPoint();
        }
        // 如果发现食物的位置和蛇身体重叠，则重新随机食物的位置
        return point;
        // 返回这个对象本身，为创建实例时带来方便
    }
    //获得食物坐标
    public Point getFoodPoint() {
        return getFood(body);
    }

    /**
     * 检查蛇身体链表中是否有一块与当前食物坐标相同
     * @return 如果有重复返回true
     * 否则返回 false
     */
    public boolean checkPoints(LinkedList<Point> body) {

        for (Point p : body)
            if (p.getX() == point.getX() && p.getY() == point.getY())
                return true;
        // 循环遍历是否有重复
        return false;
    }


    //画蛇
    public void drawMe(Graphics g) {
        for(Point p : body) {
            g.setColor(Color.PINK);//设置身体颜色
            g.fill3DRect(p.x * Global.CELL_SIZE, p.y * Global.CELL_SIZE,
                    Global.CELL_SIZE, Global.CELL_SIZE, true);
            //最后一个参数，raised 是否凸起的，true为是。
        }
        //画蛇头，覆盖蛇头位置
        g.setColor(Color.RED);
        g.fill3DRect(getHead().x * Global.CELL_SIZE, getHead().y * Global.CELL_SIZE,
                Global.CELL_SIZE, Global.CELL_SIZE, true);
    }

    //获得蛇头的坐标
    public Point getHead() {
        return body.getFirst();
    }
    //蛇死亡，生命改为false
    public void die() {
        life = false;
        isDie = true;

    }

    //一个内部类, 驱动蛇定时移动
    public class SnakerDriver implements Runnable{

        public void run() {
            //当蛇活着的时候才进行循环
            while(life) {
                //入伙蛇没有暂停才能移动
                if (!pause) {
                    move();
                    //蛇每次移动后，获得蛇身体总长度
                    getSnakeBodyCount();
                    //触发 SnakeListener 的状态改变事件
                    for(SnakeListener l : listener) {
                        l.snakeMove(Snake.this);
                    }
                    //让蛇开开始时为暂停状态
                    if (isPause) {
                        pause = true;
                        isPause = false;
                    }
                }
                try {
                    //定时移动
                    Thread.sleep(speed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //让蛇开始运动， 开启一个新的线程
    public void start() {
        new Thread(new SnakerDriver()).start();
    }

    //添加监听器
    public void addSnakeListener(SnakeListener l) {
        if(l != null) {
            this.listener.add(l);
        }
    }

    public void getSnakeBodyCount() {
        snakeBodyCount = body.size();
    }
    //改变蛇暂停状态
    public void changePause() {
        pause = !pause;
    }
    //清除身体所有节点
    public void bodyClear() {
        body.clear();
    }
}
