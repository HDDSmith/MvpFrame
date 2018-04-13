package com.caojinhou.mvpframe.di.component;

import android.app.Activity;
import android.content.Context;

import com.caojinhou.mvpframe.di.module.ActivityModule;
import com.caojinhou.mvpframe.di.scope.ContextLife;
import com.caojinhou.mvpframe.di.scope.PerActivity;
import com.caojinhou.mvpframe.mvp.ui.activities.MainActivity;

import dagger.Component;

/**
 * Created by Eric on 2017/1/19.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    @ContextLife("Activity")
    Context getActivityContext();

    @ContextLife("Application")
    Context getApplicationContext();

    Activity getActivity();

    void inject(MainActivity mainActivity);
}
