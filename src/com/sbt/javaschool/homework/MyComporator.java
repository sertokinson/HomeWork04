package com.sbt.javaschool.homework;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class MyComparator<T> implements Comparator<T> {

    public int compare(T a, T b){
        return a.toString().compareTo(b.toString());
    }
}
