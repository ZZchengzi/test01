package card;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DayUnilt {
       private static File file;
       private static FileWriter fw;
      static {
          file = new File("D://hello.txt");
        if(!file.exists())
        {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            fw = new FileWriter("D://hello.txt",true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static boolean storeStart() {
        Date now = new Date();
        SimpleDateFormat f = new SimpleDateFormat("游戏开始时间：" + "yyyy年MM月dd日EHH点mm分ss秒" + "\n");
        try {
            fw.write(f.format(now));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        try {
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
    static boolean storeRound(int round, String name,String thing){
        try {
            fw = new FileWriter("D://hello.txt",true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String s = "回合"+round + "," +"玩家"+name+"胜"+",赌注为："+thing + "\n";
        try {
            fw.write(s);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        try {
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
