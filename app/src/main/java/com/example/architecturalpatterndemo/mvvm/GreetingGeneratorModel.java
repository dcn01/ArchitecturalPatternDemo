package com.example.architecturalpatterndemo.mvvm;

import android.os.AsyncTask;

// Model层，封装各种数据来源
public class GreetingGeneratorModel extends AsyncTask<Void, Void, Integer> {
    private String baseText;
    private GreetingGeneratorObj greetingGeneratorObj;

    public GreetingGeneratorModel(String baseText, GreetingGeneratorObj greetingGeneratorObj) {
        this.baseText = baseText;
        this.greetingGeneratorObj = greetingGeneratorObj;
    }

    // Simulates computing and returns a random integer
    @Override
    protected Integer doInBackground(Void... params) {
        try {
            // Simulate computing
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }

        return (int) (Math.random() * 100);
    }

    @Override
    protected void onPostExecute(Integer randomInt) {
        // （3）ViewModel层调用ViewModel层
        greetingGeneratorObj.setBaseText(baseText + randomInt);
    }
}
