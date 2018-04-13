package com.caojinhou.mvpframe.di.component;

import android.app.Activity;
import android.content.Context;

import com.caojinhou.mvpframe.di.module.FragmentModule;
import com.caojinhou.mvpframe.di.scope.ContextLife;
import com.caojinhou.mvpframe.di.scope.PerFragment;

import dagger.Component;

/**
 * Created by Eric on 2017/1/19.
 */
@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {
    @ContextLife("Activity")
    Context getActivityContext();

    @ContextLife("Application")
    Context getApplicationContext();

    Activity getActivity();


}
