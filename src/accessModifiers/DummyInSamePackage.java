package accessModifiers;

public class DummyInSamePackage {
    /**
     * Let's try to access variables defined in "Basics.java" class here
     */
    private String defaultString = new Basics().defaultString; //accessible because we are in same package
    private String protectedString = new Basics().protectedString; //accessible because we are in same package
    private String publicString = new Basics().publicString; //public variables are accessible from anywhere

    //private String privateString = new Basics().privateString; //Notice: private variables are not accessible outside their declared class
}
