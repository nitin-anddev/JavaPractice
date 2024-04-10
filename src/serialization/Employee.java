package serialization;

import java.io.Serializable;

public class Employee implements Serializable {
    private static final long serialVersionUID = 129348938L;
    transient int a;
    static int b;
    String name;
    int age;
    //Default constructor
    public Employee(String name, int age, int a, int b){
        this.name = name;
        this.a = a;
        this.b = b;
    }

}
