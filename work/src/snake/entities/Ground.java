package snake.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import snake.util.Global;

public class Ground {
    /*
     *定义存放石头坐标的数组，1为石头，0为空白区域。
     *一定要用全局静态变量，始终占用空间。否则会在产生食物时出错
     */
    private static final int rocks[][] =
            new int[Global.WIDTH][Global.HEIGHT];
    //存放石头的个数
    public int rocksCount = 0;
    //是否画网格
    private boolean isDrawGriding;
    //选择地图是使用
    public int MAP = 1;
    //构造方法，初始化地图
    public Ground() {
        init();
    }
    //清除所有石头
    public void clear() {
        for (int x = 0; x < Global.WIDTH; x++)
            for (int y = 0; y < Global.HEIGHT; y++)
                rocks[x][y] = 0;
    }
    //初始化石头位置
    public void init() {
        //清除所有石头
        clear();
        //选择地图
        switch(MAP) {
            case 1:
                map1(); //地图1
                //获得石头个数
                getScoksCount();
                break;
            case 2:
                map2(); //地图2
                getScoksCount();
                break;
            case 3:
                map3(); //随机地图
                getScoksCount();
                break;
            default :
                map1(); //默认地图1
                getScoksCount();
                break;
        }
    }
    //第一组默认地图石头坐标
    public void map1() {
        for(int x = 0; x < Global.WIDTH; x++) {
            rocks[x][0] = 1;
            rocks[x][Global.HEIGHT-1] = 1;
        }
        for(int y = 0; y < Global.HEIGHT; y++) {
            rocks[0][y] = 1;
            rocks[Global.WIDTH-1][y]  = 1;
        }
    }
    //第二个地图
    public void map2() {
        for(int x = 5; x < Global.WIDTH-5; x++) {
            rocks[x][5] = 1;
            rocks[x][Global.HEIGHT-4] = 1;
        }
        for(int y = 9; y < Global.HEIGHT-8; y++) {
            rocks[9][y] = 1;
            rocks[Global.WIDTH-9][y] = 1;
        }
    }
    //随机地图，随机获得40个坐标座位石头
    public void map3() {
        Random random = new Random();
        int x = 0,y = 0;
        for(int i = 0; i < 40; i++) {
            x = random.nextInt(Global.WIDTH);
            y = random.nextInt(Global.HEIGHT);
            rocks[x][y] = 1;
        }
    }

    //获得石头总共数目
    public void getScoksCount() {
        //每次更换地图时清零，重新获得
        rocksCount = 0;
        for (int x = 0; x < Global.WIDTH; x++)
            for (int y = 0; y < Global.HEIGHT; y++)
                if (rocks[x][y] == 1) {
                    rocksCount++;
                }
    }
    //判断蛇是否吃到石头
    //把蛇的所有节点与石头坐标进行比较如果想等则证明吃到石头
    public boolean isSnakeEatRock(Snake snake) {
        for(int x = 0; x < Global.WIDTH; x++) {
            for (int y = 0; y < Global.HEIGHT; y++) {
                if (rocks[x][y] == 1
                        && x == snake.getHead().x
                        && y == snake.getHead().y) {
                    return true;
                }
            }
        }
        return false;
    }
    //获得不会与石头重叠的随机坐标
    public Point getPoint() {
        Random random = new Random();
        int x = 0, y = 0;
        do{
            x = random.nextInt(Global.WIDTH);
            y = random.nextInt(Global.HEIGHT);
        }while(rocks[x][y] == 1);
        return new Point(x, y);
    }
    //画石头和网格
    public void drawMe(Graphics g) {
        drawRocks(g);
        if (isDrawGriding) {
            drawGriding(g);
        }
    }
    //画石头
    public void drawRocks(Graphics g) {
        for(int x = 0; x < Global.WIDTH; x++) {
            for (int y = 0; y < Global.HEIGHT; y++) {
                if (rocks[x][y] == 1) {
                    g.setColor(Color.DARK_GRAY);
                    g.fill3DRect(x * Global.CELL_SIZE, y * Global.CELL_SIZE,
                            Global.CELL_SIZE, Global.CELL_SIZE, true);
                }
            }
        }
    }
    //画网格
    public void drawGriding(Graphics g) {
        for(int x = 0; x < Global.WIDTH; x++) {
            for (int y = 0; y < Global.HEIGHT; y++) {
                g.setColor(Color.GRAY);
                g.fillRect(x * Global.CELL_SIZE , y * Global.CELL_SIZE,
                        1 , Global.HEIGHT * Global.CELL_SIZE);
                g.fillRect(x * Global.CELL_SIZE , y * Global.CELL_SIZE,
                        Global.HEIGHT * Global.CELL_SIZE, 1 );

            }
        }
    }
    //需要要画网格
    public void drawGriding() {
        isDrawGriding = true;
    }
    //不需要画网格
    public void notDrawGriding() {
        isDrawGriding = false;
    }
}
