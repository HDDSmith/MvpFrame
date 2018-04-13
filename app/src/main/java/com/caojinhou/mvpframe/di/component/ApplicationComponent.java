package com.caojinhou.mvpframe.di.component;

import android.content.Context;

import com.caojinhou.mvpframe.di.module.ApplicationModule;
import com.caojinhou.mvpframe.di.scope.ContextLife;
import com.caojinhou.mvpframe.di.scope.PerApp;

import dagger.Component;

/**
 * Created by Eric on 2017/1/19.
 */
@PerApp
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    @ContextLife("Application")
    Context getApplication();
}