package oop.ex6.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    /** keywords **/
    public static final String intKeyword = "int";
    public static final String doubleKeyword = "double";
    public static final String stringKeyword = "String";
    public static final String boolKeyword = "boolean";
    public static final String charKeyword = "char";

    public static final String voidKeyword = "void";
    public static final String finalKeyword = "final";
    public static final String ifKeyword = "if";
    public static final String whileKeyword = "while";
    public static final String trueKeyword = "true";
    public static final String falseKeyword = "false";
    public static final String returnKeyword = "return";

    private static Matcher matcher;

    /** patterns **/
    private static final Pattern openBracket = Pattern.compile("[^\\{\\}]\\{s*");
    private static final Pattern closeBracket = Pattern.compile("^\\s*\\}\\s*$");
    private static final Pattern emptyLine = Pattern.compile("\\s*");
    private static final Pattern commentLine = Pattern.compile("^//.*"); // TODO: maybe check white spaces in front


    static boolean isOpenBracket(String line){
        matcher = openBracket.matcher(line);
        return matcher.matches();
    }

    static boolean isCloseBracket(String line){
        matcher = closeBracket.matcher(line);
        return matcher.matches();
    }

    static boolean isEmptyLine(String line) {
        matcher = emptyLine.matcher(line);
        boolean isEmpty = matcher.matches();
        matcher = commentLine.matcher(line);
        boolean isComment = matcher.matches();

        return isEmpty || isComment;
    }
}
