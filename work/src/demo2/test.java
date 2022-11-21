package demo2;

import java.sql.SQLOutput;

public class test {
    public static void main(String[] args) {
        int[] myArray = { 1, 2, 3, 4, 5, 6 };
        int[] yourArray = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        System.arraycopy(myArray,0,yourArray,0,myArray.length);
        for (int i:
             yourArray) {
            System.out.println(i);
        }
    }
}
