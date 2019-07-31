package com.example.architecturalpatterndemo.mvp.presenter;

import com.example.architecturalpatterndemo.mvp.GreetingGeneratorModel;
import com.example.architecturalpatterndemo.mvp.view.HelloWorldView;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

// Presenter层，逻辑控制层
public class HelloWorldPresenter extends MvpBasePresenter<HelloWorldView> {
    // Greeting Task is "business logic"
    private GreetingGeneratorModel greetingTask;

    private void cancelGreetingTaskIfRunning(){
        if (greetingTask != null){
            greetingTask.cancel(true);
        }
    }

    public void greetHello(){
        cancelGreetingTaskIfRunning();
        // 实现Model层的回调监听
        greetingTask = new GreetingGeneratorModel("HelloWorld", new GreetingGeneratorModel.GreetingTaskListener() {
            @Override
            public void onGreetingGenerated(String greetingText) {
                if (isViewAttached())
                getView().showHello(greetingText);
            }
        });
        greetingTask.execute();
    }

    public void greetGoodbye(){
        cancelGreetingTaskIfRunning();
        // 实现Model层的回调监听
        greetingTask = new GreetingGeneratorModel("Goodbye", new GreetingGeneratorModel.GreetingTaskListener(){
            public void onGreetingGenerated(String greetingText){
                if (isViewAttached())
                    getView().showGoodbye(greetingText);
            }
        });
        greetingTask.execute();
    }

    // Called when Activity gets destroyed, so cancel running background task
    public void detachView(boolean retainPresenterInstance){
        super.detachView(retainPresenterInstance);
        if (!retainPresenterInstance){
            cancelGreetingTaskIfRunning();
        }
    }
}
