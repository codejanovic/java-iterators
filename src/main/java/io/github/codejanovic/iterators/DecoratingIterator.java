package io.github.codejanovic.iterators;


import io.github.codejanovic.functions.map.MapFunction;

import java.util.Iterator;

public class DecoratingIterator<T> implements Iterator<T> {
    private final Iterator<T> decorated;
    private final MapFunction<T, T> _mapFunction;

    public DecoratingIterator(final Iterator<T> decorated, final MapFunction<T, T> _mapFunction) {
        this.decorated = decorated;
        this._mapFunction = _mapFunction;
    }

    @Override
    public boolean hasNext() {
        return decorated.hasNext();
    }

    @Override
    public T next() {
        return _mapFunction.map(decorated.next());
    }
}
