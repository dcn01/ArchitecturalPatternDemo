package com.example.architecturalpatterndemo.mvp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.architecturalpatterndemo.R;
import com.example.architecturalpatterndemo.mvp.presenter.HelloWorldPresenter;
import com.example.architecturalpatterndemo.mvp.view.HelloWorldView;
import com.hannesdorfmann.mosby.mvp.MvpActivity;

// View层，视图层
public class MvpMainActivity extends MvpActivity<HelloWorldView, HelloWorldPresenter> implements HelloWorldView {
    TextView greetingTextView;
    Button helloButton;
    Button goodbyeButtonClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvpmain);
        greetingTextView = findViewById(R.id.greetingTextView);
        helloButton = findViewById(R.id.helloButton);
        goodbyeButtonClicked = findViewById(R.id.goodbyeButtonClicked);
        helloButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 调用Presenter层数据操作
                presenter.greetHello();
            }
        });
        goodbyeButtonClicked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 调用Presenter层数据操作
                presenter.greetGoodbye();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @NonNull
    @Override
    public HelloWorldPresenter createPresenter() {
        return new HelloWorldPresenter();
    }

    // 实现Mvp View 接口，具体对View的操作
    @Override
    public void showHello(String greetingText) {
        greetingTextView.setTextColor(Color.RED);
        greetingTextView.setText(greetingText);
    }

    // 实现Mvp View 接口，具体对View的操作
    @Override
    public void showGoodbye(String greetingText) {
        greetingTextView.setTextColor(Color.BLUE);
        greetingTextView.setText(greetingText);
    }
}
