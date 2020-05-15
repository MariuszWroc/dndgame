package com.games.hackandslash.util;

import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public final class StreamHelper {

    public static <T> Stream<T> getStreamFromIterable(Iterable<T> iterable) {
        Spliterator<T> spliterator = iterable.spliterator();
        return StreamSupport.stream(spliterator, false);
    }

    public static <T> Iterable<T> getIterableFromStream(Stream<T> stream) {
        return stream::iterator;
    }
}
