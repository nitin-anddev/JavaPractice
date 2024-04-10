package oops.abstraction.inteface.multipleinheritance;

public class A7 implements Printable, Showable{
    @Override
    public void print() {
        System.out.println("Hello");
    }

    @Override
    public void show() {
        System.out.println("Welcome");
    }
}
