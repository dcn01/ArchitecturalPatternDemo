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
            Thread.sleep(2000); // Simulate computing
        } catch (InterruptedException e) {
        }

        return (int) (Math.random() * 100);
    }

    @Override
    protected void onPostExecute(Integer randomInt) {
        greetingGeneratorObj.setBaseText(baseText + randomInt);
    }
}
