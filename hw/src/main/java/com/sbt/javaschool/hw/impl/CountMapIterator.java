package com.sbt.javaschool.hw.impl;

import java.util.Iterator;

public class CountMapIterator<E> implements Iterator<E> {
    private final E[]data;
    private int index=0;

    CountMapIterator(E[] data) {
        this.data = data;
    }

    public boolean hasNext() {
        return index<data.length;
    }

    public E next() {
        return data[index++];
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();

    }
}
