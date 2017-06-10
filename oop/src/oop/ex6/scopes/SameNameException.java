package oop.ex6.scopes;

public class SameNameException extends ScopeException {

    public SameNameException(String msg) {

        super( "There is same name to" + msg);
    }
}
