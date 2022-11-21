package demo2;

import java.util.Arrays;

public class test02 {
    public static void main(String[] args) {
        int[] a = {10,7,9,2,4,5,1,3,6,8};
        Arrays.sort(a);
        for (int i :
                a) {
            System.out.println(i);
        }
    }
}
