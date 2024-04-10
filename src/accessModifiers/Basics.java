package accessModifiers;

public class Basics {
    //There are 4 types of access modifiers in Java
    /**
     * @private : Private variables or methods are only accessible within the class
     * @default : Default variables or methods are accessible within class and same package
     * @protected : Protected variables or methods are accessible within class, within package & outside package through inheritance
     * @public : Public variables or methods are accessible from anywhere in the project
     */

    private String privateString = "This variable is only accessible in current class";
    String defaultString = "This variable is accessible within current class and current package";
    protected String protectedString = "This variable is accessible within current class, current package and outside package through subclass";
    public String publicString = "This variable is accessible from anywhere in the current project";

    protected String msg(){
        return "This message is protected";
    }
    protected String getPrivateString(){
        return privateString;
    }

}
