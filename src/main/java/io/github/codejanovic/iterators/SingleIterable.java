package io.github.codejanovic.iterators;

public class SingleIterable<T> extends AbstractIterable<T> {

    public SingleIterable(final T _single) {
        super(() -> new SingleIterator<>(_single));
    }
}
