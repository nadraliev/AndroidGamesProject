package com.soutvoid.gamesproject.interactor.common

import java.util.*

/**
 * Коллеция из уникальных целочисленных элементов, преобразуемая в строку формата "1,2,3"
 */
class FilterRequestFormatList : HashSet<Int> {

    constructor() {}

    constructor(c: Collection<Int>) : super(c) {}

    override fun toString(): String {
        return this.mapIndexed { index, i -> i.toString() }.joinToString(",")
    }
}