package com.edu.feicui.uidc.retrofit;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;

/**
 * Created by Administrator on 2017-1-9.
 */

public class RetrofitNetClient implements RetrofitApi {

    private static RetrofitNetClient mRetrofitNetClient;

    private final RetrofitApi mRetrofitApi;

    // 保证懒汉式的线程安全
    public static synchronized RetrofitNetClient getInstances(){
        if (mRetrofitNetClient == null) {
            mRetrofitNetClient = new RetrofitNetClient();
        }
        return mRetrofitNetClient;
    }

    public RetrofitNetClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();


        // Retrofit的初始化
        /**
         * 1. 可以给Retrofit设置OkHttpClient
         * 2. 必须要注意的地方：一定要设置baseUrl
         */
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://api.github.com")
                //添加gson转换器
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // 创建Retrofit的API接口：构建的过程
        mRetrofitApi = retrofit.create(RetrofitApi.class);

    }

    @Override
    public Call<ResponseBody> getData() {
        return mRetrofitApi.getData();
    }

    @Override
    public Call<ResponseBody> register(@Body String user) {


        return mRetrofitApi.register(user);
    }
}
