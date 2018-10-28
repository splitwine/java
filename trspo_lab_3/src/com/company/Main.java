package com.company;

import com.sun.source.tree.Tree;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

class GenericsType<T>{

    private T t;

    public T get(){
        return this.t;
    }

    public void set(T t){
        this.t=t;
    }
}

class Sum{

    public static double sum(List<? extends Number>list){
        double sum = 0;
        for(Number n: list){
            sum +=n.doubleValue();
        }
        return sum;
    }

    Sum(){;}
}

public class Main {

    public static void main(String[] args) {

        //List<String>
        List<String> listStr = new ArrayList<>();
        listStr.add("List<String>");
        for(String s: listStr){ //String because List<String>
            System.out.printf("%s", s);
        }

        //GenericType<String>
        GenericsType<String> type = new GenericsType<>();
        type.set("GenericType<Striing>");
        System.out.printf("\n%s", type.get());

        //usual GenericType
        GenericsType type1 = new GenericsType();
        type1.set("usual GenericType "+10);
        System.out.printf("\n%s", type1.get());

        //List<Integer>
        List<Integer> listInt = new ArrayList<>();
        listInt.add(1);
        listInt.add(2);
        listInt.add(3);
        Sum s = new Sum();
        double sum = s.sum(listInt);
        System.out.printf("\nList<Integer> %s",sum);

        //HashSet<String>
        HashSet<String> hashStr = new HashSet<>();
        hashStr.add("Moscow");
        hashStr.add("Kiev");
        hashStr.add("Odessa");
        System.out.printf("\nHashSet<String> %s", hashStr.size());

        //HashSet<String> on Array
        String[] myArray = hashStr.toArray(new String[hashStr.size()]);
        for (int i = 0; i<hashStr.size(); i++)
            System.out.printf("\n %s", myArray[i]);

        //TreeSet<Integer>
        TreeSet<Integer> treeStr = new TreeSet<>();
        Random rand = new Random();
        for(int i =0; i<10; i++)
            treeStr.add(rand.nextInt(10));
        System.out.printf("\n%s", treeStr);

        //PriorityQueue<Integer>
        PriorityQueue<String> priorInt = new PriorityQueue<>();
        priorInt.add("Max");
        priorInt.add("Ivan");
        priorInt.add("Vlad");
        Iterator itr = priorInt.iterator();
        while (itr.hasNext())
            System.out.printf("\nPriorityQueue<Integer> Iterator: %s", itr.next());
        priorInt.poll();
    }
}
