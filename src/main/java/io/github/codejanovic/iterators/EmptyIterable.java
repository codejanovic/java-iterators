package io.github.codejanovic.iterators;

import java.util.Iterator;

public class EmptyIterable<T> implements Iterable<T> {
    @Override
    public Iterator<T> iterator() {
        return new EmptyIterator<>();
    }
}
