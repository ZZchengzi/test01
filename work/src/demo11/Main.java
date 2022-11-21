package demo11;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入学生号");
        String sNo = scanner.next();
        System.out.println("输入姓名");
        String name = scanner.next();
        System.out.println("输入三门课成绩");
        double score1 = scanner.nextDouble();
        double score2 = scanner.nextDouble();
        double score3 = scanner.nextDouble();
        Student student = new Student(name, sNo, score1, score2, score3);
        double avg = student.getAverage();

        File file;
        FileWriter fw = null;
        file = new File("D://stud.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            fw = new FileWriter("D://stud.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fw.write(student + ",平均成绩=" + avg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
