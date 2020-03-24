package com.github.clumsy48.design_patterns.core.creational.singleton.singletonbroken

import com.github.clumsy48.design_patterns.core.creational.singleton.SingletonEager
import spock.lang.Specification

class SingletonSpec extends Specification{

    def "two instance should be equal"(){
        given:
        def obj1 = Singleton.getInstance();
        def obj2 = Singleton.getInstance();
        expect:
        obj1 == obj2
    }

    def "cloning should break singleton pattern"(){
        given:
        def obj1 = Singleton.getInstance();
        when:
        def obj2 = obj1.clone()
        then:
        obj1 != obj2
    }
    def "serialization/deserialization should break singleton pattern"(){
        given:
        def obj1 = Singleton.getInstance();
        def objOutputStream = new ObjectOutputStream(new FileOutputStream(getClass().getClassLoader().getResource("singleton_eager.se").getFile()));
        def objInputStream = new ObjectInputStream(new FileInputStream(getClass().getClassLoader().getResource("singleton_eager.se").getFile()));

        when:
        objOutputStream.writeObject(obj1)
        def obj2 = (Singleton)objInputStream.readObject()

        then:
        obj1 != obj2
    }
}
