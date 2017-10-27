package io.github.codejanovic.iterators;

import java.util.Iterator;

public class SingleIterator<T> implements Iterator<T> {
    private final T _single;
    private boolean _hasBeenIterated;

    public SingleIterator(final T single) {
        _single = single;
        _hasBeenIterated = false;
    }

    @Override
    public boolean hasNext() {
        return _hasBeenIterated;
    }

    @Override
    public T next() {
        _hasBeenIterated = true;
        return _single;
    }
}
