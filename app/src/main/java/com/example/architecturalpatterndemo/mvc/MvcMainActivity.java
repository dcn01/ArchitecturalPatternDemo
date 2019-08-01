package com.example.architecturalpatterndemo.mvc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.architecturalpatterndemo.R;

// Activity即是Controller,同时也是View的一部分
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
        // （1）View传递调用到Controller
        helloButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // （2）Controller直接调用Model层
                new GreetingGeneratorModel("HelloWorld", greetingTextView).execute();
            }
        });
        // （1）View传递调用到Controller
        goodbyeButtonClicked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // （2）Controller直接调用Model层
                new GreetingGeneratorModel("GoodBye", greetingTextView).execute();
            }
        });
    }
}
