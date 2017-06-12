package oop.ex6.scopes;

import oop.ex6.scopes.methods.Method;

import java.util.ArrayList;
import java.util.List;


public class GlobalScope extends Scope {

    private static GlobalScope instance = null;
    private ArrayList<Method> methodList;


    private GlobalScope() {
        super();
        this.startLineNumnber = 1;
        parent = null;
        methodList = new ArrayList<>();
    }

    public static GlobalScope getInstance() {
        if (instance == null) {
            instance = new GlobalScope();
        }
        return instance;
    }


    public void setMethod(Method newMethod) throws SameNameException {
        String newMethodName = newMethod.getName();
        for (Method method : methodList) {
            if (newMethodName.equals(method.getName())) {
                throw new SameNameException("method");
            }
        }
        methodList.add(newMethod);
    }

    public List<Method> getMethodList() {
        return this.methodList;
    }


}