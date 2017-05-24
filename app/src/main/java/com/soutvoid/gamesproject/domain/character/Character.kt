package com.soutvoid.gamesproject.domain.character

import com.soutvoid.gamesproject.domain.Image
import java.io.Serializable
import java.util.*


data class Character(
        var id: Int,
        var name: String,
        var createdAt: Long?,
        var updatedAt: Long?,
        var slug: String?,
        var url: String?,
        var mugShot: Image?,
        var gender: Int?,
        var akas: ArrayList<String>?,
        var species: Int?,
        var people: ArrayList<Int>,
        var games: ArrayList<Int>
) : Serializable
