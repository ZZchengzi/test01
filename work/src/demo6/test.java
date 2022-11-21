package demo6;


public class test {
    public static void main(String[] args) {
        int x = 0, y = 0, z = 0;//各种鸡的数量  x+y+z=100(只)  5x+3y+z/3=100(元)
        for (x = 0; x <= 20; x++) {//全部买公鸡，最大是20只
            for (y = 0; y <= 33; y++) {//全部买母鸡，最大是33只
                z = 100 - x - y;//小鸡的数量
                if (15 * x + 9 * y + z == 300) {
                    System.out.print("公鸡数量：" + x);
                    System.out.print("\t母鸡数量：" + y);
                    System.out.print("\t小鸡数量：" + z);
                    System.out.print("\t---->公鸡金额：" + 5*x);
                    System.out.print("\t母鸡金额：" + 3*y);
                    System.out.print("\t小鸡金额：" + z/3);
                    System.out.println();
                }
            }
        }
    }
}
