package oop.ex6.variables;

import oop.ex6.variables.Utils.*;

public class Variable {
    private VariableType type;
    private boolean isIntioalize;
    private boolean isFinal;
    private String name;

    public  Variable(VariableType type, String name, boolean isFinal, boolean isIntioalize){
        this.type = type;
        this.name = name;
        this.isFinal = isFinal;
        this.isIntioalize = isIntioalize;
    }

    public String getName(){
        return this.name;
    }

}
//is valide name value