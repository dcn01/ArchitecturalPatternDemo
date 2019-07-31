package com.example.architecturalpatterndemo.mvc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.architecturalpatterndemo.R;
import com.example.architecturalpatterndemo.mvp.MvpMainActivity;
import com.example.architecturalpatterndemo.mvvm.MvvmMainActivity;

// Activity就是Controller,也是View的一部分
public class MvcMainActivity extends AppCompatActivity {
    TextView greetingTextView;
    Button helloButton;
    Button goodbyeButtonClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvcmain);
        greetingTextView = findViewById(R.id.greetingTextView);
        helloButton = findViewById(R.id.helloButton);
        goodbyeButtonClicked = findViewById(R.id.goodbyeButtonClicked);
        helloButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Controller直接调用Model层
                new GreetingGeneratorModel("HelloWorld", greetingTextView).execute();
            }
        });
        goodbyeButtonClicked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new GreetingGeneratorModel("GoodBye", greetingTextView).execute();
            }
        });
    }

}
