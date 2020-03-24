package com.github.clumsy48.design_patterns.core.creational.singleton.singletonbroken;

import java.io.Serializable;

public class Singleton implements Cloneable, Serializable {

    private static Singleton instance;
    static {
        instance = new Singleton();
    }
    private Singleton(){

    }
    public static Singleton getInstance(){
        return instance;
    }

}