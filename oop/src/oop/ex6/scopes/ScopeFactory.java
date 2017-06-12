package oop.ex6.scopes;

import oop.ex6.scopes.conditions.Condition;
import oop.ex6.scopes.methods.Method;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScopeFactory {

    //TODO
    public static Method createMethod(String line){

        Pattern p = Pattern.compile("void\\s(\\w+)\\((.+)\\)\\s\\{");

        Matcher m = p.matcher(line);

        if (m.find()){
            String name = m.group(1);
            String methodArgs = m.group(2);
            System.out.println(methodArgs);
        }

        return null;
    }

    public static Condition createCondition(String line){
        return null;
    }
}
