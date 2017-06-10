package oop.ex6.variables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Utils {

    /** patterns **/
    //TODO


    public enum VariableType {
        INT("int"),
        DOUBLE("double"),
        STRING("String"),
        BOOLEAN("boolean"),
        CHAR("char");

        String val;

        VariableType(String val){
            this.val = val;
        }

        public String ToString(){
            return this.val;
        }
    }

    private static final Map<VariableType,ArrayList<VariableType>> compatabilityAssignmentMap = new HashMap<VariableType,ArrayList<VariableType>>(){
        {put(VariableType.INT, new ArrayList<VariableType>(){{add(VariableType.INT);}});}
        {put(VariableType.DOUBLE, new ArrayList<VariableType>(){{add(VariableType.DOUBLE);add(VariableType.INT);}});}
        {put(VariableType.STRING, new ArrayList<VariableType>(){{add(VariableType.STRING);}});}
        {put(VariableType.BOOLEAN, new ArrayList<VariableType>(){{add(VariableType.BOOLEAN);add(VariableType.DOUBLE);add(VariableType.INT);}});}
        {put(VariableType.CHAR, new ArrayList<VariableType>(){{add(VariableType.CHAR);}});}
    };

    public static boolean isCompatibleAssignment(VariableType src, VariableType dst){
        return compatabilityAssignmentMap.get(src).contains(dst);
    }



}
