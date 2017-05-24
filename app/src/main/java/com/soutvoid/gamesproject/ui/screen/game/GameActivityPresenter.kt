package com.soutvoid.gamesproject.ui.screen.game

import com.agna.ferro.mvp.component.scope.PerScreen
import com.soutvoid.gamesproject.domain.game.Game
import com.soutvoid.gamesproject.domain.game.enums.GameStatus
import com.soutvoid.gamesproject.ui.base.activity.BasePresenter
import com.soutvoid.gamesproject.ui.common.error.ErrorHandler
import java.io.File
import java.util.*
import javax.inject.Inject

@PerScreen
class GameActivityPresenter @Inject
constructor(errorHandler: ErrorHandler) : BasePresenter<GameActivityView>(errorHandler) {

    private var game: Game? = null

    override fun onLoad(viewRecreated: Boolean) {
        super.onLoad(viewRecreated)

        game = view.intent.getSerializableExtra("game") as Game
    }

    override fun onLoadFinished() {
        super.onLoadFinished()

        fillInfo()
    }

    private fun fillInfo() {
        if (game!!.screenshots != null && game!!.screenshots!!.size > 0)
            view.downloadTopImage(game!!.screenshots!![0].getUrl())


        if (game!!.cover != null)
            view.downloadCover(game!!.cover!!.getUrl())

        view.showTitle(game!!.name)

        val calendar = Calendar.getInstance()
        calendar.timeInMillis = game!!.firstReleaseDate
        view.showYear(calendar.get(Calendar.YEAR).toString())


        var status = ""
        if (game!!.status != null)
            status = GameStatus.values()[game!!.status!!].value
        else {
            if (Calendar.getInstance().timeInMillis > game!!.firstReleaseDate)
                status = GameStatus.values()[0].value
            else
                status = GameStatus.values()[4].value
        }
        view.showStatus(status)
    }

    internal fun mainImageDownloaded(file: File) {
        view.showTopImage(file)
        view.colorAsMainImage(file)
    }
}
