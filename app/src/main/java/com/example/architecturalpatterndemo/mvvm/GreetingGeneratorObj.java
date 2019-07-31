package com.example.architecturalpatterndemo.mvvm;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.architecturalpatterndemo.BR;

public class GreetingGeneratorObj extends BaseObservable {
    public static String baseText;

    public GreetingGeneratorObj(String baseText) {
        this.baseText = baseText;
    }

    @Bindable
    public String getBaseText() {
        return baseText;
    }

    public void setBaseText(String baseText) {
        GreetingGeneratorObj.baseText = baseText;
        notifyPropertyChanged(BR.baseText);
    }
}
