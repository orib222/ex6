package oop.ex6.variables;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static oop.ex6.variables.Utils.*;

public class VariableFactory {

    public static Variable createVariable(String line){

        //todo
        Pattern finalAndInitialized = Pattern.compile("^final\\s(\\w+)\\s(\\w+)\\s=\\s(\\w+);");
        Pattern notInitialized = Pattern.compile("^(\\w+)\\s(\\w+);$");

        Matcher m = finalAndInitialized.matcher(line);

        if (m.find()){
            String type = m.group(1);
            String name = m.group(2);
            String value = m.group(3);

            VariableType type1 = checkType(type);

            if (type1 != null && checkName(name)){
                //todo: check value

                return new Variable(type1,name,true,true);
            }
        }

        m = notInitialized.matcher(line);

        // TODO: duplicate code...
        if (m.find()){
            String type = m.group(1);
            String name = m.group(2);

            VariableType type1 = checkType(type);

            if (type1 != null && checkName(name)){
                return new Variable(type1,name,false,false);
            }
        }

        return null;
    }
}
