package com.github.clumsy48.design_patterns.core.creational.singleton

import spock.lang.Specification

class SingletonLazySpec extends Specification{

    def "two instance should be equal"(){
        given:
        def obj1 = SingletonLazy.getInstance();
        def obj2 = SingletonLazy.getInstance();
        expect:
        obj1 == obj2
    }

    def "cloning should throw CloneNotSupportedException"(){
        given:
        def obj = SingletonLazy.getInstance();
        when:
        obj.clone()
        then:
        thrown(CloneNotSupportedException)
    }
    def "instance should be same even in serialization/deserialization"(){
        given:
        def obj1 = SingletonLazy.getInstance();
        def objOutputStream = new ObjectOutputStream(new FileOutputStream(getClass().getClassLoader().getResource("singleton_eager.se").getFile()));
        def objInputStream = new ObjectInputStream(new FileInputStream(getClass().getClassLoader().getResource("singleton_eager.se").getFile()));

        when:
        objOutputStream.writeObject(obj1)
        def obj2 = (SingletonLazy)objInputStream.readObject()

        then:
        obj1 ==  obj2
    }
}
