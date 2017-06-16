package oop.ex6.variables;

public class InvalidNameException extends VariableException {
    public InvalidNameException() {
        super("illegal variable name");
    }
}
