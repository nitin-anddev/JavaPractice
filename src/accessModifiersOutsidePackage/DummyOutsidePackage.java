package accessModifiersOutsidePackage;

import accessModifiers.Basics;

public class DummyOutsidePackage extends Basics {
    @Override
    protected String msg() {
        return super.msg();
    }
    private String protectedStringUsingSuper = super.protectedString;

    private String publicString = new Basics().publicString; // only public strings are accessible directly outside package

    /**
     * Inner static class, Note: A class can't be static until & unless it's inner class
     * Inner static classes act & behave same as other static members
     */
    static class myClass{

    }

}
