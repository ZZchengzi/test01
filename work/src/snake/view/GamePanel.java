package snake.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import snake.entities.Food;
import snake.entities.Ground;
import snake.entities.Snake;
import snake.util.Global;
//游戏的显示界面
@SuppressWarnings("serial")
public class GamePanel extends JPanel{

    private Snake snake;
    private Food food;
    private Ground ground;
    //显示画面
    public void display(Snake snake, Food food, Ground ground) {
        this.snake = snake;
        this.food = food;
        this.ground = ground;
        //会重新显示，此方法会调用下面的方法
        this.repaint();
    }
    @Override
    protected void paintComponent(Graphics g) {
        //重新显示
        //设置背景颜色
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, Global.WIDTH * Global.CELL_SIZE,
                Global.HEIGHT * Global.CELL_SIZE);
        if(ground != null && snake != null && food != null ) {
            this.ground.drawMe(g);
            this.snake.drawMe(g);
            this.food.drawMe(g);
        }

    }
}
