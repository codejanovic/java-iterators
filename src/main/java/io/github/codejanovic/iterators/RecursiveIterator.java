package io.github.codejanovic.iterators;


import io.github.codejanovic.functions.make.MakeFunction1;

import java.util.Iterator;
import java.util.Stack;

public class RecursiveIterator<T> implements Iterator<T> {
    private final Stack<Iterator<T>> _iterators = new Stack<>();
    private final MakeFunction1<Iterator<T>, T> _iteratorSupplier;

    public RecursiveIterator(final T start, final MakeFunction1<Iterator<T>, T> iteratorSupplier) {
        _iteratorSupplier = iteratorSupplier;
        _iterators.add(_iteratorSupplier.newInstance(start));
    }

    public RecursiveIterator(final Iterable<T> start, final MakeFunction1<Iterator<T>, T> iteratorSupplier) {
        _iteratorSupplier = iteratorSupplier;
        _iterators.add(start.iterator());
    }

    @Override
    public boolean hasNext() {
        while (!_iterators.empty() && !_iterators.peek().hasNext())
            _iterators.pop();

        return !_iterators.empty() && _iterators.peek().hasNext();
    }

    @Override
    public T next() {
        final T next = _iterators.peek().next();
        _iterators.add(new FlatIterator<>(() -> _iteratorSupplier.newInstance(next)));
        return next;
    }
}
