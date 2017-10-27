package io.github.codejanovic.iterators;

import io.github.codejanovic.functions.make.MakeFunction;

import java.util.Iterator;

public class FlatIterator<T> implements Iterator<T> {
    private final Iterator<T> iterator;

    public FlatIterator(final MakeFunction<Iterator<T>> iteratorProvider) {
        this.iterator = iteratorProvider.newInstance();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public T next() {
        return iterator.next();
    }
}
