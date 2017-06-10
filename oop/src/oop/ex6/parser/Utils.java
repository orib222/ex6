package oop.ex6.parser;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    private static Matcher matcher;

    private static final Pattern openBracket = Pattern.compile("");
    private static final Pattern closeBracket = Pattern.compile("");


    public static boolean isOpenBracket(String line){
        matcher = openBracket.matcher(line);
        return matcher.matches();
    }

    public static boolean isCloseBracket(String line){
        matcher = closeBracket.matcher(line);
        return matcher.matches();
    }


}
