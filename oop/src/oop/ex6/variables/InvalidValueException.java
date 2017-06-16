package oop.ex6.variables;

public class InvalidValueException extends VariableException{
    public InvalidValueException() {
        super("illegal value");
    }
}
