package com.sbt.javaschool.homework;

import java.util.HashMap;
import java.util.Map;

class CountMapIml<E> implements CountMap<E> {
    Object[] a, b;
    int index = -1;
    Map<E, Integer> m = new HashMap<>();

    @Override
    public void add(E o) {
        index = index + 2;
        a = new Object[index];
        if (b != null) {
            for (int i = 0; i < b.length; i++)
                a[i] = b[i];
        }
        a[--index] = o;
        b = a;

    }

    @Override
    public int getCount(E o) {
        int count = 0;
        for (int i = 0; i < a.length; i++)
            if (o == a[i])
                count++;
        return count;
    }

    @Override
    public int remove(E o) {
        Object[] c = new Object[a.length - 1];
        for (int i = 0; i < a.length - 1; i++) {
            c[i] = a[i];
            if (c[i] == o) {
                for (int j = i; j < a.length - 1; j++) {
                    c[j] = a[j + 1];
                }
                break;
            }
        }
        a = c;
        return b.length;
    }

    @Override
    public int size() {
        Object[] c = new Object[a.length];
        int count = 0;
        for (int i = 0; i < c.length; i++)
            c[i] = a[i];
        for (int i = 0; i < c.length; i++) {
            if (c[i] != null) {
                count++;
                for (int j = i + 1; j < c.length; j++)
                    if (c[i] == c[j])
                        c[j] = null;
            }
        }
        return count;
    }

    @Override
    public void addAll(CountMap source) {
        int f;
        for (int i = 0; i < a.length; i++) {
            f = 0;
            for (int j = 0; j < source.length(); j++)
                if (source.get(j) == a[i]) {
                    m.put((E) a[i], getCount((E) a[i]) + source.getCount(source.get(j)));
                    f = 1;
                }
            if (f == 0) m.put((E) a[i], getCount((E) a[i]));
        }
        for (int i = 0; i < source.length(); i++){
            for (int j = 0; j < a.length; j++)
                if (source.get(i) == a[j]){
                source.remove(a[j]);
                break;
                }
            m.put((E) source.get(i), source.getCount(source.get(i)));
        }
    }


    @Override
    public java.util.Map toMap() {
        if(m.size()==0)
        for(int i=0;i<a.length;i++){
           m.put((E)a[i],getCount((E)a[i]));
        }
        return m;
    }

    @Override
    public void toMap(Map<E, Integer> destination) {
        for (int i = 0; i < a.length; i++)
            destination.put((E) a[i], getCount((E) a[i]));
    }

    public E get(int i) {
        return (E) a[i];
    }

    public int length() {
        return a.length;
    }
}