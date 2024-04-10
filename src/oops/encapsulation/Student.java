package oops.encapsulation;

/**
 * A java class which is a fully encapsulated class.
 * It has a private data member and getter and setter methods.
 */
public class Student {
    //private data member which is not accessible outside this class
    private String name;

    //data member is accessible through getter method only
    public String getName(){
        return name;
    }

    //we can set data member value using setter method
    public void setName(String name){
        this.name = name;
    }

}
