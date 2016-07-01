package com.siokagami.rxbeansauce.model;


import com.siokagami.rxbeansauce.bean.Book;
import com.siokagami.rxbeansauce.retrofit.RetrofitTestAPI;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;


public class BookProfileModelImp implements BookProfileModel {

    private BookProfileOnListener bookProfileOnListener;

    public BookProfileModelImp(BookProfileOnListener bookProfileOnListener) {
        this.bookProfileOnListener = bookProfileOnListener;
    }

    @Override
    public void getBookProfile(String id) {
        Observable<Book> getBookProfile = RetrofitTestAPI.retrofitAPIService.bookProfile(id);
        getBookProfile
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Book>() {
                               @Override
                               public void call(Book book) {
                                bookProfileOnListener.onSuccsess(book);
                               }
                           },
                        new Action1<Throwable>() {
                            @Override
                            public void call(Throwable throwable) {
                                bookProfileOnListener.onFailure(throwable);
                            }
                        });
    }
    public interface BookProfileOnListener
    {
        void onSuccsess(Book book);
        void onFailure(Throwable e);
    }
}
