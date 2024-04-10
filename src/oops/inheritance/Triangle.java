package oops.inheritance;

/**
 * Extending a class is an example of inheritance
 */
public class Triangle extends Shape {
    private int currentHeight = 200;
    private int doubleHeight = doubleHeight(currentHeight); //doubleHeight is inherited
    private String color = getColor(); //getting color through inheritance

    private void kuch(){
        Shape shape = new Shape(); //Shape is a Encapsulated class
        shape.setColor(""); //setting color through encapsulation setter
        super.setColor(""); // setting color through inheritance
    }
}
