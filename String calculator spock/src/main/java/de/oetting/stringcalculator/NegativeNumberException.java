package de.oetting.stringcalculator;

class NegativeNumberException extends RuntimeException {

    NegativeNumberException(String number) {
        super(number);
    }

}
