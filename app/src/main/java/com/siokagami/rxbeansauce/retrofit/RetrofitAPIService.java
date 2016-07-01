package com.siokagami.rxbeansauce.retrofit;


import com.siokagami.rxbeansauce.bean.Book;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by leuxun on 2016/6/30.
 */
public interface RetrofitAPIService
{
    @GET("book/{id}")
    Observable<Book> bookProfile(@Path("id") String id);

}
