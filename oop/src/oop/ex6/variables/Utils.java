package oop.ex6.variables;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static oop.ex6.parser.Utils.*;

public class Utils {

    public static final String varTypes = intKeyword + "|" +doubleKeyword + "|" +stringKeyword + "|" +boolKeyword +
            "|" +charKeyword;
    private static final String intValue = "-?\\d+";
    public static final Pattern intValuePattern = Pattern.compile(intValue);
    private static final String doubleValue = "-?\\d+(\\.\\d+)?";
    private static final String stringValue = "\".*\"";
    private static final String boolValue = trueKeyword + "|" + falseKeyword + "|" + intValue + "|" + doubleValue;
    private static final String charValue = "\'.\'";

    private static String variableName = "\\s*(_\\w+|[a-zA-Z]\\w*)\\s*";

    /** patterns **/
    public static Pattern finalAndInitialized = Pattern.compile("^final\\s(\\w+)\\s(\\w+)\\s=\\s(\\w+);");
    public static Pattern notInitialized = Pattern.compile("^(\\w+)\\s(\\w+);$");
    public static Pattern namePattern = Pattern.compile(variableName);


    public enum VariableType {
        INT(intKeyword),
        DOUBLE(doubleKeyword),
        STRING(stringKeyword),
        BOOLEAN(boolKeyword),
        CHAR(charKeyword);

        String val;

        VariableType(String val){
            this.val = val;
        }

        public String ToString(){
            return this.val;
        }
    }

    private static final Map<VariableType,ArrayList<VariableType>> compatibilityAssignmentMap = new HashMap<VariableType,ArrayList<VariableType>>(){
        {put(VariableType.INT, new ArrayList<VariableType>(){{add(VariableType.INT);}});}
        {put(VariableType.DOUBLE, new ArrayList<VariableType>(){{add(VariableType.DOUBLE);add(VariableType.INT);}});}
        {put(VariableType.STRING, new ArrayList<VariableType>(){{add(VariableType.STRING);}});}
        {put(VariableType.BOOLEAN, new ArrayList<VariableType>(){{add(VariableType.BOOLEAN);add(VariableType.DOUBLE);add(VariableType.INT);}});}
        {put(VariableType.CHAR, new ArrayList<VariableType>(){{add(VariableType.CHAR);}});}
    };

    public static boolean isCompatibleAssignment(VariableType src, VariableType dst){
        return compatibilityAssignmentMap.get(src).contains(dst);
    }

    public static VariableType checkType(String type){
        for (VariableType vt: VariableType.values()){
            if (Objects.equals(type, vt.ToString())){
                return vt;
            }
        }
        return null;
    }
}
