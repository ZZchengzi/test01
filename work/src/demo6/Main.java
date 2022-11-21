package demo6;

public class Main {
    public static void main(String[] args) {
        int cnt = 0;
        for (int i = 0; i <= 100 / 5; i ++)
        {
            for(int j = 0; j <= 100 / 3; j ++)
            {
                int k = 100 - (i * 5 + j * 3);
                if(k < 0) continue;
                if(k * 3 + i + j == 100){
                    cnt++;
                    System.out.printf("鸡翁%d只,鸡母%d只,鸡雏%d只\n",i,j,k * 3);
                }
            }
        }
        System.out.println("总共" + cnt + "种买法");
    }
}
