package demo13;
import javax.swing.*;import java.net.URL;

public class Data {

        //贪吃蛇头部
        public static URL upUrl = Data.class.getResource("./image/up.png");
        public static ImageIcon up = new ImageIcon(upUrl);
        public static URL downUrl = Data.class.getResource("./image/down.png");
        public static ImageIcon down = new ImageIcon(downUrl);
        public static URL leftUrl = Data.class.getResource("./image/left.png");
        public static ImageIcon left = new ImageIcon(leftUrl);
        public static URL rightUrl = Data.class.getResource("./image/right.png");
        public static ImageIcon right = new ImageIcon(rightUrl);
        //贪食蛇身体
        public static URL bodyUrl = Data.class.getResource("./image/body.png");
        public static ImageIcon body = new ImageIcon(bodyUrl);
        //食物
        public static URL foodUrl = Data.class.getResource("./image/food.png");
        public static ImageIcon food = new ImageIcon(foodUrl);
}
