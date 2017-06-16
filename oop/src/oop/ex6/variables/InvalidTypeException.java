package oop.ex6.variables;

public class InvalidTypeException extends VariableException{
    public InvalidTypeException() {
        super("invalid variable type");
    }
}
