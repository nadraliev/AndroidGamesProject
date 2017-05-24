package com.soutvoid.gamesproject.ui.screen.personalize

import com.agna.ferro.mvp.component.scope.PerScreen
import com.soutvoid.gamesproject.interactor.util.ExploreQuery
import com.soutvoid.gamesproject.ui.base.activity.BasePresenter
import com.soutvoid.gamesproject.ui.common.error.ErrorHandler
import io.realm.Realm
import javax.inject.Inject

@PerScreen
class PersonalizeActivityPresenter @Inject
constructor(errorHandler: ErrorHandler) : BasePresenter<PersonalizeActivityView>(errorHandler) {

    private var realm: Realm? = null

    override fun onLoad(viewRecreated: Boolean) {
        super.onLoad(viewRecreated)

    }

    override fun onResume() {
        super.onResume()
        refreshQueries()
    }

    @Synchronized private fun refreshQueries() {
        realm = Realm.getDefaultInstance()
        val exploreQueries = realm!!.where(ExploreQuery::class.java).findAll()
        view.setQueriesContent(realm!!.copyFromRealm(exploreQueries))
        realm!!.close()
    }
}
