package demo7;

import java.io.*;
import java.util.ArrayList;

public class ArrayListSerialized {
    public static void serialize(ArrayList<Equation> equations){
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
    public static ArrayList<Equation> deserialize(){
        ArrayList<Equation> equations = new ArrayList<Equation>();
        try {
            FileInputStream fis = new FileInputStream("listData");
            ObjectInputStream ois = new ObjectInputStream(fis);
            equations = (ArrayList<Equation>) ois.readObject();
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
