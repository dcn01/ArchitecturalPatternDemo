package com.example.architecturalpatterndemo.mvp;

import com.hannesdorfmann.mosby.mvp.MvpView;

// Mvp View 接口，定义对View的操作接口
public interface HelloWorldView extends MvpView {
    void showHello(String greetingText);

    void showGoodbye(String greetingText);
}
