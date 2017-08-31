package com.sbt.javaschool.homework;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        CountMap<Integer> map = new CountMapIml<>();
        CountMap<Integer> source = new CountMapIml<>();
        Map<Integer,Integer> m = new HashMap<>();
        source.add(10);
        source.add(3);
        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);
       // System.out.println(map.size());
       /* System.out.println(map.getCount(5));
        System.out.println(map.getCount(6));
        System.out.println(map.getCount(10));*/
       // map.remove(5);
        map.addAll(source);
       System.out.println(map.toMap().get(5));
     //   System.out.println(map.toMap().get(10));
        //System.out.println(map.size());






       CountMap<String> map2 = new CountMapIml<>();
        map2.add("a");
        map2.add("ab");
        map2.add("ab");
        map2.add("c");
      /*  System.out.println( map2.get(0));
        System.out.println( map2.get(1));
        System.out.println( map2.get(1));
        System.out.println(map2.getCount("ab"));*/
        System.out.println(map2.toMap().get("c"));
        CollectionUtils<Integer> x=new CollectionUtils<>();
        List<Integer> list;
        list=x.newArrayList();
        list.add(3);
        list.add(2);
       list=x.range(list,1,2);
        System.out.println( list.get(0));



    }
    public static void print(CountMap<?> c){
        for(int i=0;i<c.length();i++){
            System.out.println(c.get(i));
        }
    }
}
