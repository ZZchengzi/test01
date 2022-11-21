package demo2;

public class JLab0502{
    public static void main(String args[]){
        System.out.println("创建父类对象：");
        SuperClass sc0 = new SuperClass();
        System.out.println("\n创建第一个子类对象：");
        SubClass sc1 = new SubClass();

    }
}
class SuperClass{
    SuperClass( ){
        System.out.println("父类的构造函数");
    }
}
class SubClass extends SuperClass{

}
