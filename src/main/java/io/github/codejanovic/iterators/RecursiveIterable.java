package io.github.codejanovic.iterators;


import io.github.codejanovic.functions.make.MakeFunction1;

import java.util.Iterator;

public class RecursiveIterable<T> extends AbstractIterable<T> {

    public RecursiveIterable(final T element, final MakeFunction1<Iterator<T>, T> makeIterator) {
        super(() -> new RecursiveIterator<>(element, makeIterator));
    }

    public RecursiveIterable(final Iterable<T> iterable, final MakeFunction1<Iterator<T>, T> makeIterator) {
        super(() -> new RecursiveIterator<>(iterable, makeIterator));
    }
}
