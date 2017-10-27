package io.github.codejanovic.iterators;

import io.github.codejanovic.functions.make.MakeFunction;

import java.util.Iterator;

public class FlatIterable<T> extends AbstractIterable<T> {

    public FlatIterable(final MakeFunction<Iterator<T>> makeFunctionIterator) {
        super(makeFunctionIterator);
    }
}
