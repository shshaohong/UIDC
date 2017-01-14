package com.edu.feicui.uidc.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2017-1-9.
 */
//RetrofitApi接口的搭建
public interface RetrofitApi {


    //get请求，登录常用的
    @GET("/search/repositories?q=language:java&page=1")
    Call<ResponseBody> getData();

    //psot请求 注册常用的
    @POST("http://admin.syfeicuiedu.com/Handler/UserHandler.ashx?action=register")
    //body是请求体，如注册的账号和密码
    Call<ResponseBody> register(@Body String user);//ResponseBody  post请求响应体要用一个实体类来封装

}
