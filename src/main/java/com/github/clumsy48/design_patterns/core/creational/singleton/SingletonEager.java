package com.github.clumsy48.design_patterns.core.creational.singleton;

import java.io.Serializable;

public class SingletonEager implements Serializable,Cloneable {

    private static SingletonEager instance;
    static {
        instance = new SingletonEager();
    }
    private SingletonEager(){

    }
    public static SingletonEager getInstance(){
        return instance;
    }
    protected Object readResolve() {
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException{
        throw new CloneNotSupportedException();
    }
}

