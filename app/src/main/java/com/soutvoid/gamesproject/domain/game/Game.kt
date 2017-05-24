package com.soutvoid.gamesproject.domain.game

import com.soutvoid.gamesproject.domain.Image
import java.io.Serializable
import java.util.*

data class Game(
        val id: Int,
        val name: String,
        val slug: String?,
        val url: String?,
        val createdAt: Long?,
        val updatedAt: Long?,
        val summary: String?,
        val storyline: String?,
        val collection: Int?,
        val franchise: Long?,
        val rating: Double?,
        val rating_count: Int?,
        val hypes: Int?,
        val popularity: Double?,
        val aggregatedRating: Double?,
        val game: Long?,
        val developers: ArrayList<Int>?,
        val publishers: ArrayList<Int>?,
        val gameEngines: ArrayList<Long>?,
        val category: Int?,
        val timeToBeat: TimeToBeat?,
        val playerPerspectives: ArrayList<Int>?,
        val gameModes: ArrayList<Int>?,
        val keywords: ArrayList<Int>?,
        val themes: ArrayList<Int>?,
        val genres: ArrayList<Int>?,
        val firstReleaseDate: Long,
        val status: Int?,
        val releaseDates: ArrayList<ReleaseDate>?,
        val alternativeNames: ArrayList<AlternativeName>?,
        val screenshots: ArrayList<Image>?,
        val videos: ArrayList<Video>?,
        val cover: Image?,
        val esrb: Esrb?,
        val pegi: Pegi?
) : Serializable
