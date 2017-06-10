package oop.ex6.scopes.methods;

import oop.ex6.scopes.Scope;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Method extends Scope {

    private String name;


    public Method(String name, int startLineNumnber){
        this.name = name;
        this.startLineNumnber = startLineNumnber;
    }

    public String getName() {
        return this.name;
    }



}