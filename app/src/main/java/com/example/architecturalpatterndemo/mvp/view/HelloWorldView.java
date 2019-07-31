package com.example.architecturalpatterndemo.mvp.view;

import com.hannesdorfmann.mosby.mvp.MvpView;

// Mvp View 接口，定义对View的操作接口
public interface HelloWorldView extends MvpView {
    // displays "Hello" greeting text in red text color
    void showHello(String greetingText);

    // displays "Goodbye" greeting text in blue text color
    void showGoodbye(String greetingText);
}
