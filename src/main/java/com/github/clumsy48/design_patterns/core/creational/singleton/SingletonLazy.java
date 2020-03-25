package com.github.clumsy48.design_patterns.core.creational.singleton;

import java.io.Serializable;

public class SingletonLazy implements Serializable,Cloneable {

    private static volatile SingletonLazy instance;

    private SingletonLazy(){

    }
    public static SingletonLazy getInstance(){
        if(null == instance){
            synchronized (SingletonLazy.class){
                if(null == instance){
                    instance = new SingletonLazy();
                }
            }
        }
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
