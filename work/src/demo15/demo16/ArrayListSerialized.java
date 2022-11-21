package demo15.demo16;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//序列化工具类
public class ArrayListSerialized
{
    //将题目存储到 listData中
    public static void serialize(List<Equation> equations){
        try {
            FileOutputStream fos = new FileOutputStream("listData");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(equations);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //读取文件 返回文件中的题目
    public static List<Equation> deserialize(){
        List<Equation> equations = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream("listData");
            ObjectInputStream ois = new ObjectInputStream(fis);
            equations = (List<Equation>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return equations;
    }
}
