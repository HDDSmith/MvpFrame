package com.caojinhou.mvpframe.repository.network;

import com.caojinhou.mvpframe.mvp.entity.MainData;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Administrator on 2018/4/12.
 */

public interface MainService {

    @GET("nc/article/{type}/{id}/{startPage}-20.html")
    Observable<Map<String,MainData>> getDataList(
            @Header("Cache-Control") String cacheControl,
            @Path("type") String type,
            @Path("id") String id,
            @Path("startPage") int startPage);


}
