package com.soutvoid.gamesproject.ui.screen.personalize;

import com.soutvoid.gamesproject.ui.base.activity.BasePresenter;
import com.soutvoid.gamesproject.ui.common.error.ErrorHandler;

import javax.inject.Inject;

public class PersonalizeActivityPresenter extends BasePresenter<PersonalizeActivityView> {

    @Inject
    public PersonalizeActivityPresenter(ErrorHandler errorHandler) {
        super(errorHandler);
    }


}
