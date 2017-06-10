package oop.ex6.main;

/**
 * The most general exception in this project, that all other exceptions
 * inherit from.
 */
public class SjavacException extends Exception {

    public SjavacException(String msg){
        super(msg);
    }
}
