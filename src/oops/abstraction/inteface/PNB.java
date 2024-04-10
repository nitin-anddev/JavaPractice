package oops.abstraction.inteface;

import oops.abstraction.inteface.Bank;

public class PNB implements Bank {
    @Override
    public float rateOfInterest() {
        return 9.7f;
    }
}
