package com.soutvoid.gamesproject.util;

/**
 * Created by andrew on 2/21/17.
 */

public interface Mapper<T, V> {
    V map(T key);
}
