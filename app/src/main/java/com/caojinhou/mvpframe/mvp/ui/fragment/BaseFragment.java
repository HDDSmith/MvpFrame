package com.caojinhou.mvpframe.mvp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.caojinhou.mvpframe.App;
import com.caojinhou.mvpframe.di.component.DaggerFragmentComponent;
import com.caojinhou.mvpframe.di.component.FragmentComponent;
import com.caojinhou.mvpframe.di.module.FragmentModule;
import com.caojinhou.mvpframe.mvp.presenter.base.BasePresenter;
import com.caojinhou.mvpframe.utils.MyUtils;
import com.squareup.leakcanary.RefWatcher;

import butterknife.ButterKnife;
import rx.Subscription;

/**
 * Created by Administrator on 2018/4/12.
 */

public abstract class BaseFragment <T extends BasePresenter>extends Fragment {

    protected FragmentComponent mFragmentComponent;
    protected T mPresenter;

    private View mFragmentView;

    protected abstract int getLayoutId();

    protected abstract void initViews(View view);

    protected abstract void initInjector();

    protected Subscription mSubscription;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragmentComponent = DaggerFragmentComponent.builder()
                .applicationComponent(((App) getActivity().getApplication()).getApplicationComponent())
                .fragmentModule(new FragmentModule(this))
                .build();
        initInjector();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mFragmentView == null) {
            mFragmentView = inflater.inflate(getLayoutId(), container, false);
            ButterKnife.bind(this, mFragmentView);
            initViews(mFragmentView);
        }
        return mFragmentView;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        RefWatcher refWatcher = App.getRefWatcher(getActivity());
        refWatcher.watch(this);
        if (mPresenter != null) {
            mPresenter.onDestroy();
        }
        MyUtils.cancelSubscription(mSubscription);
    }
}
