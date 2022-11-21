package demo15.demo8._04test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflect {

    public void reflect(String str) throws ClassNotFoundException {
        Class<?> addEquation = Class.forName(str);//获取对象
        Field[] fields = addEquation.getDeclaredFields();
        Method[] methods = addEquation.getMethods();
        try {
            Object o=addEquation.newInstance();//调用无参构造，实例化对象,强转为AddEquation
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        System.out.println("属性如下：");
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println(field.getName());
        }
        System.out.println("方法名如下：");
        for (Method method : methods) {
            System.out.println(method.getName());
        }

    }
}
