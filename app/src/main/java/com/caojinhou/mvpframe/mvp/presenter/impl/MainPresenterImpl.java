package com.caojinhou.mvpframe.mvp.presenter.impl;

import com.caojinhou.mvpframe.mvp.entity.MainData;
import com.caojinhou.mvpframe.mvp.interactor.MainInteractor;
import com.caojinhou.mvpframe.mvp.presenter.MainPresenter;
import com.caojinhou.mvpframe.mvp.presenter.base.BasePresenterImpl;
import com.caojinhou.mvpframe.mvp.view.MainView;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/4/13.
 */

public class MainPresenterImpl extends BasePresenterImpl<MainView,MainData> implements MainPresenter {

    private MainInteractor<MainData> mMainInteractor;
    private String type;

    @Inject
    public MainPresenterImpl(MainInteractor<MainData> mMainInteractor) {
        this.mMainInteractor = mMainInteractor;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mSubscription=mMainInteractor.lodeMainData(this,type);
    }

    @Override
    public void success(MainData data) {
        super.success(data);
    }

    @Override
    public void setType(String type) {
        this.type=type;
    }
}
