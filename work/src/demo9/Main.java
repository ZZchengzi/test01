package demo9;

public class Main {
    public static void main(String[] args) {
        long a = 1;
        int cnt = 1;
        for(int i = 1; i < 20; i ++)
        {
            a += cnt / 2;
            cnt++;
            a += cnt;
            cnt++;
            a += cnt / 2 + 1;
        }
        System.out.println(a);
    }
}
