package oop.ex6.scopes.methods;

import oop.ex6.scopes.ScopeException;

/**
 * The most general exception in this package, that all other exceptions
 * inherit from.
 */
public class MethodException extends ScopeException {
    public MethodException(String msg) {
        super(msg);
    }
}
