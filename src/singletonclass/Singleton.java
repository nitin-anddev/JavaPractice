package singletonclass;

/**
 * Synchronized methods enable a simple strategy for preventing thread interference and
 * memory consistency errors: if an object is visible to more than one thread, all reads or writes
 * to that object's variable are done through synchronized methods.
 *
 */

public class Singleton {
    //Static variable reference of single_instance
    //of type Singleton
    private static Singleton single_instance = null;
    //Declaring a variable of type String
    public String s;
    //Constructor
    //Here we will be creating private constructor
    //restricted to this class itself
    private Singleton(){
        s = "Hello I am a string, part of Singleton class";
    }

    //Static method to create instance of singleton class
    /**
     * Notice that synchronized method or block has two effects on execution
     * 1. When one thread is executing a synchronized method for an object, all
     *      other threads that invoke synchronized methods for the same object block(suspend
     *      execution) until the first thread is done with the object.
     * 2. When a synchronized method exits, it automatically establishes a happens before
     *      relationship with any subsequent invocation of a synchronized method for the same object.
     *      This guarantees that changes to the state of the object are visible to all threads.
     *
     */

    public static synchronized Singleton getInstance(){
        if (single_instance == null)
            single_instance = new Singleton();
        return single_instance;
    }

}
