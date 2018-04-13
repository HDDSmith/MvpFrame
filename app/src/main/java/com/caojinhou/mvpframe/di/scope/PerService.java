package com.caojinhou.mvpframe.di.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Administrator on 2018/4/11.
 */
@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface PerService {
}
