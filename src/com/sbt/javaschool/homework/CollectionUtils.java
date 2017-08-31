package com.sbt.javaschool.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionUtils<T> {
    public <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public <T> List newArrayList() {
        List<T> source=new ArrayList<>();
        return source;
    }

    public <T> int indexOf(List<? extends T> source, T o) {
        for(int i=0;i<source.size();i++)
            if(source.get(i)==o)
                return i;
        return -1;
    }

    public <T> List limit(List<? extends T> source, int size) {
        List<T> s=new ArrayList<>();
        for(int i=0;i<size;i++)
            s.add(source.get(i));
        return s;
    }

    public <T> void add(List<? super T> source, T o) {
        source.add(o);
    }

    public <T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        for(T element:c2)
            removeFrom.remove(element);
    }

    public <T> boolean containsAll(List<? extends T> c1, List<? extends T> c2) {
        int count=0;
        for(T element2:c2){
            for(T element1:c1)
                if(element1==element2) {
                count++;
                break;
                }
        }
        if(count==c2.size())
            return true;
        else return false;
    }

    public <T> boolean containsAny(List<? extends T> c1, List<? extends T> c2) {
        for(T element2:c2){
            for(T element1:c1)
                if(element1==element2) {
                    return true;
                }
        }
        return false;
    }

  /*  public <T> List range(List list, T min, T max) {

    }*/

   /* public static List range(List list, Object min, Object max, Comparator comparator) {

    }*/


}

