package com.example.architecturalpatterndemo.mvvm;

import android.view.View;

public class MyHandlers {
    private GreetingGeneratorObj greetingGeneratorObj;

    public MyHandlers(GreetingGeneratorObj greetingGeneratorObj) {
        this.greetingGeneratorObj = greetingGeneratorObj;
    }

    public void onClickHello(View view) {
        // （2）ViewModel层调用Model层
        new GreetingGeneratorModel("HelloWorld", greetingGeneratorObj).execute();
    }

    public void onClickGoodbye(View view) {
        // （2）ViewModel层调用Model层
        new GreetingGeneratorModel("GoodBye", greetingGeneratorObj).execute();
    }
}
