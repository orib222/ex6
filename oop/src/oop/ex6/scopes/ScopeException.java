package oop.ex6.scopes;

import oop.ex6.main.SjavacException;

/**
 * The most general exception in this package, that all other exceptions
 * inherit from.
 */
public class ScopeException extends SjavacException {
    public ScopeException(String msg) {
        super(msg);
    }
}
