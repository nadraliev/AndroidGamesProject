package com.soutvoid.gamesproject.ui.common.dagger;


import com.soutvoid.gamesproject.ui.base.activity.ActivityModule;
import com.soutvoid.gamesproject.ui.common.error.ErrorHandlerModule;

import dagger.Module;

@Module(includes = {
        ActivityModule.class,
        ErrorHandlerModule.class
})
public class ActivityViewModule {
}
