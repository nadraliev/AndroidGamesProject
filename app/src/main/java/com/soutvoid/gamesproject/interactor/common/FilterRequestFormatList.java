package com.soutvoid.gamesproject.interactor.common;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;

import java.util.Collection;
import java.util.HashSet;

/**
 * Коллеция из уникальных целочисленных элементов, преобразуемая в строку формата "1,2,3"
 */
public class FilterRequestFormatList extends HashSet<Integer> {

    public FilterRequestFormatList() {
    }

    public FilterRequestFormatList(Collection<Integer> c) {
        super(c);
    }

    @Override
    public String toString() {
        return Stream.of(this)
                .map(Object::toString)
                .collect(Collectors.joining(","));
    }
}