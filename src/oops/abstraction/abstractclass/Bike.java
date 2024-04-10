package oops.abstraction.abstractclass;

/**
 * Bike is an abstract class that contains only one abstract method
 * run. Its implementation is provided by the
 * @Honda class
 */
public abstract class Bike {
    //abstract classes can have constructors
    Bike(){
        System.out.println("bike is created");
    }
    abstract void run();
    void changeGear(){
        System.out.println("Gear changed");
    }
}
