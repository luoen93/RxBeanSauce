package com.siokagami.rxbeansauce;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.siokagami.rxbeansauce.bean.Book;
import com.siokagami.rxbeansauce.presenter.BookProfilePresenterImp;
import com.siokagami.rxbeansauce.view.BookProfileView;

public class MainActivity extends AppCompatActivity implements BookProfileView {
    TextView isbn10;
    TextView isbn13;
    private BookProfilePresenterImp bookProfilePresenterImp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isbn10 = (TextView)findViewById(R.id.isbn10);
        isbn13 = (TextView)findViewById(R.id.isbn13);
        bookProfilePresenterImp = new BookProfilePresenterImp(this);
        bookProfilePresenterImp.getBookProfile("7056972");

    }

    @Override
    public void setView(Book book) {
        isbn10.setText(book.getIsbn10());
        isbn13.setText(book.getIsbn13());
    }
}
