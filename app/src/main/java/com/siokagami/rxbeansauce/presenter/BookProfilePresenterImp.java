package com.siokagami.rxbeansauce.presenter;

import android.util.Log;

import com.siokagami.rxbeansauce.bean.Book;
import com.siokagami.rxbeansauce.model.BookProfileModel;
import com.siokagami.rxbeansauce.model.BookProfileModelImp;
import com.siokagami.rxbeansauce.view.BookProfileView;


/**
 * Created by leuxun on 2016/7/1.
 */
public class BookProfilePresenterImp implements BookProfilePresenter,BookProfileModelImp.BookProfileOnListener {

    private BookProfileView bookProfileView;
    private BookProfileModel bookProfileModel;

    public BookProfilePresenterImp(BookProfileView bookProfileView) {
        this.bookProfileView = bookProfileView;
        this.bookProfileModel = new BookProfileModelImp(this);
    }

    @Override
    public void onSuccsess(Book book) {
        bookProfileView.setView(book);

    }

    @Override
    public void onFailure(Throwable e) {
        Log.d("siokagami",e.getMessage());
    }

    @Override
    public void getBookProfile(String id) {
        bookProfileModel.getBookProfile(id);
    }
}
