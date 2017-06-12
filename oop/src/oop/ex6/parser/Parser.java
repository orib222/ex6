package oop.ex6.parser;

import oop.ex6.main.SjavacException;
import oop.ex6.scopes.Scope;
import oop.ex6.scopes.ScopeFactory;
import oop.ex6.scopes.methods.Method;
import oop.ex6.scopes.methods.MethodException;
import oop.ex6.scopes.GlobalScope;
import oop.ex6.variables.Variable;
import oop.ex6.variables.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static oop.ex6.parser.Utils.*;

public class Parser {

    private static ArrayList<String> lines;

    //todo: maby singltone

    public static void parse(File codeFile) throws IOException, SjavacException {
        Scanner scanner = new Scanner(codeFile);
        lines = readAllLines(scanner);

        parseGlobalScope();
        parseScopes();
    }

    private static ArrayList<String> readAllLines(Scanner scanner) {
        lines = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (!isEmptyLine(line)) {
                lines.add(line);
            }
        }
        return lines;
    }

    private static void parseGlobalScope() throws SjavacException {
        GlobalScope globalScope = GlobalScope.getInstance();

        int bracketsBalance = 0;

        for (String line: lines){

            if (bracketsBalance == 0) {
                // check if line is a variable
                Variable variable = VariableFactory.createVariable(line);
                if (variable != null) {
                    globalScope.setLocalVariable(variable);
                }

                //todo: runs twice. maybe change..

                // check if line is a method
                Method method = ScopeFactory.createMethod(line);
                if (method != null) {
                    globalScope.setMethod(method);
                }
                if (variable == null && method == null){ // if not a variable and not a method
                    throw new ParsingException("line is not a variable and not a method in global scope");
                }

            }

            if (isOpenBracket(line)){
                bracketsBalance++;
            }

            if (isCloseBracket(line)){
                bracketsBalance--;
            }
        }
    }

    private static void parseScopes(){
        throw new NotImplementedException();

    }
}
