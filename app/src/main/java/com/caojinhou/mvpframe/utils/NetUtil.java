package com.caojinhou.mvpframe.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.caojinhou.mvpframe.App;
import com.caojinhou.mvpframe.R;

/**
 * Created by caojinhou on 2018/4/11.
 */


public class NetUtil {

    /**
     * 检查当前网络是否可用
     * @return 是否连接到网络
     */
    public static boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) App.getAppContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager != null) {
            NetworkInfo info = connectivityManager.getActiveNetworkInfo();
            if (info != null && info.isConnected()) {
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isNetworkErrThenShowMsg() {
        if (!isNetworkAvailable()) {
            //TODO: 刚启动app Snackbar不起作用，延迟显示也不好使，这是why？
            Toast.makeText(App.getAppContext(), App.getAppContext().getString(R.string.internet_error),
                    Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }
}
