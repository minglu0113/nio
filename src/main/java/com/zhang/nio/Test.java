package com.zhang.nio;

import java.util.HashMap;
import java.util.Objects;

public class Test {
    private int age;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    Test(String name,int age){
        this.name = name;
        this.age = age;
    }
    public static void main(String[] args)
    {
        Test test = new Test("12",1);
        System.out.println(test.hashCode());
        HashMap hashMap = new HashMap();
        hashMap.put(test,1);
        System.out.println(hashMap.get(new Test("12",1)));
        System.out.println(new Test("12",1).hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        return this.name.equals(((Test)obj).name)&&this.age==((Test)obj).age;
    }
}
