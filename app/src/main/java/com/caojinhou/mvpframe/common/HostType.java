package com.caojinhou.mvpframe.common;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


/**
 * Created by Administrator on 2018/4/13.
 */

public class HostType {

    public static final int TYPE_COUNT = 3;


    public static final int VIDEO = 1;


    public static final int PHOTO = 2;


    public static final int TEXT = 3;


    @IntDef({VIDEO, PHOTO, TEXT})
    @Retention(RetentionPolicy.SOURCE)
    public @interface HostTypeChecker {

    }
}
