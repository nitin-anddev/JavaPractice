package oops.abstraction.inteface;

import oops.abstraction.inteface.Bank;

public class SBI implements Bank {
    @Override
    public float rateOfInterest() {
        return 9.15f;
    }
}
