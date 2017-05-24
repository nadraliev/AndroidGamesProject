package com.soutvoid.gamesproject.interactor.util

import io.realm.RealmObject

data class Query(

        var searchQuery: String?,
        var fields: Fields?,
        var limit: Int = 20,
        var offset: Int,
        var order: Order?,
        var filter: Filter?

) : RealmObject()
