package oop.ex6.variables;

public enum VariableType {
    INT("int"),
    DOUBLE("double"),
    STRING("String"),
    BOOLEAN("boolean"),
    CHAR("char");

    String val;

    VariableType(String val){
        this.val = val;
    }

}
