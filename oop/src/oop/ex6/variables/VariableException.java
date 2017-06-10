package oop.ex6.variables;

import oop.ex6.main.SjavacException;

/**
 * The most general exception in this package, that all other exceptions
 * inherit from.
 */
public class VariableException extends SjavacException {
    public VariableException(String msg) {
        super(msg);
    }
}
