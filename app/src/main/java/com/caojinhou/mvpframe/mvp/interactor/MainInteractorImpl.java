package com.caojinhou.mvpframe.mvp.interactor;

import com.caojinhou.mvpframe.common.HostType;
import com.caojinhou.mvpframe.listener.RequestCallBack;
import com.caojinhou.mvpframe.mvp.entity.MainData;
import com.caojinhou.mvpframe.repository.network.RetrofitManager;
import com.caojinhou.mvpframe.utils.MyUtils;
import com.caojinhou.mvpframe.utils.TransformUtils;

import java.util.Map;

import javax.inject.Inject;

import rx.Observer;
import rx.Subscription;
import rx.functions.Func1;

/**
 * Created by Administrator on 2018/4/12.
 */

public class MainInteractorImpl implements MainInteractor<MainData> {

    @Inject
    public MainInteractorImpl(){}


    @Override
    public Subscription lodeMainData(final RequestCallBack<MainData> callBack, final String post) {
        return RetrofitManager.getInstance(HostType.PHOTO).getMainDataObservable("PHOTO","1",20)
                .map(new Func1<Map<String,MainData>, MainData>() {

                    @Override
                    public MainData call(Map<String, MainData> stringMainDataMap) {
                        MainData mainData = stringMainDataMap.get(post);
                        return mainData;
                    }
                }).compose(TransformUtils.<MainData>defaultSchedulers())
                .subscribe(new Observer<MainData>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onError(MyUtils.analyzeNetworkError(e));
                    }

                    @Override
                    public void onNext(MainData mainData) {
                        callBack.success(mainData);
                    }
                });
        }
    }

