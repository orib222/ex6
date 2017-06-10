package oop.ex6.scopes;

import oop.ex6.variables.Variable;

import java.util.List;

public class Scope {

    protected Scope parent;
    protected List<Variable> localVariables;
    protected int startLineNumnber;
    protected int endLineNumnber;

    //two varibales with the same name


    public void setLocalVariable(Variable newVar) throws SameNameException {
        String newVarName = newVar.getName();
        for (Variable method: localVariables) {
            if (newVarName.equals(method.getName())) {
                throw new SameNameException("variable");
                //todo: check also at the parent
            }
        }
        localVariables.add(newVar);
    }
}




