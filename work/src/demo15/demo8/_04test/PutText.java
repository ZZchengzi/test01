package demo15.demo8._04test;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/*
* 文件操作
* */
public class PutText {

    /*
    * 直接在创建对象的时候变读边写
    * */
    public PutText(ArrayList<Equation> equations, String s) {
        writeTxt(equations,s);
        readTxt(s);
    }

    /*
    * 文件写入
    * */
    public static void writeTxt(ArrayList<Equation> list, String s){

        FileOutputStream fileOutputStream=null;
        try {
            int result;
            //true的作用是往文件中写入并追加
            fileOutputStream=new FileOutputStream(s,true);
            for (Equation equation : list) {
                if (Objects.equals(equation.getOperate(), "+")) {
                    result = equation.getA() + equation.getB();
                } else {
                    result = equation.getA() - equation.getB();
                }
                String string = equation.getA() + String.valueOf(equation.getOperate()) + equation.getB() + "=" + result + "\n";
                fileOutputStream.write(string.getBytes());
            }
            fileOutputStream.close();
            System.out.println("数据写入文件成功！");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*
    * 文件读取
    * */
    public static void readTxt(String s) {

        BufferedReader reader;
        try {
            //按行读取文件
            reader = new BufferedReader(new FileReader(s));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
