package oop.ex6.variables;

import oop.ex6.variables.Utils.*;

import java.util.regex.Matcher;

import static oop.ex6.variables.Utils.*;

public class Variable {
    protected VariableType type;
    private boolean isInitialized;
    private boolean isFinal;
    private String name;

    public Variable(String name) throws VariableException {
        Matcher m = namePattern.matcher(name);
        if (m.matches()){
            this.name = name;
            this.isInitialized = false;
        }
        else {
            throw new InvalidNameException();
        }
    }

    public String getName(){
        return this.name;
    }

    public VariableType getType(){
        return this.type;
    }

    public void setValue(String val) throws VariableException{
        this.isInitialized = true;
    }

    public void setFinal(boolean isFinal){
        this.isFinal = isFinal;
    }



}