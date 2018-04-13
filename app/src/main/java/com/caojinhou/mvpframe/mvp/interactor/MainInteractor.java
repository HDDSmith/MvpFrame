package com.caojinhou.mvpframe.mvp.interactor;

import com.caojinhou.mvpframe.listener.RequestCallBack;

import rx.Subscription;

/**
 * Created by Administrator on 2018/4/12.
 */

public interface MainInteractor<T> {

    Subscription lodeMainData(final RequestCallBack<T> callBack,final String type);
}
