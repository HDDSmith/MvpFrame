package com.caojinhou.mvpframe.listener;

/**
 * Created by Administrator on 2018/4/12.
 */

public interface RequestCallBack<T> {

    void beforeRequest();

    void success(T data);

    void onError(String errorMsg);
}
