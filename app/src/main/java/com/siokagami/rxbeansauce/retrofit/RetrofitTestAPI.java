package com.siokagami.rxbeansauce.retrofit;


import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitTestAPI
{
    private static String BASE_URL = "https://api.douban.com/v2/";
    private static Retrofit mRetrrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    public static RetrofitAPIService retrofitAPIService = mRetrrofit.create(RetrofitAPIService.class);

}
