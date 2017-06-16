package oop.ex6.variables;

import java.util.regex.Matcher;

import static oop.ex6.variables.Utils.*;

public class IntVariable extends Variable {

    public IntVariable(String name) throws VariableException {
        super(name);
        this.type = VariableType.INT;
    }

    /**
     * @param val
     * @throws VariableException
     */
    @Override
    public void setValue(String val) throws VariableException {
        Matcher m = intValuePattern.matcher(val);
        if (m.matches()) {
            super.setValue(val);
        }
        else {
            throw new InvalidValueException();
        }
    }
}
