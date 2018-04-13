package com.caojinhou.mvpframe.di.module;

import android.content.Context;

import com.caojinhou.mvpframe.App;
import com.caojinhou.mvpframe.di.scope.ContextLife;
import com.caojinhou.mvpframe.di.scope.PerApp;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Eric on 2017/1/19.
 */
@Module
public class ApplicationModule {
    private App mApplication;

    public ApplicationModule(App application) {
        mApplication = application;
    }

    @Provides
    @PerApp
    @ContextLife("Application")
    public Context provideApplicationContext() {
        return mApplication.getApplicationContext();
    }
}
