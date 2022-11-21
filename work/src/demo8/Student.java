package demo8;

public class Student extends Person {
    private long sNo;
    private String sClass;
    public Student(long sNo, String name, char sex, String id) {
        super(name, sex, id);
        this.sNo = sNo;
    }

    public void setsClass(String sClass) {
        this.sClass = sClass;
    }

    @Override
    public String toString() {
        return "Student{" +
                super.toString() +
                "sNo=" + sNo +
                ", sClass='" + sClass + '\'' +
                '}';
    }
}
