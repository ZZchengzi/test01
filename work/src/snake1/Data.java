package snake1;

import javax.swing.*;
import java.net.URL;

public class Data {
    //头部图片
    public static URL headerUrl = Data.class.getResource("../snake/image/up.png");
    public static ImageIcon header;

    static {
        assert headerUrl != null;
        header = new ImageIcon(headerUrl);
    }

    //头部：上下左右
    public static URL upUrl = Data.class.getResource("../snake/image/up.png");
    public static URL downUrl = Data.class.getResource("../snake/image/down.png");
    public static URL leftUrl = Data.class.getResource("../snake/image/left.png");
    public static URL rightUrl = Data.class.getResource("../snake/image/right.png");
    public static ImageIcon up = new ImageIcon(upUrl);
    public static ImageIcon down = new ImageIcon(downUrl);
    public static ImageIcon left = new ImageIcon(leftUrl);
    public static ImageIcon right = new ImageIcon(rightUrl);
    //身体
    public static URL bodyUrl = Data.class.getResource("../snake/image/body.png");
    public static ImageIcon body;

    static {
        assert bodyUrl != null;
        body = new ImageIcon(bodyUrl);
    }

    //食物
    public static URL foodUrl = Data.class.getResource("../snake/image/food.png");
    public static ImageIcon food;

    static {
        assert foodUrl != null;
        food = new ImageIcon(foodUrl);
    }

}
