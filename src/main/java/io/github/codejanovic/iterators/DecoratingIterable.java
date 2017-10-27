package io.github.codejanovic.iterators;


import io.github.codejanovic.functions.map.MapFunction;

public class DecoratingIterable<T> extends AbstractIterable<T> {

    public DecoratingIterable(final Iterable<T> decorated, final MapFunction<T, T> mapFunction) {
        super(() -> new DecoratingIterator<>(decorated.iterator(), mapFunction));
    }
}