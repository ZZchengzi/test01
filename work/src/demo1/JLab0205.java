package demo1;

public class JLab0205 {
    public static void test() {
        System.out.println("test() invoked");
    }

    public static int test(int i) {
        System.out.println("test(" + i + ") invoked");
        return i;
    }
    public static String test(String s) {
        System.out.println("test(" + s + ") invoked");
        return s;
    }
    public static void test(String s, int i) {
        System.out.println("test(" + s + ", " + i + ") invoked");
    }
    public static void test(int i, String s) {
        System.out.println("test(" + i + ", " + s + ") invoked");
    }
    public static void main(String[] args) {
        test();
        test(100);
        test("test");
        test("test",100);
        test(100,"test");
    }
}
