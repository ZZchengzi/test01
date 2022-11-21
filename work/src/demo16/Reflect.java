package demo16;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

//反射的测试类
public class Reflect {

    public static void reflect(){

        Class a = null;
        try {
            a = Class.forName("demo16.AddEquation$AddEquationBuilder");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //获取字段
        Field[] fields = a.getDeclaredFields();

        //获取方法
        Method[] methods = a.getDeclaredMethods();

        System.out.println("AddEquation类的字段有：");
        for (Field i: fields) {
            System.out.print(i.getName() + " ");
        }

        System.out.println("\nAddEquation类的方法有：");

        for (Method m: methods) {
            System.out.println(m.getName());
        }


        try {
            //获取无参构造方法
            Method m = null;
            m = a.getMethod("build");

            //通过反射 生成AddEquation内部类
            AddEquation.AddEquationBuilder builder = null;
            builder = (AddEquation.AddEquationBuilder) a.getDeclaredConstructor().newInstance();

            //创建实例
            AddEquation equation = (AddEquation) m.invoke(builder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
