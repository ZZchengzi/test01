package demo8;

public class TestStudent {
    public static void main(String[] args) {
        Student student = new Student(202018123,"zyc",'男',"chengzi");
        student.setsClass("2020181");
        student.setEmail("123456@qq.com");
        student.setPhone("16696176111");
        System.out.println(student);
    }

}
