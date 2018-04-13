package com.caojinhou.mvpframe.di.component;

import android.content.Context;

import com.caojinhou.mvpframe.di.module.ServiceModule;
import com.caojinhou.mvpframe.di.scope.ContextLife;
import com.caojinhou.mvpframe.di.scope.PerService;

import dagger.Component;

/**
 * Created by Eric on 2017/1/19.
 */
@PerService
@Component(dependencies = ApplicationComponent.class, modules = ServiceModule.class)
public interface ServiceComponent {
    @ContextLife("Service")
    Context getServiceContext();

    @ContextLife("Application")
    Context getApplicationContext();
}
