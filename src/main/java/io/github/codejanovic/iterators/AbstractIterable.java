package io.github.codejanovic.iterators;


import io.github.codejanovic.functions.make.MakeFunction;

import java.util.Iterator;

public abstract class AbstractIterable<T> implements Iterable<T> {

    private final MakeFunction<Iterator<T>> _makeFunctionIterator;

    protected AbstractIterable(final MakeFunction<Iterator<T>> makeFunctionIterator) {
        _makeFunctionIterator = makeFunctionIterator;
    }

    @Override
    public Iterator<T> iterator() {
        return _makeFunctionIterator.newInstance();
    }
}