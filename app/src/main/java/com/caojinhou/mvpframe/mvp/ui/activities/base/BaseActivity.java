package com.caojinhou.mvpframe.mvp.ui.activities.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.WindowManager;

import com.caojinhou.mvpframe.App;
import com.caojinhou.mvpframe.R;
import com.caojinhou.mvpframe.di.component.ActivityComponent;
import com.caojinhou.mvpframe.di.component.DaggerActivityComponent;
import com.caojinhou.mvpframe.di.module.ActivityModule;
import com.caojinhou.mvpframe.mvp.presenter.base.BasePresenter;
import com.caojinhou.mvpframe.utils.MyUtils;
import com.caojinhou.mvpframe.utils.NetUtil;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.squareup.leakcanary.RefWatcher;

import butterknife.ButterKnife;
import rx.Subscription;

/**
 * Created by Administrator on 2018/4/11.
 */

public abstract class BaseActivity <T extends BasePresenter> extends AppCompatActivity {

    public Activity mActivity;

    protected ActivityComponent mActivityComponent;

    protected T mPresenter;

    protected Subscription mSubscription;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity=this;

        Log.i("MvpFrame",getClass().getSimpleName());

        NetUtil.isNetworkErrThenShowMsg();      //检测是否联网

        initActivityComponent();

        setStatusBarTranslucent();          //设置状态栏的颜色

        setContentView(getLayoutId());          //设置界面

        initInjector();         //dagger注入

        ButterKnife.bind(this);

        initViews();

        if (mPresenter != null) {
            mPresenter.onCreate();
        }
    }

    protected abstract void initViews();

    protected abstract void initInjector();

    protected abstract int getLayoutId();


    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void setStatusBarTranslucent() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintResource(R.color.colorPrimary);
        }
    }


    private void initActivityComponent() {

        mActivityComponent = DaggerActivityComponent.builder()
                .applicationComponent(((App) getApplication()).getApplicationComponent())
                .activityModule(new ActivityModule(this))
                .build();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    //onDestroy执行比较晚，在stop中释放资源
    @Override
    protected void onStop() {
        super.onStop();
        if(isFinishing()) {
            MyUtils.cancelSubscription(mSubscription);
            MyUtils.fixInputMethodManagerLeak(this);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RefWatcher refWatcher = App.getRefWatcher(this);
        refWatcher.watch(this);

        if (mPresenter != null) {
            mPresenter.onDestroy();
        }

    }



}
