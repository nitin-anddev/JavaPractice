/**
 * Example parent class to show method overriding concept
 */
public class HumanBeing {
    private final String yourName = "Your Name"; //initialised final variable [value can't be changed]
    private final String myName; //non initialised final variable [this can only be initialised by class constructor]

    public HumanBeing(String myName) {
        this.myName = myName;
        this.name = myName;
    }
    String name;
    public static final String constantString = "This is a constant text";

    //Final means that the entity is only assigned once
    //static means that only one instance is created that we can share across all instances of the class

    public int walk(int distance, int time){
        //yourName = "Nitin Kumar"; //Cannot re-assign a value to final variable [Compilation error]
        int speed = distance / time;
        return speed;
    }
}
