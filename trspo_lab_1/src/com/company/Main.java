package com.company;
import java.lang.String;

abstract class SomeAbstractClass
{
    public String name;
}

interface SomeInterface
{
    void print();
}

class SomeClass extends SomeAbstractClass implements SomeInterface
{
    public String name()
    {
        return name;
    }

    public void print()
    {
        System.out.println("Your name: "+name);
    }
}

public class Main {

    public static void main(String[] args) {
        // write your code here
        SomeClass sc = new SomeClass();
        sc.name = "Ivan";
        sc.print();
    }
}
