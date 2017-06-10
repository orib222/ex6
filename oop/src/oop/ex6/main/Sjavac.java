package oop.ex6.main;


import oop.ex6.parser.Parser;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sjavac {

    private static final String LEGAL_CODE = "0";
    private static final String ILLEGAL_CODE = "1";
    private static final String IO_ERROR = "2";
    private static final int CODE_FILE_INDEX = 0;
    private static final String NOT_FILE_MESSAGE = "The path that given is not a file";
    private static final String NOT_JAVAC_MESSAGE = "The file that given is not a javac file";
    private static final String JAVAC_FILE_SUFFIX = ".sjava";


    public static void main(String[] args) {
        try {
            //Creates the file from the args
            File codeFile = new File(args[CODE_FILE_INDEX]);
            if (!codeFile.isFile()) {
                throw new IOException(NOT_FILE_MESSAGE);
            }
            if (!isJavacFile(codeFile)) {
                throw new IOException(NOT_JAVAC_MESSAGE);
            }
            Parser.parse(codeFile);
        } catch (SjavacException e) {
            System.out.println(ILLEGAL_CODE);
            System.err.println(e.getMessage());
            return;
        } catch (IOException e) {
            System.out.println(IO_ERROR);
            System.err.println(e.getMessage());
            return;
        }
        System.out.println(LEGAL_CODE);
    }

    private static boolean isJavacFile(File codeFile) {
        String codeFileName = codeFile.getName();
        Pattern p = Pattern.compile(".+(" + JAVAC_FILE_SUFFIX + ")$");
        Matcher m = p.matcher(codeFileName);
        return m.matches();
    }
}
