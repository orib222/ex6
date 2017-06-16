package oop.ex6.scopes;

import oop.ex6.variables.Variable;

import java.util.ArrayList;
import java.util.List;

public class Scope {

    protected Scope parent;
    protected ArrayList<Variable> localVariables;
    protected int startLineNumnber;
    protected int endLineNumnber;

    public Scope(){
        localVariables = new ArrayList<>();
    }

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




