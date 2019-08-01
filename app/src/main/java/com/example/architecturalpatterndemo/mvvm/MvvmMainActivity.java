package com.example.architecturalpatterndemo.mvvm;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.architecturalpatterndemo.R;
import com.example.architecturalpatterndemo.databinding.ActivityMvvmmainBinding;

public class MvvmMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMvvmmainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvmmain);
        GreetingGeneratorObj greetingGeneratorObj = new GreetingGeneratorObj("");
        // (1)按套路写好数据绑定，具体怎么实现双向数据绑定，都由DataBinding框架来完成
        // 数据绑定
        binding.setGreetingGeneratorObj(greetingGeneratorObj);
        // 事件绑定
        binding.setHandlers(new MyHandlers(greetingGeneratorObj));
    }

}
