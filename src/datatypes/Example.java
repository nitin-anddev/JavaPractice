package datatypes;


public class Example {
    /**
     * byte: The byte data type is an 8-bit signed two's complement integer.
     * It has a minimum value of -128 and a maximum value of 127(inclusive).
     * The byte data type can be useful for saving memory in large arrays, where the memory
     * savings actually matters. They can also be used in place of int where their limits help
     * to clarify your code; the fact that a variable's range is limited can serve as a form of documentation.
     */
    private byte myByte = 127;
    /**
     * short: The short data type is a 16-bit signed two's complement integer. It has a minimum value of -32768
     * and a maximum value of 32768(inclusive). As with byte, the same guidelines apply:
     * you can use a short to save memory in large arrays, in situations where the memory savings actually matters.
     */
    private short myShort = 32767;
    /**
     * By default, the int data type is a 32-bit signed two's complement integer, which has
     * a minimum value of -2^31 and a maximum value of 2^31 - 1. In Java SE 8 and later,
     * you can use the int data type to represent an unsigned 32-bit integer, which has a minimum value of 0
     * and a maximum value of 2^32 - 1. Use the Integer class to use int data type as an unsigned integer.
     * See the section, The Number Classes for more information. Static methods like compareUnsigned, divideUnsigned etc have
     * been added to the Integer class to support the arithmetic operations for unsigned integers.
     */
    private int myInt = 1000000000;
    /**
     *
     */
    private long myLong = 10L;

    /**
     *
     */
    private String string = "";
}
