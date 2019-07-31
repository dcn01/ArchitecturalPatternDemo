package com.example.architecturalpatterndemo.mvp;

import android.os.AsyncTask;

// Model层，封装各种数据来源，对Prestener层提供接口
public class GreetingGeneratorModel extends AsyncTask<Void, Void, Integer> {
    // 异步任务中要定义回调监听
    public interface GreetingTaskListener{
        public void onGreetingGenerated(String greetingText);
    }

    private String baseText;
    private GreetingTaskListener listener;

    public GreetingGeneratorModel(String baseText, GreetingTaskListener listener){
        this.baseText = baseText;
        this.listener = listener;
    }

    // Simulates computing and returns a random integer
    @Override
    protected Integer doInBackground(Void... params) {
        try {
            Thread.sleep(2000); // Simulate computing
        } catch (InterruptedException e) { }

        return (int) (Math.random() * 100);
    }

    @Override
    protected void onPostExecute(Integer randomInt){
        listener.onGreetingGenerated(baseText + " "+randomInt);
    }
}
