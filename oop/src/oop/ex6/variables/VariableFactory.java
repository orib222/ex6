package oop.ex6.variables;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import oop.ex6.scopes.SameNameException;
import oop.ex6.scopes.Scope;

import static oop.ex6.variables.Utils.*;

public class VariableFactory {

    public static void parseVariable(String line, Scope scope) throws VariableException, SameNameException {

        // check if starting with final final
        Pattern finalDecoratorPattern = Pattern.compile("\\s*final\\s*");
        Matcher m = finalDecoratorPattern.matcher(line);

        boolean isFinal;
        String declarationStr;
        if (m.lookingAt()) {
            isFinal = true;
            declarationStr = line.substring(m.end());
        } else {
            isFinal = false;
            declarationStr = line;
        }

        // check the type of the variables
        Pattern varTypesPattern = Pattern.compile(varTypes);
        m = varTypesPattern.matcher(declarationStr);

        if (m.lookingAt()) {
            String type = declarationStr.substring(m.start(),m.end());
            String temp = declarationStr.substring(m.end());
            String[] varDeclarations = temp.split(",");

            Pattern varInitPattern = Pattern.compile("(\\s*\\w\\s)+=?(\\s?\\w)*;?");

            for (String varDeclaration:varDeclarations) {
                m = varInitPattern.matcher(varDeclaration);

                if (m.matches()){
                    Variable var = createVariable(type,m.group(1));
                    var.setFinal(isFinal);

                    if (m.groupCount() == 2){ // TODO: check other cases?
                        var.setValue(m.group(2));
                    }

                    scope.setLocalVariable(var);
                }
                else {
                    throw new InvalidNameException(); //TODO: is this the right exception
                }
            }
        }
        else {
            throw new InvalidTypeException();
        }
    }

    private static Variable createVariable(String type, String name) throws VariableException{
        VariableType vt = checkType(type);

        switch (vt){
            case INT:
                return new IntVariable(name);
            case DOUBLE:
                return new DoubleVariable(name);
            case STRING:
                return new StringVariable(name);
            case BOOLEAN:
                return new BooleanVariable(name);
            case CHAR:
                return new CharVariable(name);
        }
        return null; //TODO: never gets here...
    }
}
