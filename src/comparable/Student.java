package comparable;

public class Student implements Comparable<Student>{
    private int rollNo;
    private String name;
    private int age;

    public Student(){}

    public Student(int rollNo, String name, int age){
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Student student) {
        return 0;
    }
}
