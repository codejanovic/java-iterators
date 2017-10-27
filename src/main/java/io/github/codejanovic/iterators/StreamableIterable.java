package io.github.codejanovic.iterators;


import java.util.Iterator;
import java.util.Optional;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public interface StreamableIterable<T> extends Iterable<T> {
    default Stream<T> stream() {
        final int characteristics = Spliterator.DISTINCT | Spliterator.SORTED | Spliterator.ORDERED;
        final Spliterator<T> splitIterator = Spliterators.spliteratorUnknownSize(iterator(), characteristics);
        return StreamSupport.stream(splitIterator, false);
    }

    default Stream<T> parallelStream() {
        return stream().parallel();
    }

    default Optional<T> findFirst(final Predicate<T> criteria) {
        return stream().filter(criteria).findFirst();
    }

    default Stream<T> findAll(final Predicate<T> criteria) {
        return stream().filter(criteria);
    }


    final class Of<T> implements StreamableIterable<T> {
        private final Iterable<T> _original;

        public Of(final Iterable<T> original) {
            this._original = original;
        }

        @Override
        public Iterator<T> iterator() {
            return _original.iterator();
        }
    }
}
