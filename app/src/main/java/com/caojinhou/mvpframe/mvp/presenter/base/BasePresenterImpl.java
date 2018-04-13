package com.caojinhou.mvpframe.mvp.presenter.base;

import android.support.annotation.NonNull;

import com.caojinhou.mvpframe.listener.RequestCallBack;
import com.caojinhou.mvpframe.mvp.view.BaseView;
import com.caojinhou.mvpframe.utils.MyUtils;

import rx.Subscription;

/**
 * Created by Administrator on 2018/4/12.
 */

public class BasePresenterImpl<T extends BaseView,E> implements BasePresenter,RequestCallBack<E> {

    protected  T mView;
    protected Subscription mSubscription;

    @Override
    public void beforeRequest() {
        mView.showProgress();
    }

    @Override
    public void success(E data) {
        mView.hideProgress();
    }

    @Override
    public void onError(String errorMsg) {
        mView.hideProgress();
        mView.showMsg(errorMsg);
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void attachView(@NonNull BaseView view) {
            mView = (T) view;
    }

    @Override
    public void onDestroy() {
        MyUtils.cancelSubscription(mSubscription);
    }
}
