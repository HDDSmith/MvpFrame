package com.caojinhou.mvpframe.mvp.presenter.base;

import android.support.annotation.NonNull;

import com.caojinhou.mvpframe.mvp.view.BaseView;

/**
 * Created by Administrator on 2018/4/12.
 */

public interface BasePresenter {

    void onCreate();

    void attachView(@NonNull BaseView view);

    void onDestroy();
}
