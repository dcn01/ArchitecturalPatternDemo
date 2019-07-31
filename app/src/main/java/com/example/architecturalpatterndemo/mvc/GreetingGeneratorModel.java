package com.example.architecturalpatterndemo.mvc;

import android.graphics.Color;
import android.os.AsyncTask;
import android.widget.TextView;

// Model层，封装各种数据来源，和View层是直接通信的
public class GreetingGeneratorModel extends AsyncTask<Void, Void, Integer> {
    private String baseText;
    private TextView greetingTextView;

    public GreetingGeneratorModel(String baseText, TextView greetingTextView) {
        this.baseText = baseText;
        this.greetingTextView = greetingTextView;
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
        // Model层调用View
        if ("HelloWorld".equals(baseText)) {
            greetingTextView.setTextColor(Color.RED);
        } else {
            greetingTextView.setTextColor(Color.BLUE);
        }
        greetingTextView.setText(baseText + randomInt);
    }
}
