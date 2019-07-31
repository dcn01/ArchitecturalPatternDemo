package com.example.architecturalpatterndemo.mvvm;

import android.util.Log;
import android.view.View;

public class MyHandlers {
    private GreetingGeneratorObj greetingGeneratorObj;

    public MyHandlers(GreetingGeneratorObj greetingGeneratorObj) {
        this.greetingGeneratorObj = greetingGeneratorObj;
    }

    public void onClickHello(View view) {
        Log.v("MyHandlers", "onClickHello");
        new GreetingGeneratorModel("HelloWorld", greetingGeneratorObj).execute();
    }

    public void onClickGoodbye(View view) {
        Log.v("MyHandlers", "onClickGoodbye");
        new GreetingGeneratorModel("GoodBye", greetingGeneratorObj).execute();
    }
}
