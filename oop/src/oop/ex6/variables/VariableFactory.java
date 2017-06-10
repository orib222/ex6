package oop.ex6.variables;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VariableFactory {

    public static Variable createVariable(String line){

        //todo
        Pattern p = Pattern.compile("([\\w]+)\\s([\\w]+)");
        Matcher m = p.matcher(line);

        while (m.matches()){
            m.group();
        }

        return null;
    }
}
